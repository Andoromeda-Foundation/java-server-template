package com.powerbroker.resource.service;

import com.powerbroker.report.data.model.KeyValuePair;
import com.powerbroker.report.data.utils.KeyManager;
import com.powerbroker.resource.model.IndexLoadDTO;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.text.ParseException;
import java.time.ZoneId;
import java.util.*;

import static com.powerbroker.report.data.utils.IndexKey.*;

/**
 * @author william
 */
@Service
public class DefaultIndexLoadService extends AbstractIndexService<String, IndexLoadDTO> implements
        IndexLoadService {

    @Override
    public IndexLoadDTO aggregate(IndexLoadDTO condition) {
        Date now = new Date();
        String hourKey = KeyManager.yyyyMMddHH.format(now);
        String dayKey = KeyManager.yyyyMMdd.format(now);
        String monthKey = KeyManager.yyyyMM.format(now);

        ValueOperations<String, Object> opsForValue = redisTemplate.opsForValue();
        String noMetricRedisKey = KeyManager.getNoMetricRedisKey(condition);
        String maxKey = KeyManager.keyGenerate(":", noMetricRedisKey, MAX_LOAD_KEY);
        String maxHourKey = KeyManager.keyGenerate(":", noMetricRedisKey, MAX_LOAD_HOUR_KEY, hourKey);
        String maxDayKey = KeyManager.keyGenerate(":", noMetricRedisKey, MAX_LOAD_DAY_KEY, dayKey);
        String maxMonthKey = KeyManager.keyGenerate(":", noMetricRedisKey, MAX_LOAD_MONTH_KEY, monthKey);

        condition.setMax(setIfNull((BigDecimal) opsForValue.get(maxKey)));
        condition.setMaxHour(setIfNull((BigDecimal) opsForValue.get(maxHourKey)));
        condition.setMaxDay(setIfNull((BigDecimal) opsForValue.get(maxDayKey)));
        condition.setMaxMonth(setIfNull((BigDecimal) opsForValue.get(maxMonthKey)));

        return condition;
    }

    @Override
    public List<IndexLoadDTO> history(IndexLoadDTO condition) throws ParseException {
        Assert.notNull(condition);
        Assert.notNull(condition.getMetricAt());

        Date now = new Date();
        Date metricAt = Date.from(condition.getMetricAt().atZone(ZoneId.systemDefault()).toInstant());

        List<IndexLoadDTO> result = new ArrayList<>();
        ValueOperations<String, Object> opsForValue = redisTemplate.opsForValue();

        String noMetricRedisKey = KeyManager.getNoMetricRedisKey(condition);

        Calendar calendar = Calendar.getInstance();

        while (true) {

            if (metricAt.compareTo(now) > 0) {
                break;
            }

            String metricHourKey = KeyManager.yyyyMMddHH.format(metricAt);
            String hourKey = KeyManager.keyGenerate(":", noMetricRedisKey, MAX_LOAD_HOUR_KEY, metricHourKey);
            BigDecimal maxHourLoad = (BigDecimal) opsForValue.get(hourKey);

            IndexLoadDTO indexLoadDTO = new IndexLoadDTO();
            setKeyAndValue(indexLoadDTO, metricHourKey, maxHourLoad);

            calendar.setTime(metricAt);
            calendar.add(Calendar.HOUR_OF_DAY, 1);
            metricAt = calendar.getTime();

            result.add(indexLoadDTO);
        }

        return result;
    }

    private void setKeyAndValue(IndexLoadDTO dto, String key, BigDecimal value) {

        dto.setKey(key);
        dto.setValue(setIfNull(value));
    }

    @Override
    public List<IndexLoadDTO> realTime(IndexLoadDTO indexDischargeDTO) {
        Date now = new Date();
        ValueOperations<String, Object> opsForValue = redisTemplate.opsForValue();
        String noMetricRedisKey = KeyManager.getNoMetricRedisKey(indexDischargeDTO);
        String timeKey = KeyManager.yyyyMMddHHmmssStandard.format(now);
        String realTimeKey = KeyManager.keyGenerate(":", noMetricRedisKey, REAL_TIME_LOAD_KEY);
        indexDischargeDTO.setKey(timeKey);
        indexDischargeDTO.setValue(setIfNull(BigDecimal.valueOf((Double) opsForValue.get(realTimeKey))));
        return Arrays.asList(indexDischargeDTO);
    }

    @Override
    public List<IndexLoadDTO> realTimeHistory(IndexLoadDTO condition) {
        ListOperations<String, Object> opsForList = redisTemplate.opsForList();
        String noMetricRedisKey = KeyManager.getNoMetricRedisKey(condition);
        String realTimeListKey = KeyManager.keyGenerate(":", noMetricRedisKey, REAL_TIME_LOAD_LIST_KEY);
        List<Object> list = opsForList.range(realTimeListKey, 0, -1);

        List<IndexLoadDTO> results = new ArrayList<>();

        for (Object item : list) {
            KeyValuePair<Double> keyValue = (KeyValuePair<Double>) item;

            IndexLoadDTO indexLoadDTO = new IndexLoadDTO();

            indexLoadDTO.setKey(keyValue.getKey());
            indexLoadDTO.setValue(BigDecimal.valueOf(keyValue.getValue()));

            results.add(indexLoadDTO);
        }

        return results;
    }
}
