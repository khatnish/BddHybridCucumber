Feature: Login functionality

  Scenario Outline: Login with valid credentials
    Given User navigates to login page
    When User enters valid email address <username> into email field
    And User enters valid password <password> into password field
    And User clicks on Login button
    Then User should get successfully logged in

    Examples: 
      | username               | password |
      | amotooricap1@gmail.com |    12345 |
      | amotooricap2@gmail.com |    12345 |
      | amotooricap3@gmail.com |    12345 |

  Scenario: Login with invalid credentials
    Given User navigates to login page
    When User enters invalid email address into email field
    And User enters invaid password "12345678" into password field
    And User clicks on Login button
    Then User should get a proper warning message about credentials mismatch

  Scenario: Login with valid email invalid password
    Given User navigates to login page
    When User enters valid email address "amotooricap9@gmail.com" into email field
    And User enters invaid password "123453456" into password field
    And User clicks on Login button
    Then User should get a proper warning message about credentials mismatch

  Scenario: Login with invalid email valid password
    Given User navigates to login page
    When User enters invalid email address into email field
    And User enters valid password "12345" into password field
    And User clicks on Login button
    Then User should get a proper warning message about credentials mismatch

  Scenario: Login without providing any credentials
    Given User navigates to login page
    When User does not enter email address into email field
    And User does not enter password into password field
    And User clicks on Login button
    Then User should get a proper warning message about credentials mismatch
