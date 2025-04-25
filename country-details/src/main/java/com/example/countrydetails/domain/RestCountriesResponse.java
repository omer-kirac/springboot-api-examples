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

    private String name;
    private String cca2;
    private Map<String, Currency> currencies;
    private String capital;
    private String language;
    private List<String> border;
    private String flag;

    @Data
    public static class Currency {
        private String symbol;
        private String name;
    }
}
