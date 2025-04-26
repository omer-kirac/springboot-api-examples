package com.example.countrydetails.controller;

import com.example.countrydetails.domain.CountryResponse;
import com.example.countrydetails.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/country")
public class CountryController {


    private final CountryService countryService;

    @GetMapping("/{name}")
    public CountryResponse getCountry(@PathVariable String name) {
        return countryService.getCountry(name);
    }
}
