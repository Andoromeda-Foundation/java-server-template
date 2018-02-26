package com.powerbroker.resource.service;

import com.powerbroker.resource.dao.PlcMetricMetadataDAO;
import com.powerbroker.resource.entity.PlcMetricMetadata;
import com.powerbroker.resource.model.PlcMetricMetadataDTO;
import com.powerbroker.common.service.AbstractJPAService;
import com.powerbroker.resource.model.PlcMetricMetadataStatDTO;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateParser;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.lang3.time.FastDateFormat;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author william
 */
@Service
@Transactional
public class DefaultPlcMetricMetadataService implements PlcMetricMetadataService {

    @Resource
    private PlcMetricMetadataDAO plcMetricMetadataDAO;

    private static final FastDateFormat FAST_DATE_FORMAT = FastDateFormat.getInstance("yyyyMMddHHmmss");

    private static final FastDateFormat FAST_DATE_FORMAT_DATE = FastDateFormat.getInstance("yyyyMMdd");

    private static final FastDateFormat FAST_DATE_FORMAT_MINUTS = FastDateFormat.getInstance("yyyyMMddHHmm");

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    //    @PostConstruct
//    public void initialize() {
//
//        Date now = new Date();
//
//        String currentDate = FAST_DATE_FORMAT_DATE.format(now);
//
//        PlcMetricMetadata exampleEntity = new PlcMetricMetadata();
//        exampleEntity.setMetricAt(currentDate);
//
//        Example example = Example.of(exampleEntity, ExampleMatcher.matching().withMatcher("metricAt", match -> match.startsWith()));
//
//        List<PlcMetricMetadata> metadatas = plcMetricMetadataDAO.findAll(example);
//
//        Optional<PlcMetricMetadata> last = metadatas.stream().sorted((a, b) -> b.getMetricAt().compareTo(a.getMetricAt())).findFirst();
//
//        Date startTime = last.isPresent() ? DateUtils.addSeconds(pasreDate(last.get().getMetricAt()), 1) : pasreDate(currentDate + "000000");
//
//        generateRows(startTime, DateUtils.addHours(now, 1));
//
//    }

    private void generateRows(Date startTime, Date endTime) {

        Date current = startTime;

        while (current.compareTo(endTime) <= 0) {

            generateRow(current);

            current = DateUtils.addSeconds(current, 1);
        }

    }

    private void generateRow(Date current) {

        PlcMetricMetadata plcMetricMetadata = new PlcMetricMetadata();
        plcMetricMetadata.setNode("acrel");
        plcMetricMetadata.setName("RS485_1");
        plcMetricMetadata.setMetricAt(FAST_DATE_FORMAT.format(current));
        plcMetricMetadata.setExecItem("TX_1");

        plcMetricMetadataDAO.save(plcMetricMetadata);
    }

    @Override
    public PlcMetricMetadataStatDTO findPlcMetricMetadataStat(String time) {

        PlcMetricMetadataStatDTO statDTO = new PlcMetricMetadataStatDTO();

        String currentTime = time.substring(0, 12);

        PlcMetricMetadata exampleEntity = new PlcMetricMetadata();
        exampleEntity.setMetricAt(currentTime);

        Example example = Example.of(exampleEntity, ExampleMatcher.matching().withMatcher("metricAt", match -> match.startsWith()));

        List<PlcMetricMetadata> metadatas = plcMetricMetadataDAO.findAll(example);

        Map<String, List<PlcMetricMetadata>> map = metadatas.stream().collect(Collectors.groupingBy(PlcMetricMetadata::getNode));

        statDTO.setCount((long) map.size());
        statDTO.setTime(time);
        statDTO.setMilliseconds(pasreDate(statDTO.getTime()).getTime());

        return statDTO;
    }

    @Override
    public List<PlcMetricMetadataStatDTO> findCurrentDatePlcMetricMetadataStat(String time) {

        String currentDate = time.substring(0, 8);

        PlcMetricMetadata exampleEntity = new PlcMetricMetadata();
        exampleEntity.setMetricAt(currentDate);

        Example example = Example.of(exampleEntity, ExampleMatcher.matching().withMatcher("metricAt", match -> match.startsWith()));

        List<PlcMetricMetadata> metadatas = plcMetricMetadataDAO.findAll(example);

        Map<String, List<PlcMetricMetadata>> map = metadatas.stream().filter(d -> d.getMetricAt().substring(0, 12).compareTo(time.substring(0, 12)) <= 0).collect(Collectors.groupingBy(d -> d.getMetricAt().substring(0, 12)));

        List<PlcMetricMetadataStatDTO> statDTOs = map.entrySet().stream().sorted((a, b) -> compareTime(a, b)).map(entry -> {

            PlcMetricMetadataStatDTO statDTO = new PlcMetricMetadataStatDTO();
            statDTO.setTime(entry.getKey());
            statDTO.setCount((long) entry.getValue().stream().collect(Collectors.groupingBy(PlcMetricMetadata::getNode)).size());
            statDTO.setMilliseconds(pasreDate(statDTO.getTime() + "00").getTime());
            return statDTO;
        }).collect(Collectors.toList());

        List<PlcMetricMetadataStatDTO> results = new ArrayList<>();

        fillRows(results, statDTOs, pasreDate(currentDate + "000000"));

        return results;
    }

    private void fillRows(List<PlcMetricMetadataStatDTO> list, List<PlcMetricMetadataStatDTO> statDTOs, Date startTime) {

        Date endTime = statDTOs.isEmpty() ? new Date() : new Date(statDTOs.get(0).getMilliseconds());

        Date current = startTime;

        while (current.compareTo(endTime) <= 0) {

            generateDefaultRow(list, current);

            current = DateUtils.addMinutes(current, 1);
        }

        list.addAll(statDTOs);
    }

    private void generateDefaultRow(List<PlcMetricMetadataStatDTO> list, Date current) {

        PlcMetricMetadataStatDTO statDTO = new PlcMetricMetadataStatDTO();
        statDTO.setTime(FAST_DATE_FORMAT_MINUTS.format(current));
        statDTO.setCount(0l);
        statDTO.setMilliseconds(pasreDate(statDTO.getTime() + "00").getTime());

        list.add(statDTO);
    }

    private int compareTime(Map.Entry<String, List<PlcMetricMetadata>> a, Map.Entry<String, List<PlcMetricMetadata>> b) {
        return a.getKey().compareTo(b.getKey());
    }

    private Date pasreDate(String time) {
        try {
            return FAST_DATE_FORMAT.parse(time);
        } catch (ParseException e) {
        }
        return null;
    }

}
