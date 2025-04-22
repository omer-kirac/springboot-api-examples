package com.weather.api.app.exception;

public class WeatherApiException extends RuntimeException {

    public WeatherApiException(String message) {
        super(message);
    }
}
