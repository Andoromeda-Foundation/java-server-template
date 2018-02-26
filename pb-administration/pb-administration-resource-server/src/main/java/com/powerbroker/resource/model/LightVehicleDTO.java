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
public class LightVehicleDTO extends AbstractDTO {

    private String code;
    private String plate;
    private LocalDate purchasedAt;
    private String model;
    private String brand;
    private String license;
    private String purchaseEnterprise;
    private String purpose;
    private String fleet;
    private String principal;
}
