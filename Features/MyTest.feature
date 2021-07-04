Feature: Create new trades

Scenario: New trade is accessible from "Book trades" view
  Given valid user is on Book trades
  When  New trade button is clicked
  Then  New trade layout is displayed
  And   Sell Currency dropdown is empty
  And   Buy currency dropdown is empty

Scenario: Latest conversion rate retrieve for pair currency
  Given user is on New Trade layout
  When  select sell currency as GBP from Sell Currency dropdown
        |GBP|
        |USD|
        |EUR|
        |INR|
  And   select Buy Currency as USD from Buy Currency dropdown
        |GBP|
        |USD|
        |EUR|
        |INR|
  Then  latest rate retrieve for pair currencies

Scenario: Create a new trade for selected pair currencies
  Given latest rate 1.37 retrieved for pair currencies GBP to USD
  When  used entered 1000 GBP into Sell Amount text box
  Then  Buy Amount should automatically be calculated by multiplying the Sell amount 1000 GBP by the rate 1.37

Scenario: Successful New Trade transaction created and store in Database and displat on Trade View page
  Given user select Sell Currency EUR
  And   select Buy Currency USD
  And   enter Sell Amount into Sell Amount textbox
  And   Buy Amount automatically calculated by multiplying the Sell amount by the rate
  When  user click on Create button
  Then  new trade transaction created
  And   displayed on View Trade screen




    #|GBP|
    #|USD|
    # |EUR|
    #|INR|



  #| USD          | 1.37            | 500         |