package com.powerbroker.resource.model.gps;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author william
 */
@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class TrackingListDTO extends GenericDTO {

    private List<TrackingDTO> data = new ArrayList<>();
}
