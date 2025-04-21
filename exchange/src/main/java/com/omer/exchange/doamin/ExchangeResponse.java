package com.omer.exchange.doamin;


import lombok.Data;

import java.util.Map;

@Data
public class ExchangeResponse {

    private Map<String, Double> quotes;

}
