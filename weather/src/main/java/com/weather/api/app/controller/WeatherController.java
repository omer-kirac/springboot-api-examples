package com.weather.api.app.controller;

import com.weather.api.app.domain.WeatherResponse;
import com.weather.api.app.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;

    WeatherResponse getWeatherResponse(String city) {
        return weatherService.getWeather(city);

    }
}
