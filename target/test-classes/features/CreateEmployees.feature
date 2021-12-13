@CreateEmployee
Feature: Creating Employees
  
  Description: This feature creates employees

  Background: 
    Given a JWT is generated

  Scenario Outline: Creating employees
    Given a request is prepared to create employees
    When employee data provided is "<employeeFirstName>", "<employeeLastName>", "<employeeMiddleName>", "<employeeGender>", "<employeeBirthday>", "<employeeJobStatus>", "<employeeJobTitle>"
    Then employees are created
   # Then employees are deleted

    Examples: 
      | employeeFisrtName | employeeLastName | employeeMiddleName | employeeGender | employeeBirthday | employeeJobStatus | employeeJobTitle |
      | Bob               | Bob              | Bob                | M              | 1984-10-15       | Employee          | Developer        |
      | TestName          | LastName         | MiddleName         | F              | 1990-05-08       | Employee          | CEO              |
      | Name2             | LastName2        | Doe                | M              | 1992-04-05       | Super Contractor  | QA Tester        |
