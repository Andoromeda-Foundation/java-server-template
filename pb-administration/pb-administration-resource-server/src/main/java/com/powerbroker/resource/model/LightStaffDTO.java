package com.powerbroker.resource.model;

import com.powerbroker.common.service.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * @author william
 */
@Setter
@Getter
public class LightStaffDTO extends AbstractDTO {

    private String name;
    private String no;
    private Integer gender;
    private LocalDate birthday;
    private String idCardNo;
    private String birthplace;
    private String phone;
    private String email;
    private String remark;
    private String mobile;
    private String major;
    private LocalDate graduatedAt;
    private String title;
    private String level;
    private String workType;
    private String permission;
    private String position;
    private LocalDate enrolledAt;
    private int grade;
    private DocumentDTO avatar;
}
