package com.powerbroker.resource.model.geo;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by wjwjtftf on 2016/12/28.
 */
@Getter
@Setter
public class GeoResponse {

    private String status;
    private String info;
    private String infocode;
    private String count;
    private List<GeoCode> geocodes;
}
