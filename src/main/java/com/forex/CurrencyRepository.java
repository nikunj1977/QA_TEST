package com.forex;

import java.math.BigDecimal;

public class CurrencyRepository {

    public BigDecimal getCurrencyRate(Currency source, Currency target) {
        String currencyCombined = source.toString() + target.toString();
        String rate;
        switch (currencyCombined) {
            case "GBPUSD":
                rate = "1.37";
                break;
            case "EURUSD":
                rate = "1.42";
                break;
            default:
                rate = "0";
        }

        return new BigDecimal(rate);
    }
}
