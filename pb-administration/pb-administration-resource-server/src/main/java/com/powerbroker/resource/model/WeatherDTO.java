package com.powerbroker.resource.model;

import com.powerbroker.common.service.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * @author william
 */
@Setter
@Getter
public class WeatherDTO extends AbstractDTO {

    private String id = "WTW3SJ5ZBJUY";

    private String code;

    private String temperature;

    private String text;
}
