package com.forex;

import com.forex.Currency;

import java.text.DecimalFormat;

public class CurrencyConverter {

    private static final DecimalFormat f = new DecimalFormat("##.##");

    public static void main(String[] args) {
        Currency sellCurrency = Currency.GBP;
        double sellAmount = 1000.0d;
        Currency buyCurrency = Currency.USD;
        double conversionRate = 1.2561d;

        double buyAmount = convert(sellAmount, conversionRate);

        System.out.println(sellAmount + " " + sellCurrency + " = " + f.format(buyAmount) + " " + buyCurrency);
    }

    public static double convert(double sellAmount, double conversionRate) {
        return sellAmount * conversionRate;
    }

}