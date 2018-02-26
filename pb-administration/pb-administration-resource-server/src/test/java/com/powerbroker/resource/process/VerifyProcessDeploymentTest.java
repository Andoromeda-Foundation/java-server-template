package com.powerbroker.resource.process;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;

import com.powerbroker.common.utils.DateTimeUtil;
import com.powerbroker.resource.service.TaskCompleteListener;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by wjwjtftf on 2016/12/19.
 */
@Slf4j
public class VerifyProcessDeploymentTest {

	@Test
	public void testStartProcess() throws Exception {

		// 创建流程引擎，使用内存数据库
		ProcessEngine processEngine = ProcessEngineConfiguration.createStandaloneInMemProcessEngineConfiguration()
				.buildProcessEngine();

		// 部署流程定义文件
		RepositoryService repositoryService = processEngine.getRepositoryService();
		repositoryService.createDeployment().addClasspathResource("processes/reward.bpmn")
				.addClasspathResource("processes/reward.png").deploy();

		// 验证已部署流程定义
		ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
				.processDefinitionKey("reward").singleResult();
		log.info(processDefinition.getKey());
		assertEquals("reward", processDefinition.getKey());

		Map<String, Object> variables = new HashMap<>();

		// 启动流程并返回流程实例
		RuntimeService runtimeService = processEngine.getRuntimeService();
		variables.put("taskCompleteListener", new TaskCompleteListener());
		variables.put("applyUserId", "我是任务发起者");
		variables.put("assigned", false);
		variables.put("deptLeaders", "小唐的领导1,小唐的领导2");
		variables.put("dueDate", DateTimeUtil.convert(LocalDateTime.now().plusDays(7)));
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("reward", variables);
		assertNotNull(processInstance);
		log.info("pid=" + processInstance.getId() + ", pdid=" + processInstance.getProcessDefinitionId());

		// 发布 - 查询任务
		TaskService taskService = processEngine.getTaskService();
		Task taskOfEngineer = taskService.createTaskQuery().taskCandidateGroup("engineer").singleResult();
		assertNotNull(taskOfEngineer);
		assertEquals("发布", taskOfEngineer.getName());

		// 接受 - 签收／完成任务
		taskService.claim(taskOfEngineer.getId(), "小唐");
		variables = new HashMap<>();
		variables.put("engineerId", "小唐");
		taskService.complete(taskOfEngineer.getId(), variables);

		// 现场 - 查询／完成任务
		taskOfEngineer = taskService.createTaskQuery().taskCandidateOrAssigned("小唐").singleResult();
		assertEquals("现场", taskOfEngineer.getName());
		taskService.complete(taskOfEngineer.getId());

		// 完成 - 查询／完成任务
		taskOfEngineer = taskService.createTaskQuery().taskCandidateOrAssigned("小唐").singleResult();
		assertEquals("完成", taskOfEngineer.getName());
		taskService.complete(taskOfEngineer.getId());

		// 确认 - 查询／签收／完成任务
		taskOfEngineer = taskService.createTaskQuery().taskCandidateOrAssigned("小唐的领导1").singleResult();
		assertEquals("确认", taskOfEngineer.getName());
		taskService.claim(taskOfEngineer.getId(), "小唐的领导1");
		taskService.complete(taskOfEngineer.getId());

		// 查询任务历史
		HistoryService historyService = processEngine.getHistoryService();
		long count = historyService.createHistoricProcessInstanceQuery().finished().count();
		log.info("流程实例数量:{}", count);

		List<HistoricTaskInstance> htis = historyService.createHistoricTaskInstanceQuery().list();
		log.info("历史任务数量:{}", htis.size());

		// 启动指派流程
		variables = new HashMap<>();
		variables.put("dueDate", DateTimeUtil.convert(LocalDateTime.now().plusDays(7)));
		variables.put("assigned", true);
		variables.put("engineerId", "指派给小唐");
		variables.put("deptLeaders", "小唐的领导1,小唐的领导2");
		ProcessInstance processInstance2 = runtimeService.startProcessInstanceByKey("reward", variables);
		assertNotNull(processInstance2);
		log.info("pid=" + processInstance2.getId() + ", pdid=" + processInstance2.getProcessDefinitionId());

		// 现场 - 查询／完成任务
		taskOfEngineer = taskService.createTaskQuery().taskCandidateOrAssigned("指派给小唐").singleResult();
		assertEquals("现场", taskOfEngineer.getName());
		taskService.complete(taskOfEngineer.getId());
	}
}
