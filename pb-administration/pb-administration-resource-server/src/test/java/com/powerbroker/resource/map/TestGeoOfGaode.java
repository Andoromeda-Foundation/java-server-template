package com.powerbroker.resource.map;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by wjwjtftf on 2016/12/27.
 */
@Slf4j
public class TestGeoOfGaode {

    /**
     * 测试高德地理编码
     */
    @Test
    public void testGeo() throws IOException {

        String baseUrl = "http://restapi.amap.com/v3/geocode/geo?";
        URL realUrl = new URL(baseUrl + "address=北京市朝阳区阜通东大街6号|天安门|||莘松路立交泵站|学习exo&key=367c4a4fe805d3679bf94a3fb5a12e09&batch=true");

        // 打开和URL之间的连接
        URLConnection connection = realUrl.openConnection();
        // 设置通用的请求属性
        connection.setRequestProperty("accept", "*/*");
        connection.setRequestProperty("connection", "Keep-Alive");
        connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");

        // 建立实际的连接
        connection.connect();
        // 获取所有响应头字段
        Map<String, List<String>> map = connection.getHeaderFields();
        // 遍历所有的响应头字段
        for (String key : map.keySet()) {
            log.info(key + "--->" + map.get(key));
        }
        // 定义 BufferedReader输入流来读取URL的响应
        StringBuilder result = new StringBuilder();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                connection.getInputStream()));
        String line;
        while ((line = in.readLine()) != null) {
            result.append(line);
        }

        log.info(result.toString());

        if (in != null) {
            in.close();
        }
    }

    /**
     * 测试反序列化
     */
    @Test
    public void testDeserialize() {

        String json = "{\"status\":\"1\",\"info\":\"OK\",\"infocode\":\"10000\",\"count\":\"4\",\"geocodes\":[{\"formatted_address\":\"北京市朝阳区阜通东大街|6号楼\",\"province\":\"北京市\",\"citycode\":\"010\",\"city\":\"北京市\",\"district\":\"朝阳区\",\"township\":[],\"neighborhood\":{\"name\":[],\"type\":[]},\"building\":{\"name\":[],\"type\":[]},\"adcode\":\"110105\",\"street\":[],\"number\":[],\"location\":\"116.484546,39.990064\",\"level\":\"门牌号\"},{\"formatted_address\":\"北京市东城区天安门\",\"province\":\"北京市\",\"citycode\":\"010\",\"city\":\"北京市\",\"district\":\"东城区\",\"township\":[],\"neighborhood\":{\"name\":[],\"type\":[]},\"building\":{\"name\":[],\"type\":[]},\"adcode\":\"110101\",\"street\":[],\"number\":[],\"location\":\"116.397499,39.908722\",\"level\":\"兴趣点\"},{\"formatted_address\":\"上海市闵行区莘松路\",\"province\":\"上海市\",\"citycode\":\"021\",\"city\":\"上海市\",\"district\":\"闵行区\",\"township\":[],\"neighborhood\":{\"name\":[],\"type\":[]},\"building\":{\"name\":[],\"type\":[]},\"adcode\":\"310112\",\"street\":[],\"number\":[],\"location\":\"121.358688,31.099997\",\"level\":\"道路\"},{\"formatted_address\":[],\"province\":[],\"citycode\":[],\"city\":[],\"district\":[],\"township\":[],\"neighborhood\":{\"name\":[],\"type\":[]},\"building\":{\"name\":[],\"type\":[]},\"adcode\":[],\"street\":[],\"number\":[],\"location\":[],\"level\":[]}]}";
        json = json.replaceAll("\\[\\]", "\"\"");

        ObjectMapper jacksonObjectMapper = new ObjectMapper();

        jacksonObjectMapper.configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
        jacksonObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        try {
            GeoResponse response = jacksonObjectMapper.readValue(json, jacksonObjectMapper.getTypeFactory().constructType(GeoResponse.class));

            log.info(response.getGeocodes().get(2).getLocation());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
