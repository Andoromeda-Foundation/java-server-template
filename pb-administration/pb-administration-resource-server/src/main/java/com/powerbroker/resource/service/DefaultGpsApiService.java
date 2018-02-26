package com.powerbroker.resource.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.powerbroker.common.service.AbstractService;
import com.powerbroker.resource.model.gps.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.MessageFormat;

/**
 * @author william
 */
@Slf4j
@Component
public class DefaultGpsApiService extends AbstractService<Long, TrackingDTO> implements GpsApiService {

    @Resource
    private Environment env;

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private ObjectMapper objectMapper;

    private URI gpsAuthURI(String accountName, String accountPassword) throws URISyntaxException {
        String time = String.valueOf(System.currentTimeMillis() / 1000L);
        String signature = DigestUtils.md5Hex(DigestUtils.md5Hex(accountPassword) + time);

        log.info("time: {}; signature: {};", time, signature);
        String url = MessageFormat.format("{0}{1}?account={2}&time={3}&signature={4}", env.getProperty("gps.gataway.host"), env.getProperty("gps.auth.uri"), accountName, time, signature);
        log.info("url: {}", url);
        return new URI(url);
    }

    private URI gpsTrackingURI() throws URISyntaxException {

        String url = MessageFormat.format("{0}{1}", env.getProperty("gps.gataway.host"), env.getProperty("gps.tracking.uri"));
        log.info("url: {}", url);
        return new URI(url);
    }

    private HttpEntity<MultiValueMap<String, String>> dataForGpsTrackingURI(String accessToken, String accountName, String imeis, String
            mapType) {
        MultiValueMap<String, String> request = new LinkedMultiValueMap<>();

        request.add("access_token", accessToken);
        request.add("account", accountName);
        request.add("imeis", imeis);
        request.add("time", String.valueOf(System.currentTimeMillis() / 1000L));
        request.add("map_type", mapType);

        log.info("request data {}", request);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<>(request,
                headers);

        return body;

    }

    @Override
    public TrackingDTO tracking(GpsDTO gps) {

        String response = null;
        try {
            String accountName = gps.getAccount().getName();
            HttpEntity<MultiValueMap<String, String>> requestBody = dataForGpsTrackingURI(gps.getAccessToken(),
                    accountName, gps.getImei(), gps.getMapType());

            response = restTemplate.postForObject(gpsTrackingURI(), requestBody, String.class);
        } catch (URISyntaxException e) {
            log.error("error {}", e);
        }

        if (StringUtils.hasText(response)) {
            try {
                TrackingListDTO gpsTrackingListDTO = objectMapper.readValue(response, TrackingListDTO.class);

                if (null != gpsTrackingListDTO && !CollectionUtils.isEmpty(gpsTrackingListDTO.getData())) {
                    return gpsTrackingListDTO.getData().get(0);
                }

            } catch (IOException e) {
                log.error("parse text error, text {}, error {}", response, e);
            }
        }

        return null;
    }

    @Override
    public AuthDTO refreshToken(AccountDTO accountDTO) {

        String response = null;
        try {
            response = restTemplate.getForObject(gpsAuthURI(accountDTO.getName
                    (), accountDTO.getPassword()), String.class);

            log.info("gps auth response {}", response);
        } catch (URISyntaxException e) {
            log.error("error {}", e);
        }

        AuthDTO authDTO = null;
        if (StringUtils.hasText(response)) {
            try {
                authDTO = objectMapper.readValue(response, AuthDTO.class);
            } catch (IOException e) {
                log.error("parse text error, text {}, error {}", response, e);
            }
        }
        return authDTO;
    }
}
