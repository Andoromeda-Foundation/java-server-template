package com.powerbroker.resource.model;

import com.powerbroker.common.service.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * @author william
 */
@Setter
@Getter
public class SubstationOndutyGroupDTO extends AbstractDTO {

    private Long substationId;
    private String customerName;
    private String substationName;
    private String dutyDepartment;
    private String groupName;
    private String dutyMan;
    private String evaluationContent;
    private String remark;

    public String getEmployees() {
        return "";
    }
}
