package com.powerbroker.resource.model.gps;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.powerbroker.common.service.AbstractDTO;
import com.powerbroker.common.utils.StringUtil;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author william
 */
@Setter
@Getter
public class GpsDTO extends AbstractDTO {

    private String imei;
    private String accessToken;
    private Long expiresIn;
    private Date expiresDate;
    private String mobileNum;
    private String remark;
    private String mapType;
    private AccountDTO account;
    private TrackingDTO tracking;

    @JsonIgnore
    public boolean isValid() {
        return StringUtil.hasText(accessToken) && null != expiresIn && new Date().before(expiresDate);
    }
}