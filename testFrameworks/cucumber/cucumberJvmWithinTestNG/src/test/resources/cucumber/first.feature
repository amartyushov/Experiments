Feature: first

  @exclude
  Scenario: simple first scenario
    Given Number is 1
    Given Number is 2
    When I sum numbers
    Then I get 3