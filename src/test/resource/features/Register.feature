Feature: Registration functionality

  Scenario: User creates an account with only mandatory fields
    Given User navigates to Register Account Page
    When User enters the details into below fields
      | firstName | Arun       |
      | lastName  | Mootori    |
      | telephone | 1234567890 |
      | password  |      12345 |
    And User selects Privacy Policy
    And User clicks on Continue button
    Then User account should get created successfully

  Scenario: User creates an account with all fields
    Given User navigates to Register Account Page
    When User enters the details into below fields
      | firstName | Arun       |
      | lastName  | Mootori    |
      | telephone | 1234567890 |
      | password  |      12345 |
    And User selects Yes for Newsletter
    And User selects Privacy Policy
    And User clicks on Continue button
    Then User account should get created successfully

  Scenario: User creates a duplicate account
    Given User navigates to Register Account Page
    When User enters the details into below field
      | firstName | Arun                   |
      | lastName  | Mootori                |
      | email     | amotooricap9@gmail.com |
      | telephone |             1234567890 |
      | password  |                  12345 |
    And User selects Yes for Newsletter
    And User selects Privacy Policy
    And User clicks on Continue button
    Then User should get proper warning about duplicte email

  Scenario: User creates an account without filling any details
    Given User navigates to Register Account Page
    When User dont enter any deatails into fields
    And User clicks on Continue button
    Then User should get proper warning messages for every mandatory field
