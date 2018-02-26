package com.powerbroker.resource.model;

import com.powerbroker.common.service.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author william
 */
@Setter
@Getter
public class DefectDTO extends AbstractDTO {

    private String customerName;
    private String stationName;
    private String source;
    private String primaryDevice;
    private String deviceAttachment;
    private String nature;
    private String content;
    private String discoverer;
    private LocalDateTime discoveryDate;
    private String liabilityCause;
    private String technicalReason;
    private String handleSuggestion;
    private String image;
    private LocalDateTime planDisposeDate;
    private RfidDTO rfid;
    private LightRewardDTO reward;
    private List<DocumentDTO> documents = new ArrayList<>();
}
