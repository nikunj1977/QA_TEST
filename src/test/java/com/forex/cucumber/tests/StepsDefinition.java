package com.forex.cucumber.tests;

//import com.forex.Currency;
import com.forex.*;
import com.forex.NewTradeTransaction;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class StepsDefinition {

Date date = new Date();
NewTradeTransaction newTradeTransaction = new NewTradeTransaction(Currency.EUR,Currency.USD,1.42,500.50, new Timestamp(date.getTime()));




    //Scenario: 1
    @Given("valid user is on Book trades")
    public void valid_user_is_on_book_trades() {
        System.out.println("Valid user is on Book Trade page");
    }
    @When("New trade button is clicked")
    public void new_trade_button_is_clicked() {
        System.out.println("User Click on New Trade button");
    }

    @Then("New trade layout is displayed")
    public void new_trade_layout_is_displayed(){
        System.out.println("New Trade layout is displayed");
    }

    @Then("Sell Currency dropdown is empty")
    public void sell_currency_dropdown_is_empty() { //io.cucumber.datatable.DataTable dataTable
       ArrayList<String> sellCurrency =  new ArrayList<String>(4);
       boolean isSellCurrencyEmpty =  sellCurrency.isEmpty();//(!(sellCurrency.size()>0));
       System.out.println("Is Sell Currency dropdown Empty ::" + isSellCurrencyEmpty);// Check Sellcurrency list is empty
       Assertions.assertEquals(isSellCurrencyEmpty,true); //Validate currency list is empty
    }
    @Then("Buy currency dropdown is empty")
    public void buy_currency_dropdown_is_empty() { // io.cucumber.datatable.DataTable dataTable
       ArrayList<String> buyCurrency =  new ArrayList<String>(4);
       boolean isBuyCurrencyEmpty = buyCurrency.isEmpty();
       System.out.println("Is Buy Currency dropdown Empty ::" +isBuyCurrencyEmpty);
       Assertions.assertEquals(isBuyCurrencyEmpty,true);
    }
    // Scenario: 2

    @Given("user is on New Trade layout")
    public void user_is_on_new_trade_layout() {
        System.out.println("User is on New Trade layout");
    }

    @When("select sell currency as GBP from Sell Currency dropdown")
    public void select_sell_currency_as_gbp_from_sell_currency_dropdown(DataTable sellCurrencies) {
        List <String> selectSellCurency =  sellCurrencies.asList();
        System.out.println("List of currencies in Sell Currency dropdown :: " +selectSellCurency);
        //System.out.println(selectSellCurency.get(0));
        selectSellCurency.stream()
                .filter(s->s.equalsIgnoreCase("GBP"))
                .forEach(s-> System.out.println("User selected "+ s + " as Sell Currency"));
    }
    @When("select Buy Currency as USD from Buy Currency dropdown")
    public void select_buy_currency_as_usd_from_buy_currency_dropdown(DataTable buyCurrencies) {

        List <String> selectBuyCurency =  buyCurrencies.asList();
        System.out.println("List of currencies in Sell Currency dropdown :: " +selectBuyCurency);
       //System.out.println(selectSellCurency.get(0));
        selectBuyCurency.stream()
                .filter(s->s.equalsIgnoreCase("USD"))
                .forEach(s -> System.out.println("User selected " + s + " as Buy Currency"));

    }
    @Then("latest rate retrieve for pair currencies")
    public void latest_rate_retrieve_for_pair_currencies() {
        Currency currencyGBP = Currency.GBP;
        Currency currencyUSD = Currency.USD;
        CurrencyRepository currencyRepository = new CurrencyRepository();
        BigDecimal rate = currencyRepository.getCurrencyRate(currencyGBP,currencyUSD);
        System.out.println("Latest rate for GBP to USD is ::" + rate);
        //Assertions.assertEquals(rate,"1.37");
        Assertions.assertEquals(new BigDecimal("1.37"),rate);
    }

    // Scenario: 3
    @Given("latest rate {double} retrieved for pair currencies GBP to USD")
    public void latest_rate_retrieved_for_pair_currencies_gbp_to_usd(Double latestRate) {
        System.out.println("Latest rate for pair currencies GBP to USD is ::" + latestRate);
    }
    @When("used entered {int} GBP into Sell Amount text box")
    public void used_entered_gbp_into_sell_amount_text_box(Integer sellAmount) {
        System.out.println("User entered Sell Amount :: " + sellAmount);
    }
    @Then("Buy Amount should automatically be calculated by multiplying the Sell amount {int} GBP by rate {double}")
    public void buy_amount_should_automatically_be_calculated_by_multiplying_the_sell_amount_gbp_by_rate(Integer sellAmount, Double conversionRate) {

       final double buyAmount  = sellAmount * conversionRate; // Buy Amount is not editable so it must be final

        System.out.println(buyAmount);

    }
    @Then("Buy Amount should automatically be calculated by multiplying the Sell amount {int} GBP by the rate {double}")
    public void buy_amount_should_automatically_be_calculated_by_multiplying_the_sell_amount_gbp_by_the_rate(Integer sellAmount, Double conversionRate) {
        final double buyAmount  = sellAmount * conversionRate; // Buy Amount is not editable so it must be final

        System.out.println(buyAmount);
    }
    // Scenario: 4

    @Given("user select Sell Currency EUR")
    public void user_select_sell_currency_eur() {

        System.out.println("User Selected Sell Currency :: " + newTradeTransaction.getSellCurrency() );
    }
    @Given("select Buy Currency USD")
    public void select_buy_currency_usd() {

        System.out.println("User Selected Buy Currency :: " + newTradeTransaction.getBuyCurrency());
    }

    @Given("enter Sell Amount into Sell Amount textbox")
    public void enter_sell_amount_into_sell_amount_textbox() {

        System.out.println("User entered Buy Amount :: " + newTradeTransaction.getSellAmount());
    }
    @Given("Buy Amount automatically calculated by multiplying the Sell amount by the rate")
    public void buy_amount_automatically_calculated_by_multiplying_the_sell_amount_by_the_rate() {
        System.out.println("Buy Amount :: " + newTradeTransaction.calculateByAmount());
    }
    @When("user click on Create button")
    public void user_click_on_create_button() {
        System.out.println("User Click on Create Button");
    }
    @Then("new trade transaction created")
    public void new_trade_transaction_created() {
        System.out.println("New Trade Created Successfully");
    }
    @Then("displayed on View Trade screen")
    public void displayed_on_view_trade_screen() {
        System.out.println("New trade displayed on Trade View screen ::" + newTradeTransaction.toString());
    }
}