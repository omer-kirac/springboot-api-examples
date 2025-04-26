package com.example.countrydetails.service;


import com.example.countrydetails.domain.CountryResponse;
import com.example.countrydetails.provider.CountryProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountryProvider countryProvider;

    public CountryResponse getCountry(String name) {
        return countryProvider.getCountry(name);

    }

}
