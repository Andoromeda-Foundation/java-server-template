package com.powerbroker.resource.model;

import com.powerbroker.common.service.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author william
 */
@Setter
@Getter
public class MdRequestDTO extends AbstractDTO {

    private BigDecimal mdRequest;
    private BigDecimal limitPercentage;
    private BigDecimal threshold;
}
