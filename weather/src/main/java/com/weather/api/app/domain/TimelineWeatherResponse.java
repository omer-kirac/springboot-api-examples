package com.weather.api.app.domain;


import lombok.Data;

import java.util.List;

@Data
public class TimelineWeatherResponse {
    private String resolvedAddress;
    private String description;
    private List<Day> days;

    public class Day {
        private String datetime;
        private double temp;
        private String conditions;
    }
}
