package com.powerbroker.resource.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.powerbroker.common.utils.StringUtil;
import com.powerbroker.resource.model.geo.Coordinate;
import com.powerbroker.resource.model.geo.GeoCode;
import com.powerbroker.resource.model.geo.GeoResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.text.MessageFormat;
import java.util.List;

/**
 * Created by wjwjtftf on 2016/12/28.
 */
@Slf4j
@Component
public class DefaultGeoCodeService implements GeoCodeService {

    private String baseUrl = "http://restapi.amap.com/v3/geocode/geo?key=367c4a4fe805d3679bf94a3fb5a12e09&city={0}&address={1}";

    @Override
    public String geo(String cityName, String address) {

        Coordinate coordinate = null;

        if (StringUtil.isNotBlank(cityName) && StringUtil.isNotBlank(address)) {

            String urlString = MessageFormat.format(baseUrl, cityName, address);

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

                // 读取返回流
                List<String> strings = IOUtils.readLines(connection.getInputStream(), "UTF-8");

                log.debug(String.join("", strings));

                // 反序列化
                String json = String.join("", strings).replaceAll("\\[\\]", "\"\"");

                ObjectMapper jacksonObjectMapper = new ObjectMapper();
                jacksonObjectMapper.configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
                jacksonObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

                GeoResponse response = jacksonObjectMapper.readValue(json, jacksonObjectMapper.getTypeFactory().constructType(GeoResponse.class));

                if ("1".equals(response.getStatus()) && !CollectionUtils.isEmpty(response.getGeocodes())) {

                    GeoCode geoCode = response.getGeocodes().get(0);

                    if (StringUtil.isNotBlank(geoCode.getLocation())) {
                        coordinate = new Coordinate(geoCode.getLocation());
                    }
                }

            } catch (IOException e) {

                log.error("sys error!", e);

            } finally {

                try {
                    if (in != null) {
                        in.close();
                    }
                } catch (IOException e) {

                    log.error("sys error!", e);
                }
            }
        }

        return null == coordinate ? "" : coordinate.toString();
    }
}
