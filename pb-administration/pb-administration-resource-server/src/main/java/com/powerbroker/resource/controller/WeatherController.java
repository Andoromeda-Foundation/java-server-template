package com.powerbroker.resource.controller;

import com.powerbroker.resource.model.WeatherDTO;
import com.powerbroker.resource.service.WeatherService;
import com.powerbroker.common.handler.AbstractCRUDHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author william
 */
@RestController
@RequestMapping(value = "/weather")
public class WeatherController extends AbstractCRUDHandler<Long, WeatherDTO, WeatherService> {

}
