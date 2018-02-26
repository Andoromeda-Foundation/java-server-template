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
public class TraceDTO extends AbstractDTO {

    private BigDecimal longitude;
    private BigDecimal latitude;
    private LocalDateTime committedAt;
    private LightRewardDTO reward;
}
