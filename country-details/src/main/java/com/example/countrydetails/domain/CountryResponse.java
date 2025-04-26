package com.example.countrydetails.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountryResponse {

    private String name;
    private String code;
    private String currency;
    private String capital;
    private String language;
    private List<String> border;
    private String flag;


}
