package com.forex;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;

public class NewTradeTransaction {

    private Currency sellCurrency;
    private Currency buyCurrency;
    private Double conversionRate;
    private Double sellAmount;
    private Timestamp currentDate;

    private static final DecimalFormat f = new DecimalFormat("##.##");

    public NewTradeTransaction(Currency sellCurrency, Currency targetCurrency, double conversionRate, Double sellAmount,Timestamp currentDate) {
        this.sellCurrency = sellCurrency;
        this.buyCurrency = targetCurrency;
        this.conversionRate = conversionRate;
        this.sellAmount = sellAmount;
        this.currentDate = currentDate;
    }



    public Double getSellAmount() {
        return sellAmount;
    }

    public void setSellAmount(Double sellAmount) {
        this.sellAmount = sellAmount;
    }


    public Currency getSellCurrency() {
        return sellCurrency;
    }

    public void setSellCurrency(Currency sellCurrency) {
        this.sellCurrency = sellCurrency;
    }

    public Currency getBuyCurrency() {
        return buyCurrency;
    }

    public void setBuyCurrency(Currency buyCurrency) {
        this.buyCurrency = buyCurrency;
    }

    public double getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(Double conversionRate) {
        this.conversionRate = conversionRate;
    }

    public Timestamp getCurentDate() {
        return currentDate;
    }

    public void setCurentDate(Timestamp curentDate) {
        this.currentDate = curentDate;
    }

    public double calculateByAmount(){

        double buyAmout = getSellAmount() * getConversionRate();
        return buyAmout;
    }

    public ArrayList<Currency> CountriList(Currency currency){
        ArrayList currencyList = new ArrayList<Currency>();
        currencyList = new ArrayList<>();
        currencyList.add(Currency.GBP);
        currencyList.add(Currency.USD);
        currencyList.add(Currency.EUR);

        return currencyList;
    }

    @Override
    public String toString() {
        return "NewTradeTransaction{" +
                "|| Sell Currency = " + sellCurrency +
                "|| Sell Amount = " + sellAmount +
                "|| Buy Currency = " + buyCurrency +
                "|| Buy Amount = " + f.format(calculateByAmount())+
                "|| Rate = " + conversionRate +
                "|| Date Booked = " + currentDate +
                '}';
    }
}
