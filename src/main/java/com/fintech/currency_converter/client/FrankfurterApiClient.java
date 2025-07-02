package com.fintech.currency_converter.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.fintech.currency_converter.models.FrankFurterResponse;

import java.math.BigDecimal;
import java.util.Map;

@SuppressWarnings("unchecked")
@Component
public class FrankfurterApiClient {

    private static final String BASE_URL = "https://api.frankfurter.app";
    private final RestTemplate restTemplate = new RestTemplate();

    public BigDecimal getExchangeRate(String fromCurrency, String toCurrency) {
        String url = UriComponentsBuilder.fromHttpUrl(BASE_URL + "/latest")
                .queryParam("amount", 1)
                .queryParam("from", fromCurrency)
                .queryParam("to", toCurrency)
                .toUriString();

        FrankFurterResponse response = restTemplate.getForObject(url, FrankFurterResponse.class);
        Map<String, Double> rates = response.getRates();

        if (rates == null || !rates.containsKey(toCurrency)) {
            throw new IllegalArgumentException("Invalid currency or conversion rate not available");
        } else {
            return BigDecimal.valueOf(rates.get(toCurrency));
        }
    }
}
