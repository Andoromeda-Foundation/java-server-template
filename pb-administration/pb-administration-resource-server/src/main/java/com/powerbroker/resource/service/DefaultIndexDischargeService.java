package com.powerbroker.resource.service;

import com.powerbroker.report.data.utils.KeyManager;
import com.powerbroker.resource.model.IndexDischargeDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.*;

import static com.powerbroker.report.data.utils.IndexKey.*;

/**
 * @author william
 */
@Slf4j
@Service
public class DefaultIndexDischargeService extends AbstractIndexService<String, IndexDischargeDTO> implements
        IndexDischargeService {

    @Override
    public List<IndexDischargeDTO> realTime(IndexDischargeDTO indexDischargeDTO) {
        Date now = new Date();
        ValueOperations<String, Object> opsForValue = redisTemplate.opsForValue();
        String noMetricRedisKey = KeyManager.getNoMetricRedisKey(indexDischargeDTO);
        String timeKey = KeyManager.yyyyMMddHHmmssStandard.format(now);
        String realTimeKey = KeyManager.keyGenerate(":", noMetricRedisKey, indexDischargeDTO.getDevice(), REAL_TIME_DISCHARGE_KEY);
//        indexDischargeDTO.setKey(timeKey);
        String key = (String) opsForValue.get(realTimeKey);

        buildIndexDischarge(indexDischargeDTO, key);

        return Arrays.asList(indexDischargeDTO);
    }

    private void buildIndexDischarge(IndexDischargeDTO indexDischargeDTO, String key) {
        String[] keys = key.split("-");
        String[] stringValues = keys[0].split("\\|");
        indexDischargeDTO.setThreshold(Integer.valueOf(stringValues[0]));
        indexDischargeDTO.setMax(Integer.valueOf(stringValues[1]));
        indexDischargeDTO.setMin(Integer.valueOf(stringValues[2]));
        if (keys.length == 2) {
            try {
                indexDischargeDTO.setId(keys[1]);
                Date formattedDate = KeyManager.yyyyMMddHHmmss.parse(keys[1]);
                indexDischargeDTO.setKey(KeyManager.yyyyMMddHHmmssStandard.format(formattedDate));
            } catch (ParseException e) {
                log.error("error text {}", key);
            }
        }
    }

    @Override
    public List<IndexDischargeDTO> realTimeHistory(IndexDischargeDTO condition) {
//        ListOperations<String, Object> opsForList = redisTemplate.opsForList();
        ZSetOperations<String, Object> opsForZSet = redisTemplate.opsForZSet();
        String noMetricRedisKey = KeyManager.getNoMetricRedisKey(condition);
//        String realTimeListKey = KeyManager.keyGenerate(":", noMetricRedisKey, condition.getDevice(), REAL_TIME_DISCHARGE_LIST_KEY);
        String realTimeSetKey = KeyManager.keyGenerate(":", noMetricRedisKey, condition.getDevice(),
                REAL_TIME_DISCHARGE_SET_KEY);
        Set<Object> list = opsForZSet.range(realTimeSetKey, 0, -1);

        List<IndexDischargeDTO> results = new ArrayList<>();

        for (Object item : list) {
            String key = (String) item;

            IndexDischargeDTO indexDischargeDTO = new IndexDischargeDTO();

            buildIndexDischarge(indexDischargeDTO, key);
            results.add(indexDischargeDTO);
        }

        return results;
    }

    @Override
    public Set<Object> deviceList(IndexDischargeDTO condition) {
        SetOperations<String, Object> opsForSet = redisTemplate.opsForSet();
        String noMetricRedisKey = KeyManager.getNoMetricRedisKey(condition);
        String dischargeDeviceSetKey = KeyManager.keyGenerate(":", noMetricRedisKey, DISCHARGE_DEVICE_SET_KEY);
        Set<Object> deviceList = opsForSet.members(dischargeDeviceSetKey);
        return deviceList;
    }
}
