package com.powerbroker.resource.service;

import com.powerbroker.resource.model.WeatherDTO;
import com.powerbroker.common.service.AbstractService;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author william
 */
@Slf4j
@Component
public class DefaultWeatherService extends AbstractService<Long, WeatherDTO> implements WeatherService {


  @Setter
  @Getter
  static class WeatherWrapperListDTO {

    private List<WeatherWrapperDTO> results;
  }

  @Setter
  @Getter
  static class WeatherWrapperDTO {

    private String last_update;

    private WeatherLocationDTO location;

    private WeatherDTO now;
  }

  @Setter
  @Getter
  static class WeatherLocationDTO {



    private String name;

    private String path;

    private String timezone;

    private String timezone_offset;

    private String country;
  }

  @Override
  public WeatherDTO retrieve(Long id) {

    WeatherDTO weatherDTO = null;

    RestTemplate restTemplate = new RestTemplate();

    String url = "https://api.thinkpage.cn/v3/weather/now.json?key=ueogssiomqievain&location=shanghai&language=zh-Hans&unit=c";
    ResponseEntity<WeatherWrapperListDTO> response = restTemplate.getForEntity(url, WeatherWrapperListDTO.class);

    if (null != response) {
      List<WeatherWrapperDTO> list = response.getBody().getResults();

      if (!CollectionUtils.isEmpty(list)) {
        weatherDTO = list.get(0).getNow();
        log.info("results, {}", weatherDTO);
      }
    }

    return weatherDTO;
  }
}
