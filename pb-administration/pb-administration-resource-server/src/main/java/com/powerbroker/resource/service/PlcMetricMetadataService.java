package com.powerbroker.resource.service;

import com.powerbroker.resource.entity.PlcMetricMetadata;
import com.powerbroker.resource.model.PlcMetricMetadataDTO;
import com.powerbroker.common.service.PageableService;
import com.powerbroker.resource.model.PlcMetricMetadataStatDTO;

import java.util.List;

/**
 * @author william
 */
public interface PlcMetricMetadataService {

    PlcMetricMetadataStatDTO findPlcMetricMetadataStat(String time);

    List<PlcMetricMetadataStatDTO> findCurrentDatePlcMetricMetadataStat(String time) ;
}
