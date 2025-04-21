package com.omer.exchange.controller;

import com.omer.exchange.doamin.ExchangeRate;
import com.omer.exchange.service.ExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/exchange")
public class ExchangeController {

    private final ExchangeService exchangeService;

    @GetMapping
    public ExchangeRate getExchangeRate() {

        return exchangeService.getExchangeRate();
    }
}
