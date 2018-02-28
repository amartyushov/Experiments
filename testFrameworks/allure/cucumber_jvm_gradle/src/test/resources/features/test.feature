@setup
Feature: Cash withdrawal
  This is a description of the feature

  Scenario Outline: Successful withdrawal from an account in credit 333
    Given I enter number <input1>
    And I enter number <input2>
    When I summ numbers
    Then Result shuold be <sum>
    Examples:
      | input1 | input2 | sum |
      | 1      | 2      | 3   |
      | 11     | 22     | 33  |
      | 0      | 1      | 1   |
      | 100    | 200    | 300 |


  Scenario: Successful withdrawal from an account in credit 4
    Given I enter number 10
    And I enter number 20
    When I summ numbers
    Then Result shuold be 30