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
public class RegularEvaluationDTO extends AbstractDTO {

    private String evaluationProject;

    private String evaluationContent;

    private String evaluationPeriod;

    private String evaluationSubject;

    private String evaluator;

    private LightPowerStationDTO powerStation;

    private LocalDate evaluatedAt;
    private String state;
    private String deviceCount;
    private String finishingRate;
    private String workingScore;
    private String clientScore;
    private String allScore;

}
