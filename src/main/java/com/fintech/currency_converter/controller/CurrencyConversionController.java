package com.fintech.currency_converter.controller;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fintech.currency_converter.models.CurrencyConversionRequest;
import com.fintech.currency_converter.models.CurrencyConversionResponse;
import com.fintech.currency_converter.service.CurrencyConversionService;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api/v1")
public class CurrencyConversionController {

    private final CurrencyConversionService currencyConversionService;

    public CurrencyConversionController(CurrencyConversionService currencyConversionService) {
        this.currencyConversionService = currencyConversionService;
    }

    @PostMapping("/convert")
    public ResponseEntity<CurrencyConversionResponse> convertCurrency(@RequestBody CurrencyConversionRequest request) {
        CurrencyConversionResponse response = currencyConversionService.convert(request);
        return ResponseEntity.ok(response);
    }

}
