package com.powerbroker.resource.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author william
 */
@Setter
@Getter
public class NavDTO extends LightNavDTO {

    private List<LightSidebarDTO> sidebars;
}
