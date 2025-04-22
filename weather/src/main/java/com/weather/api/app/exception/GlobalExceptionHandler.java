package com.weather.api.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(WeatherApiException.class)
    public ResponseEntity<Map<String, Object>> handleWeatherApiException(WeatherApiException ex) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.SERVICE_UNAVAILABLE.value());
        body.put("error", "Hava durumu servisine erişilemedi.");
        body.put("message", ex.getMessage());
        body.put("path", "/weather");

        return new ResponseEntity<>(body, HttpStatus.SERVICE_UNAVAILABLE);
    }
}
