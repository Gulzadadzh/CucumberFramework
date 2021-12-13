//@APIworkflow
Feature: Syntax HRMS AP workflow	
	Description: This feature file Syntax HRMS API Workflow

  Background: 
  	Given a JWT is generated

  	@APIworkflow
  	Scenario:
  	Given a request is prepared to create an employee
  	When a POST call is made to create an employee 
  	Then the status code for creating an employee is 201
  	And the employee is created 
  	And the employee ID is stored as a global variable to be used for other calls 
  	
  	
  @progression
  Scenario: Retreiving created employee
    Given a request is prepared to retreive the created employee
    When a GET call is made to retreive the created employee
    Then the status code for retreiving the created employee is 200
    And the retreived employee ID "employee[0].employee_id" matches the globally stored employee ID
    And the retrieved data at "employee" matches the data used to create an employee with employee ID "employee[0].employee_id"
      | emp_firstname | emp_middle_name | emp_lastname | emp_birthday | emp_gender | emp_job_title   | emp_status |
      | Masha         |     A           | Medved       | 2016-09-21   | F          | Cloud Architect | Employee   |
  	
  	@progression
  	 Scenario: Retreiving all employees and verifying that created employee details display in the response
    Given a request is prepared to retreive all employee
    When a GET call is made to retreive all employees
    Then the status code for retreiving all employees is 200
    And the retreived data "Employees" contains the globally stored employee ID
    And the retreived data matches the data that was used to create an employee
  	
  	