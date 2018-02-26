package com.powerbroker.resource.model;

import com.powerbroker.common.service.IdentifierAwareDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * @author wjwjtftf
 *         Created on 2017/1/11.
 */
@Getter
@Setter
public class TaskDTO implements IdentifierAwareDTO {

    private String id;
    private String name;
    private String staffId;
}
