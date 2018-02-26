package com.powerbroker.resource.map;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.powerbroker.resource.dao.PowerStationDAO;
import com.powerbroker.resource.entity.PowerStation;
import com.powerbroker.common.utils.StringUtil;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.CollectionUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by wjwjtftf on 2016/12/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@ContextConfiguration(classes = {JpaConfiguration.class, ActivitiConfiguration.class}, loader = AnnotationConfigContextLoader.class)
@Slf4j
public class GetGeoUtil {

    @Setter
    @Resource
    private PowerStationDAO powerStationDAO;

    @Test
    public void complateLatitudeAndLongitude() {

        List<PowerStation> powerStations = powerStationDAO.findAll().stream().filter(p -> null == p.getLatitude()).map(p -> {
            p.setLatitude("wjwjtftf");
            return p;
        }).collect(Collectors.toList());

        powerStationDAO.save(powerStations);

        log.info("start test...\n{}", powerStations);
    }

    @Test
    public void fixAllLatitudeAndLongtitude() {

        String baseUrl = "http://restapi.amap.com/v3/geocode/geo?key=367c4a4fe805d3679bf94a3fb5a12e09&city=shanghai&batch=true&address=";

        List<PowerStation> powerStations = powerStationDAO.findAll().stream().filter(p -> StringUtil.isNotBlank(p.getAddress())).collect(Collectors.toList());

        StringBuilder address = new StringBuilder();
        List<PowerStation> batch = new LinkedList<>();

        for (int i = 0; i < powerStations.size(); i++) {

            PowerStation powerStation = powerStations.get(i);

            address.append(powerStation.getAddress());
            batch.add(powerStation);

            if (batch.size() == 10 || i == powerStations.size() - 1) {

                this.callGaode(batch, baseUrl + address.toString());

            } else {

                address.append("|");
            }
        }

    }

    private void callGaode(List<PowerStation> batch, String urlString) {

        BufferedReader in = null;

        try {
            URL realUrl = new URL(urlString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");

            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            // Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            // for (String key : map.keySet()) {
            //    log.info(key + "--->" + map.get(key));
            // }
            // 定义 BufferedReader输入流来读取URL的响应
            StringBuilder result = new StringBuilder();
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result.append(line);
            }

            // 反序列化
            String json = result.toString().replaceAll("\\[\\]", "\"\"");

            ObjectMapper jacksonObjectMapper = new ObjectMapper();
            jacksonObjectMapper.configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
            jacksonObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            GeoResponse response = jacksonObjectMapper.readValue(json, jacksonObjectMapper.getTypeFactory().constructType(GeoResponse.class));

            // 更新数据库
            this.batchUpdateLaAndLo(batch, response);

            // log.info(result.toString());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            batch.clear();

            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void batchUpdateLaAndLo(List<PowerStation> batch, GeoResponse response) {

        if ("0".equals(response.getStatus())) {
            return;
        }

        List<PowerStation> updated = new ArrayList<>();

        for (int i = 0; i < batch.size(); i++) {

            PowerStation powerStation = batch.get(i);

            if (i < Integer.parseInt(response.getCount()) && i < response.getGeocodes().size()) {

                GeoCode geoCode = response.getGeocodes().get(i);

                if (StringUtil.isNotEmpty(geoCode.getLocation()) && geoCode.getLocation().indexOf(",") > 0) {

                    String[] split = geoCode.getLocation().split(",");


                    log.info("############# id[{}]  latitude:[{}] ==> [{}]", powerStation.getId(), powerStation.getLatitude(), split[1]);
                    log.info("#############        longitude:[{}] ==> [{}]", powerStation.getLongitude(), split[0]);

                    powerStation.setLongitude(split[0]);
                    powerStation.setLatitude(split[1]);
                    updated.add(powerStation);
                }
            }
        }

        if (!CollectionUtils.isEmpty(updated)) {

            powerStationDAO.save(updated);
        }
    }

}

@Getter
@Setter
class GeoResponse {
    private String status;
    private String info;
    private String infocode;
    private String count;
    private List<GeoCode> geocodes;
}

@Getter
@Setter
class GeoCode {
    private String location;
}