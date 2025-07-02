package com.fintech.currency_converter.service;

import com.fintech.currency_converter.models.CurrencyConversionRequest;
import com.fintech.currency_converter.models.CurrencyConversionResponse;

public interface CurrencyConversionService {
    CurrencyConversionResponse convert(CurrencyConversionRequest request);
}
