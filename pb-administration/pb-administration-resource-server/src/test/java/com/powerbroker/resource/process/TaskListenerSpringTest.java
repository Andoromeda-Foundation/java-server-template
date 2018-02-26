package com.powerbroker.resource.process;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.HistoryService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.test.Deployment;
import org.activiti.spring.impl.test.SpringActivitiTestCase;
import org.springframework.test.context.ContextConfiguration;

import com.powerbroker.common.utils.DateTimeUtil;

/**
 * @author wjwjtftf
 *         Created on 2017/6/15.
 */
@ContextConfiguration("classpath:process/TaskListenerExpressTest-context.xml")
public class TaskListenerSpringTest extends SpringActivitiTestCase {

	@Deployment(resources = "processes/reward.bpmn")
	public void testTaskListenerDelegateExpression() {

		Map<String, Object> variables = new HashMap<>();

		// 启动流程并返回流程实例
		// variables.put("taskCompleteListener", new TaskCompleteListener());
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
