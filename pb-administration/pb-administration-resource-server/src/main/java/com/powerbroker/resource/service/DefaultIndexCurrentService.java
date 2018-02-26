package com.powerbroker.resource.service;

import com.powerbroker.report.data.utils.CurrentLine;
import com.powerbroker.report.data.utils.KeyManager;
import com.powerbroker.resource.model.IndexCurrentDTO;
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
public class DefaultIndexCurrentService extends AbstractIndexService<String, IndexCurrentDTO> implements
        IndexCurrentService {

    @Override
    public IndexCurrentDTO aggregate(IndexCurrentDTO condition) {
        String dayKey = KeyManager.yyyyMMdd.format(new Date());

        ValueOperations<String, Object> opsForValue = redisTemplate.opsForValue();
        String noMetricRedisKey = KeyManager.getNoMetricRedisKey(condition);
        condition.setMin(setIfNull((BigDecimal) opsForValue.get(KeyManager.keyGenerate(":",
                noMetricRedisKey, condition.getCurrentLine().getKeys()[0], dayKey))));
        condition.setMax(setIfNull((BigDecimal) opsForValue.get(KeyManager.keyGenerate(":",
                noMetricRedisKey, condition.getCurrentLine().getKeys()[1], dayKey))));
        condition.setAvg(setIfNull((BigDecimal) opsForValue.get(KeyManager.keyGenerate(":",
                noMetricRedisKey, condition.getCurrentLine().getKeys()[2], dayKey))));
        return condition;
    }

    @Override
    public List<IndexCurrentDTO> realTime(IndexCurrentDTO indexDischargeDTO) {

        String lineKey = KeyManager.getNoMetricRedisKey(indexDischargeDTO);

        String realTimeKey = null;

        if (indexDischargeDTO.getCurrentLine().equals(CurrentLine.A)) {
            realTimeKey = KeyManager.keyGenerate(":", lineKey, REAL_TIME_CURRENT_A_KEY);
        } else if (indexDischargeDTO.getCurrentLine().equals(CurrentLine.B)) {
            realTimeKey = KeyManager.keyGenerate(":", lineKey, REAL_TIME_CURRENT_B_KEY);
        } else if (indexDischargeDTO.getCurrentLine().equals(CurrentLine.C)) {
            realTimeKey = KeyManager.keyGenerate(":", lineKey, REAL_TIME_CURRENT_C_KEY);
        }

        ValueOperations<String, Object> opsForValue = redisTemplate.opsForValue();
        Double value = (Double) opsForValue.get(realTimeKey);

        IndexCurrentDTO indexCurrentDTO = new IndexCurrentDTO();
        indexCurrentDTO.setValue(setIfNull(BigDecimal.valueOf(value)));

        List<IndexCurrentDTO> results = new ArrayList<>();

        results.add(indexCurrentDTO);

        return results;
    }

    @Override
    public List<IndexCurrentDTO> history(IndexCurrentDTO condition) throws ParseException {
        Assert.notNull(condition);
        Assert.notNull(condition.getMetricAt());

        Date now = new Date();
        Date metricAt = Date.from(condition.getMetricAt().atZone(ZoneId.systemDefault()).toInstant());

        List<IndexCurrentDTO> result = new ArrayList<>();
        ValueOperations<String, Object> opsForValue = redisTemplate.opsForValue();

        String noMetricRedisKey = KeyManager.getNoMetricRedisKey(condition);

        Calendar calendar = Calendar.getInstance();

        while (true) {

            if (metricAt.compareTo(now) > 0) {
                break;
            }

            String metricHourKey = KeyManager.yyyyMMddHH.format(metricAt);
            String fixHourKey = null;
            if (condition.getCurrentLine().equals(CurrentLine.A)) {
                fixHourKey = AVG_CURRENT_A_HOUR_KEY;
            } else if (condition.getCurrentLine().equals(CurrentLine.B)) {
                fixHourKey = AVG_CURRENT_B_HOUR_KEY;
            } else if (condition.getCurrentLine().equals(CurrentLine.C)) {
                fixHourKey = AVG_CURRENT_C_HOUR_KEY;
            }

            String hourKey = KeyManager.keyGenerate(":", noMetricRedisKey, fixHourKey, metricHourKey);
            BigDecimal avgHourCurrent = (BigDecimal) opsForValue.get(hourKey);

            IndexCurrentDTO indexCurrentDTO = new IndexCurrentDTO();
            setKeyAndValue(indexCurrentDTO, metricHourKey, avgHourCurrent);

            calendar.setTime(metricAt);
            calendar.add(Calendar.HOUR_OF_DAY, 1);
            metricAt = calendar.getTime();

            result.add(indexCurrentDTO);
        }

        return result;
    }

    private void setKeyAndValue(IndexCurrentDTO dto, String key, BigDecimal value) {

        dto.setKey(key);
        dto.setValue(setIfNull(value));
    }

    @Override
    public List<IndexCurrentDTO> historyMaxByDay(IndexCurrentDTO condition) throws ParseException {
        return getMaxOrMinCurrent(condition, MAX_CURRENT_DAY_KEY);
    }

    @Override
    public List<IndexCurrentDTO> historyMinByDay(IndexCurrentDTO condition) throws ParseException {
        return getMaxOrMinCurrent(condition, MIN_CURRENT_DAY_KEY);
    }

    private List<IndexCurrentDTO> getMaxOrMinCurrent(IndexCurrentDTO condition, String fixDayKey) throws
            ParseException {
        Assert.notNull(condition, "should not be null");
        Assert.notNull(condition.getMetricAt(), "should not be null");

        Date now = new Date();
        Date metricAt = Date.from(condition.getMetricAt().atZone(ZoneId.systemDefault()).toInstant());

        List<IndexCurrentDTO> result = new ArrayList<>();
        ValueOperations<String, Object> opsForValue = redisTemplate.opsForValue();
        String metricRedisKey = KeyManager.getNoMetricRedisKey(condition);

        Calendar calendar = Calendar.getInstance();

        while (true) {

            if (metricAt.compareTo(now) > 0) {
                break;
            }

            String metricDayKey = KeyManager.yyyyMMdd.format(metricAt);
            String dayKey = KeyManager.keyGenerate(":", metricRedisKey, fixDayKey, metricDayKey);
            BigDecimal value = (BigDecimal) opsForValue.get(dayKey);

            IndexCurrentDTO indexCurrentDTO = new IndexCurrentDTO();
            setKeyAndValue(indexCurrentDTO, metricDayKey, value);

            calendar.setTime(metricAt);
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            metricAt = calendar.getTime();

            result.add(indexCurrentDTO);
        }

        return result;
    }
}
