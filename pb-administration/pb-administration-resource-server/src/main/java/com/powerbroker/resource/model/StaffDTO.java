package com.powerbroker.resource.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author william
 */
@Setter
@Getter
public class StaffDTO extends LightStaffDTO {

    private LightDeptDTO dept;

    private LightEnterpriseDTO enterprise;

    private List<LightDistrictDTO> districts;
}
