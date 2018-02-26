package com.powerbroker.resource.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author william
 */
@Setter
@Getter
public class GroupDTO extends LightGroupDTO {

    private LightGroupDTO superior;
    private List<LightGroupDTO> subordinates;
    private EnterpriseDTO enterprise;
}
