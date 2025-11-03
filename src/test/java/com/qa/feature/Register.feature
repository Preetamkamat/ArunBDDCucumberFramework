Feature: Register Account Functionality

  Scenario: Verify Registering Account with Mandatory fields
    Given User navigates to Register Account page
    When User enters below fields
      | firstName | Preetam    |
      | lastName  | Kamat      |
      | telephone | 9657123456 |
      | password  | 12345      |
    And User selects Privacy Policy field
    And User clicks on Continue button
    Then User should get logged in
    And User should be navigated to Account Success page

  Scenario: Verify Registering Account by filling all the fields
    Given User navigates to Register Account page
    When User enters below fields
      | firstName | Preetam    |
      | lastName  | Kamat      |
      | telephone | 1234567890 |
      | password  | 12345      |
    And User selects Yes option for Newsletter
    And User selects Privacy Policy field
    And User clicks on Continue button
    Then User should get logged in
    And User should be navigated to Account Success page

  Scenario: Verify warning messages on Registering Account without filling mandatory fields
    Given User navigates to Register Account page
    When User clicks on Continue button
    Then Proper warning messages should be displayed on Register Account page

  Scenario: Verify Registering Account by selecting Yes Newsletter field
    Given User navigates to Register Account page
    When User enters below fields
      | firstName | Preetam    |
      | lastName  | Kamat      |
      | telephone | 1234567890 |
      | password  | 12345      |
    And User selects Yes option for Newsletter
    And User selects Privacy Policy field
    Then Yes option in the newsletter page should be displayed as selected
    And User clicks on Continue button

