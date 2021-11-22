Feature: Login Functionality

@smoke
  Scenario: Login with valid credentials
    #Given go to HRMS login page
    When login with valid credentials
    And verify the dashboard is displayed

  #Then quit the browser
  @smoke
  Scenario: login with invalid credentials
    #Given go to HRMS login page
    When login with invalid credentials
    Then varify the error message
#Then quit the browser
