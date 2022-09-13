Feature: Login Functionality

//@smoke
  Scenario: Login with valid credentials
   
    When login with valid credentials
    And verify the dashboard is displayed

		
@smoke
  Scenario: login with invalid credentials
  
    When login with invalid credentials
    Then varify the error message

