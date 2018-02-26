package com.powerbroker.resource.entity;

import com.powerbroker.common.domain.entity.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * @author william
 */
@Entity
@Setter
@Getter
@Table(name = "gpses")
public class Gps extends AbstractEntity<Long> {

    private String imei;
    private String accessToken;
    private Long expiresIn;
    private Date expiresDate;
    private String mobileNum;
    private String remark;

    @Transient
    private final String mapType = "GOOGLE";

    @ManyToOne
    @JoinColumn(name = "gps_account_id")
    private GpsAccount account;
}
