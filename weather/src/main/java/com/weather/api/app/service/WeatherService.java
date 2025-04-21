package com.weather.api.app.service;

import com.weather.api.app.domain.WeatherResponse;
import com.weather.api.app.provider.WeatherProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WeatherService {


    private final WeatherProvider weatherProvider;

    public WeatherResponse getWeather(String city) {
        return weatherProvider.getWeather(city);
    }
}
