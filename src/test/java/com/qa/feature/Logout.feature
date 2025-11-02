Feature: Logout functionality

  Scenario: Verify Logging out using Logout option from My Account
    Given User is logged in
    When User clicks on My Account drop menu
    And User clicks on Logout option
    Then User should get logged out

  Scenario: Verify Logging out by selecting Logout from Right column
    Given User is logged in
    When User clicks on Logout option from Right Column options
    Then User should get logged out