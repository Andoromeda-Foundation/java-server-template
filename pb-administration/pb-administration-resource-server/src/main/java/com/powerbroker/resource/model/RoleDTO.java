package com.powerbroker.resource.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author william
 */
@Setter
@Getter
public class RoleDTO extends LightRoleDTO {

    private List<NavDTO> navs = new ArrayList<>(0);

    private List<LightSidebarDTO> sidebars = new ArrayList<>(0);
}
