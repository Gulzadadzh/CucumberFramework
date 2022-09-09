Feature: Login Functionality

Scenario: Login with valid credentials
Given go to HRMS main page
When login with valid credentials
Then verify the dashboard logo is displayed
And quit the browser

Scenario: Login with invalid credentials
Given go to HRMS login page
When login with invalid credentials
Then verify the error message
And quit the browser