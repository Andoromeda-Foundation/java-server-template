package com.powerbroker.resource.model;

import com.powerbroker.common.service.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by T430 on 2017/2/4.
 */
@Setter
@Getter
public class PlcMetricMetadataStatSlotDTO extends AbstractDTO {

    private String time;

    private String node;

    private Long count;

}
