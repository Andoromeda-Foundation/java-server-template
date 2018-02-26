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
public class DeptDTO extends LightDeptDTO {

    private LightDeptDTO superior;

    private List<LightDeptDTO> subordinates = new ArrayList<>();
}
