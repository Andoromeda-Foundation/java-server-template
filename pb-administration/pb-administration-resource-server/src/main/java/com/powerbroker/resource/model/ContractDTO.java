package com.powerbroker.resource.model;

import com.powerbroker.common.service.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author william
 */
@Setter
@Getter
public class ContractDTO extends AbstractDTO {

    private String code;
    private Integer type;
    private LightPowerStationDTO powerStation;
    private BigDecimal amount;
    private String clientPrincipal;
    private String clientPhone;
    private LocalDateTime signedAt;
    private LocalDateTime expiredAt;
    private String signedBy;
    private String custodianBy;
    private String remark;
    private DocumentDTO document;
}
