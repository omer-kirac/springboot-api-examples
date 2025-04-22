package com.weather.api.app.provider;

import com.weather.api.app.domain.TimelineWeatherResponse;
import com.weather.api.app.domain.WeatherResponse;
import com.weather.api.app.exception.WeatherApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
@RequiredArgsConstructor
public class WeatherProvider {

    @Value("${weather.api.url}")
    private String apiUrl;

    @Value("${weather.api.key}")
    private String apiKey;

    RestTemplate restTemplate = new RestTemplate();




    public WeatherResponse getWeather(@RequestParam String city) {

        URI uri = UriComponentsBuilder.fromHttpUrl(apiUrl)
                .queryParam("key", apiKey)
                .buildAndExpand(city).toUri();

        TimelineWeatherResponse response;

        try {
            response = restTemplate.getForObject(uri, TimelineWeatherResponse.class);
        } catch (Exception e) {
            throw new WeatherApiException("Hava durumu verisi alınamadı.");
        }

        TimelineWeatherResponse.Day firstDay = response.getDays().get(0);

        return new WeatherResponse(
                firstDay.getDatetime(),
                response.getResolvedAddress(),
                (firstDay.getTemp() - 32) / 1.8, // Fahrenheit to Celsius
                firstDay.getConditions(),
                response.getDescription()
        );
    }

}
