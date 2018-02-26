package com.powerbroker.resource.model;

import com.powerbroker.common.service.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * @author william
 */
@Setter
@Getter
public class LightDeptDTO extends AbstractDTO {

    private String name;

    private String code;

    private String phonetic;

    private String remark;

    private EnterpriseDTO enterprise;
}
