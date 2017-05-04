Feature: Check how to verify exceptions

  @exclude @does_not_work
  Scenario: 1. JUnit approach
    Then the user gets a Null pointer exception

  @it_works
  Scenario: 2. Exception holder approach
    When a failure is expected
    And you attempt something illegal
    Then it fails