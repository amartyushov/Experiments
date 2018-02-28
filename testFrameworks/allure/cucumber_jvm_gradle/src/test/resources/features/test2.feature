Feature: Second Cash withdrawal
  This is a description of the feature

  Background: This is a background, aka @BeforeMethod in jUnit
    When step from background

  @SEVERITY=blocker
  Scenario: Successful withdrawal from an account in credit
  This is a description of scenario
    Given I enter number 10
    And I enter number 20
    When I summ numbers
    Then Result shuold be 30

  @ISSUE=KOALA-469 @TMSLINK=KOALA-430
  Scenario: Successful withdrawal from an account in credit 1
    Given I enter number 10
    And I enter number 20
    When I summ numbers
    Then Result shuold be 30

  Scenario: Successful withdrawal from an account in credit 2
    Given I enter number 10
    And I enter number 20
    When I summ numbers
    Then Result shuold be 40

  Scenario: Successful withdrawal from an account in credit 3
    Given I enter number 10
    And I enter number 20
    When I summ numbers
    Then Result shuold be 30

  Scenario: Successful withdrawal from an account in credit 4
    Given I enter number 10
    And I enter number 20
    When I summ numbers
    Then Result shuold be 30