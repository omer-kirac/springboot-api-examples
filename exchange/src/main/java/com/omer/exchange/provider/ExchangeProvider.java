package com.omer.exchange.provider;

import com.omer.exchange.doamin.ExchangeRate;
import com.omer.exchange.doamin.ExchangeResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
public class ExchangeProvider {


    @Value("${exchange.api.url}")
    private String apiUrl;

    @Value("${exchange.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate =  new RestTemplate();

    public ExchangeResponse calculateExcangeRate() {
        URI uri = UriComponentsBuilder.fromHttpUrl(apiUrl)
                .queryParam("access_key",apiKey)
                .build().toUri();

        ExchangeResponse response = restTemplate.getForObject(uri, ExchangeResponse.class);

        return response;
    }

    public String calcualteExchangeRate(int money) {
        ExchangeResponse exchangeResponse = calculateExcangeRate();

        return "Your " + "$"+ money + " = " + money * exchangeResponse.getQuotes().get("USDTRY") + " Turkish Lira";


    }

    public ExchangeRate getExchangeRate() {
        ExchangeResponse exchangeResponse = calculateExcangeRate();

        return new ExchangeRate(
                "USD",
                "TRY",
                exchangeResponse.getQuotes().get("USDTRY")


        );
    }
}
