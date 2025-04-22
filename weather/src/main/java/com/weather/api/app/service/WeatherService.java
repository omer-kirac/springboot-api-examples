package com.weather.api.app.service;

import com.weather.api.app.domain.WeatherResponse;
import com.weather.api.app.provider.WeatherProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@RequiredArgsConstructor
public class WeatherService {

    private final WeatherProvider weatherProvider;

    @Cacheable(value = "weatherCache", key = "#city")
    public WeatherResponse getWeather(@RequestParam String city) {
        return weatherProvider.getWeather(city);
    }
}
