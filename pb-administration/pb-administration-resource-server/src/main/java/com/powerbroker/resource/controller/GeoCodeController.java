package com.powerbroker.resource.controller;

import com.powerbroker.resource.model.geo.GeoRequest;
import com.powerbroker.resource.service.GeoCodeService;
import com.powerbroker.common.handler.ControllerTemplate;
import com.powerbroker.common.handler.GenericResponse;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import lombok.Setter;

/**
 * Created by wjwjtftf on 2016/12/28.
 */
@RestController
@RequestMapping(value = "/geo")
public class GeoCodeController {

    @Setter
    @Resource
    private GeoCodeService geoCodeService;

    @RequestMapping(method = RequestMethod.POST)
    public GenericResponse<String> geo(@RequestBody GeoRequest request) throws Exception {

        return ControllerTemplate.call((GenericResponse<String> response) -> {

            response.setData(geoCodeService.geo(request.getCityName(), request.getAddress()));

            response.setResult(true);
        });
    }
}
