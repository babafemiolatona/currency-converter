package com.fintech.currency_converter.models;

import java.math.BigDecimal;
import java.util.Map;
import lombok.Data;

@Data
public class FrankFurterResponse {

    private Map<String, Double> rates;
    private String base;
    private String date;
    private BigDecimal amount;

}
