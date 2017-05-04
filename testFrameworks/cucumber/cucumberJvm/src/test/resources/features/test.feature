Feature: Cash withdrawal
  Scenario: Successful withdrawal from an account in credit
    Given I enter number 10
    And I enter number 20
    When I summ numbers
    Then Result shuold be 30