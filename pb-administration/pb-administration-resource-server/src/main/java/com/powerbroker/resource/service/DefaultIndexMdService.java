package com.powerbroker.resource.service;

import com.powerbroker.report.data.utils.KeyManager;
import com.powerbroker.resource.model.IndexMdDTO;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.text.ParseException;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static com.powerbroker.report.data.utils.IndexKey.*;


/**
 * @author william
 */
@Service
public class DefaultIndexMdService extends AbstractIndexService<String, IndexMdDTO> implements
        IndexMdService {

    @Override
    public IndexMdDTO aggregate(IndexMdDTO condition) {
        Date now = new Date();
        String hourKey = KeyManager.yyyyMMddHH.format(now);
        String dayKey = KeyManager.yyyyMMdd.format(now);
        String monthKey = KeyManager.yyyyMM.format(now);

        ValueOperations<String, Object> opsForValue = redisTemplate.opsForValue();
        String noMetricRedisKey = KeyManager.getNoMetricRedisKey(condition);
        String maxKey = KeyManager.keyGenerate(":", noMetricRedisKey, MAX_MD_KEY);
        String maxHourKey = KeyManager.keyGenerate(":", noMetricRedisKey, MAX_MD_HOUR_KEY, hourKey);
        String maxDayKey = KeyManager.keyGenerate(":", noMetricRedisKey, MAX_MD_DAY_KEY, dayKey);
        String maxMonthKey = KeyManager.keyGenerate(":", noMetricRedisKey, MAX_MD_MONTH_KEY, monthKey);

        condition.setMax(setIfNull((BigDecimal) opsForValue.get(maxKey)));
        condition.setMaxHour(setIfNull((BigDecimal) opsForValue.get(maxHourKey)));
        condition.setMaxDay(setIfNull((BigDecimal) opsForValue.get(maxDayKey)));
        condition.setMaxMonth(setIfNull((BigDecimal) opsForValue.get(maxMonthKey)));

        return condition;
    }

    @Override
    public List<IndexMdDTO> history(IndexMdDTO condition) throws ParseException {
        Assert.notNull(condition);
        Assert.notNull(condition.getMetricAt());

        Date now = new Date();
        Date metricAt = Date.from(condition.getMetricAt().atZone(ZoneId.systemDefault()).toInstant());

        List<IndexMdDTO> result = new ArrayList<>();
        ValueOperations<String, Object> opsForValue = redisTemplate.opsForValue();

        String noMetricRedisKey = KeyManager.getNoMetricRedisKey(condition);

        Calendar calendar = Calendar.getInstance();

        while (true) {

            if (metricAt.compareTo(now) > 0) {
                break;
            }

            String metricHourKey = KeyManager.yyyyMMddHH.format(metricAt);
            String hourKey = KeyManager.keyGenerate(":", noMetricRedisKey, MAX_MD_HOUR_KEY, metricHourKey);
            BigDecimal maxHourLoad = (BigDecimal) opsForValue.get(hourKey);

            IndexMdDTO indexMdDTO = new IndexMdDTO();
            setKeyAndValue(indexMdDTO, metricHourKey, maxHourLoad);

            calendar.setTime(metricAt);
            calendar.add(Calendar.HOUR_OF_DAY, 1);
            metricAt = calendar.getTime();

            result.add(indexMdDTO);
        }

        return result;
    }

    private void setKeyAndValue(IndexMdDTO dto, String key, BigDecimal value) {

        dto.setKey(key);
        dto.setValue(setIfNull(value));
    }
}
