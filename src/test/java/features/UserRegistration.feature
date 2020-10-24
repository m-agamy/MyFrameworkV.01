Feature: User Registration
  I want to make sure that user can register into the website


  Scenario: User registration with valid credentials
    Given User openned the homepage
    When User click on registration link
    And User enter his valid credentials
    And User click on Submit
    Then User registration completed