Feature: Try groovy with cucumber

  Scenario: Check how I sum integers
    Given I input 10
    And I input 20
    When I sum
    Then Sum is 30

  Scenario: World verification
    Given greeting