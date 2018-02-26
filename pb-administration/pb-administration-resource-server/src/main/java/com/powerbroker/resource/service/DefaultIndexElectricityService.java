package com.powerbroker.resource.service;

import com.powerbroker.report.data.utils.KeyManager;
import com.powerbroker.resource.model.IndexElectricityDTO;
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

import static com.powerbroker.report.data.utils.IndexKey.ALL_ELECTRICITY_DAY_KEY;
import static com.powerbroker.report.data.utils.IndexKey.ALL_ELECTRICITY_MONTH_KEY;

/**
 * @author william
 */
@Service
public class DefaultIndexElectricityService extends AbstractIndexService<String, IndexElectricityDTO> implements
        IndexElectricityService {

    @Override
    public IndexElectricityDTO aggregate(IndexElectricityDTO condition) {

        return condition;
    }

    @Override
    public List<IndexElectricityDTO> history(IndexElectricityDTO condition) throws ParseException {
        Assert.notNull(condition);
        Assert.notNull(condition.getMetricAt());

        Date now = new Date();
        Date metricAt = Date.from(condition.getMetricAt().atZone(ZoneId.systemDefault()).toInstant());

        List<IndexElectricityDTO> result = new ArrayList<>();
        ValueOperations<String, Object> opsForValue = redisTemplate.opsForValue();
        String metricRedisKey = KeyManager.getNoMetricRedisKey(condition);

        Calendar calendar = Calendar.getInstance();

        while (true) {

            if (metricAt.compareTo(now) > 0) {
                break;
            }

            String metricDayKey = KeyManager.yyyyMMdd.format(metricAt);
            String dayKey = KeyManager.keyGenerate(":", metricRedisKey, ALL_ELECTRICITY_DAY_KEY, metricDayKey);
            Double value = (Double) opsForValue.get(dayKey);
            BigDecimal sumDayElectricity = BigDecimal.ZERO;
            if (null != value) {
                sumDayElectricity = sumDayElectricity.add(BigDecimal.valueOf(value));
            }

            IndexElectricityDTO indexElectricityDTO = new IndexElectricityDTO();
            setKeyAndValue(indexElectricityDTO, metricDayKey, sumDayElectricity);

            calendar.setTime(metricAt);
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            metricAt = calendar.getTime();

            result.add(indexElectricityDTO);
        }

        return result;
    }

    @Override
    public List<IndexElectricityDTO> historyByMonth(IndexElectricityDTO condition) throws ParseException {
        Assert.notNull(condition);
        Assert.notNull(condition.getMetricAt());

        Date now = new Date();
        Date metricAt = Date.from(condition.getMetricAt().atZone(ZoneId.systemDefault()).toInstant());

        List<IndexElectricityDTO> result = new ArrayList<>();
        ValueOperations<String, Object> opsForValue = redisTemplate.opsForValue();
        String metricRedisKey = KeyManager.getNoMetricRedisKey(condition);

        Calendar calendar = Calendar.getInstance();

        while (true) {

            if (metricAt.compareTo(now) > 0) {
                break;
            }

            String metricMonthKey = KeyManager.yyyyMM.format(metricAt);
            String monthKey = KeyManager.keyGenerate(":", metricRedisKey, ALL_ELECTRICITY_MONTH_KEY, metricMonthKey);
            Double value = (Double) opsForValue.get(monthKey);
            BigDecimal sumMonthElectricity = BigDecimal.ZERO;
            if (null != value) {
                sumMonthElectricity = sumMonthElectricity.add(BigDecimal.valueOf(value));
            }

            IndexElectricityDTO indexElectricityDTO = new IndexElectricityDTO();
            setKeyAndValue(indexElectricityDTO, metricMonthKey, sumMonthElectricity);

            calendar.setTime(metricAt);
            calendar.add(Calendar.MONTH, 1);
            metricAt = calendar.getTime();

            result.add(indexElectricityDTO);
        }

        return result;
    }

    private void setKeyAndValue(IndexElectricityDTO dto, String key, BigDecimal value) {

        dto.setKey(key);
        dto.setValue(setIfNull(value));
    }
}
