package com.fintech.currency_converter.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Service;

import com.fintech.currency_converter.client.FrankfurterApiClient;
import com.fintech.currency_converter.models.CurrencyConversionRequest;
import com.fintech.currency_converter.models.CurrencyConversionResponse;

@Service
public class CurrencyConversionServiceImpl implements CurrencyConversionService {

    private final FrankfurterApiClient frankfurterApiClient;

    public CurrencyConversionServiceImpl(FrankfurterApiClient frankfurterApiClient) {
        this.frankfurterApiClient = frankfurterApiClient;
    }

    @Override
    public CurrencyConversionResponse convert(CurrencyConversionRequest request) {
        BigDecimal exchangeRate = frankfurterApiClient.getExchangeRate(
            request.getFromCurrency(),
            request.getToCurrency()
        );
        
        BigDecimal convertedAmount = request.getAmount()
            .multiply(exchangeRate)
            .setScale(2, RoundingMode.HALF_UP);
        
        CurrencyConversionResponse response = new CurrencyConversionResponse();
        response.setFromCurrency(request.getFromCurrency());
        response.setToCurrency(request.getToCurrency());
        response.setAmount(request.getAmount());
        response.setConvertedAmount(convertedAmount);
        response.setConversionRate(exchangeRate);
        
        return response;
    }

}
