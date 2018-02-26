package com.powerbroker.resource.service;

import com.powerbroker.report.data.utils.KeyManager;
import com.powerbroker.resource.model.IndexPowerAnalysisDTO;
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

import static com.powerbroker.report.data.utils.IndexKey.MAX_POWER_ANALYSIS_FAULT_KEY;

/**
 * @author william
 */
@Service
public class DefaultIndexPowerAnalysisService extends AbstractIndexService<String, IndexPowerAnalysisDTO> implements
        IndexPowerAnalysisService{

    @Override
    public IndexPowerAnalysisDTO aggregate(IndexPowerAnalysisDTO condition) {
        return null;
    }

    @Override
    public List<IndexPowerAnalysisDTO> realTime(IndexPowerAnalysisDTO indexDischargeDTO) {
        List<IndexPowerAnalysisDTO> results = new ArrayList<>();

        return results;
    }

    @Override
    public List<IndexPowerAnalysisDTO> history(IndexPowerAnalysisDTO condition) throws ParseException {
        Assert.notNull(condition);
        Assert.notNull(condition.getMetricAt());

        Date now = new Date();
        Date metricAt = Date.from(condition.getMetricAt().atZone(ZoneId.systemDefault()).toInstant());

        List<IndexPowerAnalysisDTO> result = new ArrayList<>();

        return result;
    }

    @Override
    public List<IndexPowerAnalysisDTO> historyByDay(IndexPowerAnalysisDTO condition) throws ParseException {
        Assert.notNull(condition);
        Assert.notNull(condition.getMetricAt());

        Date now = new Date();
        Date metricAt = Date.from(condition.getMetricAt().atZone(ZoneId.systemDefault()).toInstant());

        List<IndexPowerAnalysisDTO> result = new ArrayList<>();
        ValueOperations<String, Object> opsForValue = redisTemplate.opsForValue();

        String noMetricRedisKey = KeyManager.getNoMetricRedisKey(condition);

        Calendar calendar = Calendar.getInstance();

        while (true) {

            if (metricAt.compareTo(now) > 0) {
                break;
            }

            String metricDayKey = KeyManager.yyyyMMdd.format(metricAt);

            String maxKey = KeyManager.keyGenerate(":", noMetricRedisKey, MAX_POWER_ANALYSIS_FAULT_KEY, metricDayKey);
            BigDecimal maxRecordPower = (BigDecimal) opsForValue.get(maxKey);

            IndexPowerAnalysisDTO indexPowerAnalysisDTO = new IndexPowerAnalysisDTO();
            setKeyAndValue(indexPowerAnalysisDTO, metricDayKey, setIfNull(maxRecordPower));

            calendar.setTime(metricAt);
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            metricAt = calendar.getTime();

            result.add(indexPowerAnalysisDTO);
        }

        return result;
    }

    private void setKeyAndValue(IndexPowerAnalysisDTO dto, String key, BigDecimal value) {

        dto.setKey(key);
        dto.setValue(setIfNull(value));
    }
}
