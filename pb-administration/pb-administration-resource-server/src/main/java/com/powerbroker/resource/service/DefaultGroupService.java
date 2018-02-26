package com.powerbroker.resource.service;

import com.powerbroker.common.service.AbstractJPAService;
import com.powerbroker.common.utils.StringUtil;
import com.powerbroker.common.utils.ValueUtil;
import com.powerbroker.resource.dao.GroupDAO;
import com.powerbroker.resource.entity.Group;
import com.powerbroker.resource.model.GroupDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author william
 */
@Service
@Transactional
public class DefaultGroupService extends AbstractJPAService<Long, GroupDTO, Group, GroupDAO> implements GroupService {

    private String path(Group target) {
        return String.join(":", ValueUtil.idEncode(target.getId()), target.getName());
    }

    @Override
    protected void createHandler(Group target) {
        super.createHandler(target);

        if (null != target.getSuperior()) {
            String path = path(target.getSuperior());

            Group superior = this.dao.findOne(target.getSuperior().getId());

            if (StringUtil.hasText(superior.getPath())) {
                path = String.join("-", superior.getPath(), path);
            }

            target.setPath(path);
        }
    }

    @Override
    protected void updateHandler(Group target) {
        super.updateHandler(target);

        if (null != target.getSuperior()) {
            String path = path(target.getSuperior());

            Group superior = this.dao.findOne(target.getSuperior().getId());

            if (StringUtil.hasText(superior.getPath())) {
                path = String.join("-", superior.getPath(), path);
            }

            target.setPath(path);
        }
    }
}
