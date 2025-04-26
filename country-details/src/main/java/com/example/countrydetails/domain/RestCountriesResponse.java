package com.example.countrydetails.domain;


import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class RestCountriesResponse {

//    private String name;
//    private String code;
//    private String currency;
//    private String capital;
//    private String language;
//    private List<String> border;
//    private String flag;

    private Name name;
    private String cca2;
    private Map<String, Object> currencies;
    private List<String> capital;
    private Map<String, Object> languages;
    private List<String> borders;
    private Flags flags;

    @Data
    public static class Currency {
        private String symbol;
        private String name;
    }

    @Data
    public class Name {
        private String common;
        private String official;
    }

    @Data
    public class Flags {
        private String png;
        private String svg;
    }
}
