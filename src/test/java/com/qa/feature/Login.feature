Feature: Login functionality

  Scenario: Verify Login with valid credentials
    Given User navigates to Login page
    When User enters valid email and valid password into the fields
    And User clicks on Login button
    Then User should get logged in successfully
    And User should be taken to My Account page

  Scenario: Verify Login with invalid credentials
    Given User navigates to Login page
    When User enters invalid email and invalid password into the fields
    And User clicks on Login button
    Then User should not get login
    And User should get a proper warning message

  Scenario: Verify Login with invalid email and valid password
    Given User navigates to Login page
    When User enters invalid email and valid password into the fields
    And User clicks on Login button
    Then User should not get login
    And User should get a proper warning message

  Scenario: Verify Login with valid email and invalid password
    Given User navigates to Login page
    When User enters valid email and invalid password into the fields
    And User clicks on Login button
    Then User should not get login
    And User should get a proper warning message

  Scenario: Verify Login without providing any credentials
    Given User navigates to Login page
    When User do not enter any credentials into the email and password fields
    And User clicks on Login button
    Then User should not get login
    And User should get a proper warning message
