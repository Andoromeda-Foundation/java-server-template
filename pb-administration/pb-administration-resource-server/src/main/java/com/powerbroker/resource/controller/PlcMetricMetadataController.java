package com.powerbroker.resource.controller;

import com.powerbroker.common.handler.ControllerTemplate;
import com.powerbroker.common.handler.GenericResponse;
import com.powerbroker.common.service.PageableService;
import com.powerbroker.common.utils.ValueUtil;
import com.powerbroker.resource.model.PlcMetricMetadataDTO;
import com.powerbroker.resource.model.PlcMetricMetadataStatDTO;
import com.powerbroker.resource.service.PlcMetricMetadataService;
import com.powerbroker.common.handler.AbstractCRUDHandler;
import org.apache.commons.lang3.time.FastDateFormat;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author william
 */
@RestController
@RequestMapping(value = "/plcMetricMetadata")
public class PlcMetricMetadataController  {

    @Resource
    private PlcMetricMetadataService plcMetricMetadataService;

    private static  final FastDateFormat FAST_DATE_FORMAT = FastDateFormat.getInstance("yyyyMMddHHmmss");

    @RequestMapping(value = "/list/timeInterval/{time}", method = RequestMethod.GET)
    public GenericResponse<PlcMetricMetadataStatDTO> listByTimeInterval(@PathVariable(value = "time") String time) throws Exception {

        return ControllerTemplate.call((GenericResponse<PlcMetricMetadataStatDTO> response) -> {

            String datetime = getDateTime(time);

            PlcMetricMetadataStatDTO statDTO = plcMetricMetadataService.findPlcMetricMetadataStat(datetime);

            response.setData(statDTO);
            response.setResult(true);
        });
    }

    private String getDateTime(String time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(Long.valueOf(time));

         return FAST_DATE_FORMAT.format(calendar);
    }

    @RequestMapping(value = "/list/currentDate/{time}", method = RequestMethod.GET)
    public GenericResponse<List<PlcMetricMetadataStatDTO>> listByCurrentDate(@PathVariable(value = "time") String time) throws Exception {

        return ControllerTemplate.call((GenericResponse<List<PlcMetricMetadataStatDTO>> response) -> {

            String datetime  = getDateTime(time);

            List<PlcMetricMetadataStatDTO> statDTOs = plcMetricMetadataService.findCurrentDatePlcMetricMetadataStat(datetime);

            response.setData(statDTOs);
            response.setResult(true);
        });
    }


}