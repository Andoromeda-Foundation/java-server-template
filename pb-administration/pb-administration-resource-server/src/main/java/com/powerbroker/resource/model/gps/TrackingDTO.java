package com.powerbroker.resource.model.gps;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.powerbroker.common.service.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * @author william
 */
@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class TrackingDTO extends AbstractDTO {

    private String imei;

    @JsonProperty("device_info")
    private long deviceInfo;

    @JsonProperty("gps_time")
    private long gpsTime;

    @JsonProperty("sys_time")
    private long sysTime;

    @JsonProperty("heart_time")
    private long heartTime;

    @JsonProperty("server_time")
    private long serverTime;

    @JsonProperty("lng")
    private String longitude;

    @JsonProperty("lat")
    private String latitude;

    private long course;

    private long speed;

    private String status;
}
