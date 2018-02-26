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
public class UserDTO extends LightUserDTO {

    private StaffDTO staff;

    private List<LightRoleDTO> roles = new ArrayList<>(0);
}
