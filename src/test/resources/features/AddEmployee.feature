@addEmployee
Feature: Add Employee

  Background: 
    When login with valid credentials
    Then navigate to add employee page

  Scenario: Add employee without login details but without middle name
    And enter first and last name
    Then click on save Button
    And verify the employee is added succesfully

  Scenario: Add employee with login credentials
    And enter first and last name
    When check login details checkbox
    Then enter login details
    Then click on save Button
    And verify the employee is added succesfully

  @parameter
  Scenario: Add employee without login details but with middle name
    When: enter first name as "Ahmet" middle name as "Can" and last name as "Bicer"

    Then click on save Button
    And verify that "Ahmet Can Bicer" is added succesfully

	@examples
  Scenario Outline: Adding multiple employees without login details
    When enter employee "<First Name>", "<Middle Name>" and "<Last Name>"
    Then click on save Button
    And verify that "<First Name>", "<Middle Name>" and "<Last Name>" is succesfully added

    Examples: 
      | First Name | Midd;le Name | Last Name |
      | Mark       | J            | Smith     |
      | Hunter     | ABC          | Musoev    |
      | John       | M            | Wick      |
      | John       | f            | Kennady   |
      
      
     @dtWithHeader
  Scenario Outline: Adding multiple employees without login details
    When add multiple employees and verify thea added
    Examples: 
      | First Name | Midd;le Name | Last Name |
      | Mark       | J            | Smith     |
      | Hunter     | ABC          | Musoev    |
      | John       | M            | Wick      |
      | John       | f            | Kennady   |
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
