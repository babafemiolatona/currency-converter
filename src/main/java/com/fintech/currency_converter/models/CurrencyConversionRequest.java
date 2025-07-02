package com.fintech.currency_converter.models;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class CurrencyConversionRequest {

    private String fromCurrency;
    private String toCurrency;
    private BigDecimal amount;

}
