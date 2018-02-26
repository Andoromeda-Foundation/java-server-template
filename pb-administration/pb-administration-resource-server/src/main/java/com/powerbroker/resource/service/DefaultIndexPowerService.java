package com.powerbroker.resource.service;

import com.powerbroker.report.data.utils.KeyManager;
import com.powerbroker.report.data.utils.PowerLine;
import com.powerbroker.resource.model.IndexPowerDTO;
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
public class DefaultIndexPowerService extends AbstractIndexService<String, IndexPowerDTO> implements IndexPowerService {

    @Override
    public IndexPowerDTO aggregate(IndexPowerDTO condition) {
        String dayKey = KeyManager.yyyyMMdd.format(new Date());

        ValueOperations<String, Object> opsForValue = redisTemplate.opsForValue();
        String noMetricRedisKey = KeyManager.getNoMetricRedisKey(condition);
        condition.setMin(setIfNull((BigDecimal) opsForValue.get(KeyManager.keyGenerate(":", noMetricRedisKey, condition
                .getPowerLine().getKeys()[0], dayKey))));
        condition.setMax(setIfNull((BigDecimal) opsForValue.get(KeyManager.keyGenerate(":", noMetricRedisKey, condition
                .getPowerLine().getKeys()[1], dayKey))));
        condition.setAvg(setIfNull((BigDecimal) opsForValue.get(KeyManager.keyGenerate(":", noMetricRedisKey, condition
                .getPowerLine().getKeys()[2], dayKey))));
        return condition;
    }

    @Override
    public List<IndexPowerDTO> realTime(IndexPowerDTO indexDischargeDTO) {

        String lineKey = KeyManager.getNoMetricRedisKey(indexDischargeDTO);

        String realTimeKey = null;

        if (indexDischargeDTO.getPowerLine().equals(PowerLine.P)) {
            realTimeKey = KeyManager.keyGenerate(":", lineKey, REAL_TIME_POWER_P_KEY);
        } else if (indexDischargeDTO.getPowerLine().equals(PowerLine.Q)) {
            realTimeKey = KeyManager.keyGenerate(":", lineKey, REAL_TIME_POWER_Q_KEY);
        }

        ValueOperations<String, Object> opsForValue = redisTemplate.opsForValue();
        Double value = (Double) opsForValue.get(realTimeKey);

        IndexPowerDTO indexPowerDTO = new IndexPowerDTO();
        indexPowerDTO.setValue(setIfNull(BigDecimal.valueOf(value)));

        List<IndexPowerDTO> results = new ArrayList<>();

        results.add(indexPowerDTO);

        return results;
    }

    @Override
    public List<IndexPowerDTO> history(IndexPowerDTO condition) throws ParseException {
        Assert.notNull(condition);
        Assert.notNull(condition.getMetricAt());

        Date now = new Date();
        Date metricAt = Date.from(condition.getMetricAt().atZone(ZoneId.systemDefault()).toInstant());

        List<IndexPowerDTO> result = new ArrayList<>();
        ValueOperations<String, Object> opsForValue = redisTemplate.opsForValue();

        String noMetricRedisKey = KeyManager.getNoMetricRedisKey(condition);

        Calendar calendar = Calendar.getInstance();

        while (true) {

            if (metricAt.compareTo(now) > 0) {
                break;
            }

            String metricHourKey = KeyManager.yyyyMMddHH.format(metricAt);
            String fixHourKey = null;
            if (condition.getPowerLine().equals(PowerLine.P)) {
                fixHourKey = AVG_POWER_P_HOUR_KEY;
            } else if (condition.getPowerLine().equals(PowerLine.Q)) {
                fixHourKey = AVG_POWER_Q_HOUR_KEY;
            }

            String hourKey = KeyManager.keyGenerate(":", noMetricRedisKey, fixHourKey, metricHourKey);
            BigDecimal avgHourPower = (BigDecimal) opsForValue.get(hourKey);

            IndexPowerDTO indexPowerDTO = new IndexPowerDTO();
            setKeyAndValue(indexPowerDTO, metricHourKey, avgHourPower);

            calendar.setTime(metricAt);
            calendar.add(Calendar.HOUR_OF_DAY, 1);
            metricAt = calendar.getTime();

            result.add(indexPowerDTO);
        }

        return result;
    }

    @Override
    public List<IndexPowerDTO> historyByDay(IndexPowerDTO condition) throws ParseException {
        Assert.notNull(condition);
        Assert.notNull(condition.getMetricAt());

        Date now = new Date();
        Date metricAt = Date.from(condition.getMetricAt().atZone(ZoneId.systemDefault()).toInstant());

        List<IndexPowerDTO> result = new ArrayList<>();
        ValueOperations<String, Object> opsForValue = redisTemplate.opsForValue();

        String noMetricRedisKey = KeyManager.getNoMetricRedisKey(condition);

        Calendar calendar = Calendar.getInstance();

        while (true) {

            if (metricAt.compareTo(now) > 0) {
                break;
            }

            String metricHourKey = KeyManager.yyyyMMdd.format(metricAt);

            String pDayKey = KeyManager.keyGenerate(":", noMetricRedisKey, AVG_POWER_P_DAY_KEY, metricHourKey);
            String qDayKey = KeyManager.keyGenerate(":", noMetricRedisKey, AVG_POWER_Q_HOUR_KEY, metricHourKey);
            BigDecimal pDayPower = (BigDecimal) opsForValue.get(pDayKey);
            BigDecimal qDayPower = (BigDecimal) opsForValue.get(qDayKey);

            IndexPowerDTO indexPowerDTO = new IndexPowerDTO();
            setKeyAndValue(indexPowerDTO, metricHourKey, setIfNull(pDayPower).add(setIfNull(qDayPower)).multiply
                    (BigDecimal
                    .valueOf(0.5f)));

            calendar.setTime(metricAt);
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            metricAt = calendar.getTime();

            result.add(indexPowerDTO);
        }

        return result;
    }

    private void setKeyAndValue(IndexPowerDTO dto, String key, BigDecimal value) {

        dto.setKey(key);
        dto.setValue(setIfNull(value));
    }
}
