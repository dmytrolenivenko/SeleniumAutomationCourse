@tag
Feature: Purchase the order from Ecommerce

  Background:
    Given I landed on the Main Page

    @tag2
    Scenario Outline: Positive Test of Submitting the order 
        Given I logged with email <email> and password <password>
        When I added product <productName> to Cart
        And I Checkout <productName> and submit the order in <country>
        Then The message 'THANK YOU FOR THE ORDER.' is displayed

        Examples:
        | email                      | password         | productName | country |
        | awdawdawdawddawd@gmail.com | QWERTY123#qwerty | ZARA COAT 3 | Por     |
        | awdawdawdawddawd@gmail.com | QWERTY123#qwerty | ZARA COAT 3 | Aus     |


