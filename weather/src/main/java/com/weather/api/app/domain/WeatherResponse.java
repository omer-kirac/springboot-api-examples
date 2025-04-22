package com.weather.api.app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherResponse {

    private String datetime;
    private String address;
    private double temperature;
    private String conditions;
    private String description;



}
