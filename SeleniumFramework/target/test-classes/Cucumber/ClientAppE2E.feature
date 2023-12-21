@tag
Feature: Place order from Ecommerce application
  I want to use this template for my feature file
  
  Background:
	Given Navigate to ecommerce page

  @tag2
  Scenario Outline: End to End flow from Ecommerce application
    Given Login with username <username> and password <password>
    When Add product <product> from cart
    And Checkout <product> and submit order
    Then Verify "THANKYOU FOR THE ORDER." message is displayed on order confirmation page
    Then Go to orders page and verify order id

    Examples: 
      | username  									| password | product  					|
      | sathishsuresh984@gmail.com 	| Satz@984 | IPHONE 13 PRO		  |
      | sathishsuresh984@gmail.com  | Satz@984 | ADIDAS ORIGINAL    |
