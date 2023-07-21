Feature: As authorised user
  I change default time zone
  So I can see event's time for new timezone

  Scenario:Successful timezone changing
    When I click on not started event on Dashboard page
    And I click Site menu button on Event page
    And I click Settings button on Site menu sidebar
    And I choose random Time zone from drop down menu on Settings page
    And I click Apply button on Settings page
    Then I see new event beginning time on Event page