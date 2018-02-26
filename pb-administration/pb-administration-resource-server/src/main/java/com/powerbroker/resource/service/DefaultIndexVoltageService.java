package com.powerbroker.resource.service;

import com.powerbroker.report.data.utils.KeyManager;
import com.powerbroker.report.data.utils.VoltageLine;
import com.powerbroker.resource.model.IndexVoltageDTO;
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
public class DefaultIndexVoltageService extends AbstractIndexService<String, IndexVoltageDTO> implements
        IndexVoltageService {

    @Override
    public IndexVoltageDTO aggregate(IndexVoltageDTO condition) {
        String dayKey = KeyManager.yyyyMMdd.format(new Date());

        ValueOperations<String, Object> opsForValue = redisTemplate.opsForValue();
        String noMetricRedisKey = KeyManager.getNoMetricRedisKey(condition);
        String minKey = KeyManager.keyGenerate(":", noMetricRedisKey, condition
                .getVoltageLine().getKeys()[0], dayKey);
        String maxKey = KeyManager.keyGenerate(":", noMetricRedisKey, condition
                .getVoltageLine().getKeys()[1], dayKey);
        String avgKey = KeyManager.keyGenerate(":", noMetricRedisKey, condition
                .getVoltageLine().getKeys()[2], dayKey);

        condition.setMin(setIfNull((BigDecimal) opsForValue.get(minKey)));
        condition.setMax(setIfNull((BigDecimal) opsForValue.get(maxKey)));
        condition.setAvg(setIfNull((BigDecimal) opsForValue.get(avgKey)));
        return condition;
    }

    @Override
    public List<IndexVoltageDTO> realTime(IndexVoltageDTO indexDischargeDTO) {

        String lineKey = KeyManager.getNoMetricRedisKey(indexDischargeDTO);

        String realTimeKey = null;

        if (indexDischargeDTO.getVoltageLine().equals(VoltageLine.AB)) {
            realTimeKey = KeyManager.keyGenerate(":", lineKey, REAL_TIME_VOLTAGE_AB_KEY);
        } else if (indexDischargeDTO.getVoltageLine().equals(VoltageLine.BC)) {
            realTimeKey = KeyManager.keyGenerate(":", lineKey, REAL_TIME_VOLTAGE_BC_KEY);
        } else if (indexDischargeDTO.getVoltageLine().equals(VoltageLine.CA)) {
            realTimeKey = KeyManager.keyGenerate(":", lineKey, REAL_TIME_VOLTAGE_CA_KEY);
        }

        ValueOperations<String, Object> opsForValue = redisTemplate.opsForValue();
        Double value = (Double) opsForValue.get(realTimeKey);

        IndexVoltageDTO indexVoltageDTO = new IndexVoltageDTO();
        indexVoltageDTO.setValue(setIfNull(BigDecimal.valueOf(value)));

        List<IndexVoltageDTO> results = new ArrayList<>();

        results.add(indexVoltageDTO);

        return results;
    }

    @Override
    public List<IndexVoltageDTO> history(IndexVoltageDTO condition) throws ParseException {
        Assert.notNull(condition);
        Assert.notNull(condition.getMetricAt());

        Date now = new Date();
        Date metricAt = Date.from(condition.getMetricAt().atZone(ZoneId.systemDefault()).toInstant());

        List<IndexVoltageDTO> result = new ArrayList<>();
        ValueOperations<String, Object> opsForValue = redisTemplate.opsForValue();

        String noMetricRedisKey = KeyManager.getNoMetricRedisKey(condition);

        Calendar calendar = Calendar.getInstance();

        while (true) {

            if (metricAt.compareTo(now) > 0) {
                break;
            }

            String metricHourKey = KeyManager.yyyyMMddHH.format(metricAt);
            String fixHourKey = null;
            if (condition.getVoltageLine().equals(VoltageLine.AB)) {
                fixHourKey = AVG_VOLTAGE_AB_HOUR_KEY;
            } else if (condition.getVoltageLine().equals(VoltageLine.BC)) {
                fixHourKey = AVG_VOLTAGE_BC_HOUR_KEY;
            } else if (condition.getVoltageLine().equals(VoltageLine.CA)) {
                fixHourKey = AVG_VOLTAGE_CA_HOUR_KEY;
            }

            String hourKey = KeyManager.keyGenerate(":", noMetricRedisKey, fixHourKey, metricHourKey);
            BigDecimal avgHourVoltage = (BigDecimal) opsForValue.get(hourKey);

            IndexVoltageDTO indexVoltageDTO = new IndexVoltageDTO();
            setKeyAndValue(indexVoltageDTO, metricHourKey, avgHourVoltage);

            calendar.setTime(metricAt);
            calendar.add(Calendar.HOUR_OF_DAY, 1);
            metricAt = calendar.getTime();

            result.add(indexVoltageDTO);
        }

        return result;
    }

    private void setKeyAndValue(IndexVoltageDTO dto, String key, BigDecimal value) {

        dto.setKey(key);
        dto.setValue(setIfNull(value));
    }

    @Override
    public List<IndexVoltageDTO> historyMaxByDay(IndexVoltageDTO condition) throws ParseException {
        return getMaxOrMinCurrent(condition, MAX_VOLTAGE_DAY_KEY);
    }

    @Override
    public List<IndexVoltageDTO> historyMinByDay(IndexVoltageDTO condition) throws ParseException {
        return getMaxOrMinCurrent(condition, MIN_VOLTAGE_DAY_KEY);
    }

    private List<IndexVoltageDTO> getMaxOrMinCurrent(IndexVoltageDTO condition, String fixDayKey) throws
            ParseException {
        Assert.notNull(condition, "should not be null");
        Assert.notNull(condition.getMetricAt(), "should not be null");

        Date now = new Date();
        Date metricAt = Date.from(condition.getMetricAt().atZone(ZoneId.systemDefault()).toInstant());

        List<IndexVoltageDTO> result = new ArrayList<>();
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

            IndexVoltageDTO indexVoltageDTO = new IndexVoltageDTO();
            setKeyAndValue(indexVoltageDTO, metricDayKey, value);

            calendar.setTime(metricAt);
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            metricAt = calendar.getTime();

            result.add(indexVoltageDTO);
        }

        return result;
    }
}
