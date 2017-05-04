@exclude
Feature: Check simple application
  Scenario: Just open app and perform simple action
    Given I enter main page of application
    When I enter "Hello, world" to text field
    And press button "See details"
    Then calendar page is opened



  Scenario: Just open app and perform simple action
    Given I enter main page of application
    When I enter "Hello, world" to text field
    And press button "See details"
    Then calendar page is opened