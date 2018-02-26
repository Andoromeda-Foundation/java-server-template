package com.powerbroker.resource.service;

import com.powerbroker.report.data.model.KeyValuePair;
import com.powerbroker.report.data.utils.KeyManager;
import com.powerbroker.resource.model.IndexConfigurationDTO;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.powerbroker.report.data.utils.IndexKey.REAL_TIME_CONFIGURATION_KEY;

/**
 * @author william
 */
@Service
public class DefaultIndexConfigurationService extends AbstractIndexService<String, IndexConfigurationDTO> implements
        IndexConfigurationService {

    @Override
    public List<IndexConfigurationDTO> realTime(IndexConfigurationDTO indexDischargeDTO) {
        List<KeyValuePair<String>> pairs = (List<KeyValuePair<String>>) redisTemplate.opsForValue().get(KeyManager.keyGenerate(":", KeyManager
                .getNoMetricRedisKey(indexDischargeDTO), REAL_TIME_CONFIGURATION_KEY));

        List<IndexConfigurationDTO> results = null;

        if (!CollectionUtils.isEmpty(pairs)) {
            results = new ArrayList<>();

            for (KeyValuePair<String> pair : pairs) {
                IndexConfigurationDTO indexConfigurationDTO = new IndexConfigurationDTO();

                indexConfigurationDTO.setKey(pair.getKey());
                indexConfigurationDTO.setValue(new BigDecimal(pair.getValue()));

                results.add(indexConfigurationDTO);
            }
        }

        return results;
    }
}
