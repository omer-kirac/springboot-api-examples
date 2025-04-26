package com.example.countrydetails.provider;


import com.example.countrydetails.domain.CountryResponse;
import com.example.countrydetails.domain.RestCountriesResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CountryProvider {


    @Value("${country.api.url}")
    private String apiUrl;

    private final RestTemplate restTemplate = new RestTemplate();



    public CountryResponse getCountry(String name) {

        URI uri = UriComponentsBuilder
                .fromHttpUrl(apiUrl + "/" + name)
                .build()
                .toUri();

        RestCountriesResponse[] response = restTemplate.getForObject(uri, RestCountriesResponse[].class);

        RestCountriesResponse country = response[0];

        String borders = String.join(", ", country.getBorders());


        String capital = String.join(", ", country.getCapital());


        String currencies = country.getCurrencies().keySet().stream()
                .collect(Collectors.joining(", "));


        String languages = country.getLanguages().values().stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));

        return new CountryResponse(
                country.getName().getCommon(),
                country.getCca2(),
                currencies,
                capital,
                languages,
                Collections.singletonList(borders),
                country.getFlags().getPng()
        );
    }

}
