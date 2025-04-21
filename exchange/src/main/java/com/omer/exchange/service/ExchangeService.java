package com.omer.exchange.service;


import com.omer.exchange.doamin.ExchangeRate;
import com.omer.exchange.provider.ExchangeProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExchangeService {



    private final ExchangeProvider exchangeProvider;


    public ExchangeRate getExchangeRate() {
        return exchangeProvider.getExchangeRate();
    }

    public String calculateExchange(int money) {
        return exchangeProvider.calcualteExchangeRate(money);
    }


}
