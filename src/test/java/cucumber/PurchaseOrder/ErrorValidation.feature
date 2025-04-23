@tag
Feature: Enter wrong email and password and verify the error

  Background:
    Given I landed on Main Page

  @tag2
  Scenario Outline: I want to login with incorrect email and password
    Given I logged with email <email> and password <password>
    Then Error message "Incorrect email or password." displayed

    Examples:
      | email        | password |
      | asdf@awd.com | asdf     |
