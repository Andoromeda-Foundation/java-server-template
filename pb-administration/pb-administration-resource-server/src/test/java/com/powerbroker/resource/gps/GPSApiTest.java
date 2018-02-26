package com.powerbroker.resource.gps;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.powerbroker.resource.model.gps.AuthDTO;
import com.powerbroker.resource.model.gps.TrackingListDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.text.MessageFormat;

/**
 * @author william
 */
@Slf4j
public class GPSApiTest {

    private final String imeis = "868120151022032";
    private final String account = "15618659798";
    private final String password = "qwer1234";

    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testGetAccessToken() throws IOException {

        AuthDTO gpsAuthDTO = getGpsAuthDTO();

        Assert.hasText(gpsAuthDTO.getAccess_token());
    }

    @Test
    public void testTrackingGPS() throws IOException {

        AuthDTO gpsAuthDTO = getGpsAuthDTO();

        String time = String.valueOf(System.currentTimeMillis() / 1000L);
        String accessToken = gpsAuthDTO.getAccess_token();
        String url = MessageFormat.format("http://api.gpsoo.net/1/devices/tracking?access_token={0}&map_type=BAIDU&account={1}&imeis={2}&time={3}", accessToken, account, imeis, time);
        log.info("url: {}", url);

        String response = restTemplate.getForObject(url, String.class);

        TrackingListDTO gpsTrackingListDTO = objectMapper.readValue(response, TrackingListDTO.class);

        Assert.notNull(gpsTrackingListDTO);
        Assert.notEmpty(gpsTrackingListDTO.getData());
    }

    private AuthDTO getGpsAuthDTO() throws IOException {
        String time = String.valueOf(System.currentTimeMillis() / 1000L);
        String signature = DigestUtils.md5Hex(DigestUtils.md5Hex(password) + time);

        String url = MessageFormat.format("http://api.gpsoo.net/1/auth/access_token?account={0}&time={1}&signature={2}", account, time, signature);
        log.info("url: {}", url);

        String response = restTemplate.getForObject(url, String.class);
        log.info("response: {}", response);

        return objectMapper.readValue(response, AuthDTO.class);
    }
}
