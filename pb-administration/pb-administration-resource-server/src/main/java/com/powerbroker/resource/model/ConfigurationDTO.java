package com.powerbroker.resource.model;

import com.powerbroker.common.service.AbstractDTO;
import com.powerbroker.report.data.model.KeyValuePair;
import com.powerbroker.report.data.utils.KeyManager;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author william
 */
@Setter
@Getter
public class ConfigurationDTO extends AbstractDTO {

    private String stationIdentifier;
    private String lineIdentifier;
    private String queueName;

    private List<KeyValuePair> values = new ArrayList();

    public String getNoMetricRedisKey() {
        return KeyManager.keyGenerate(":", getQueueName().replace('.', '-'), getStationIdentifier());
    }
}
