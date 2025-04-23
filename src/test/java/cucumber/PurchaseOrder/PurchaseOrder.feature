@tag
Feature: Purchase the order from Ecommerce

  Background:
    Given I landed on the Main Page

    @tag2
    Scenario Outline: Positive Test of Submitting the order 
        Given I logged with username <email> and password <password>
        When I added product <productName> to Cart
        And I Checkout <productName> and submitt the order
        Then The message "THANK YOU FOR THE ORDER." is displayed

        Examples:
        | email                      | password         | productName |
        | awdawdawdawddawd@gmail.com | QWERTY123#qwerty | ZARA COAT 3 |



