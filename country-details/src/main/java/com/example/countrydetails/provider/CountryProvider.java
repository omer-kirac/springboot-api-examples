package com.example.countrydetails.provider;


import com.example.countrydetails.domain.CountryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class CountryProvider {


    @Value("${country.api.url}")
    private String apiUrl;

    private final RestTemplate restTemplate = new RestTemplate();



    public CountryResponse getCountry() {}
}
