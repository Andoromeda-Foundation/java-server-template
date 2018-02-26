package com.powerbroker.resource.model;

import com.powerbroker.common.service.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author william
 */
@Setter
@Getter
public class TourDTO extends AbstractDTO {

    private RfidDTO rfid;
    private LightRewardDTO reward;
    private Integer deviceState;
    private Boolean leak;
    private Boolean illumination;
    private Boolean animal;
    private Boolean security;
    private Boolean hygiene;
    private String content;
    private List<DocumentDTO> documents = new ArrayList<>();
}
