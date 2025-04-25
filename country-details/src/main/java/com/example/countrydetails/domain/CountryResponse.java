package com.example.countrydetails.domain;

import lombok.Data;

import java.util.List;

@Data
public class CountryResponse {

    private String name;
    private String code;
    private String currency;
    private String capital;
    private String language;
    private List<String> border;
    private String flag;


}
