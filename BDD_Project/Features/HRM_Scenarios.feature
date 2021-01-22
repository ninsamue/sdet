@HRM
Feature: HRM System

  Background: Login into the HRM System
  	Given I navigate to Alchemy HRM System and login to the application

  @Activity1
  Scenario: Creating a job vacancy
    And Navigate to Recruitment Page
    And Click on Vacancies Menu
    Then Vacancies Page should be displayed
    When Add Button is clicked
    And Job Vacancy Form is filled and saved - job title "DevOps Engineer", vacancy name "DevOps Consultant 1", hiring manager "Hello Tester"
    Then Vacancy should be created - job title "DevOps Engineer", vacancy name "DevOps Consultant 1", hiring manager "Hello Tester"
    And Close the Browser
    
  @Activity2
  Scenario: Adding a candidate for recruitment
    And Navigate to Recruitment Page
    And Click on Add Button
    Then Fill in the details of the candidate
    And Upload a resume to the form
    And Save Button is clicked
    Then Confirm Candidate Entry in Recruitments Page
    And Close the Browser

  @Activity3
  Scenario Outline: Add multiple employees
    And Click on the PIM option in the menu
    And Click on Add Employee Button
    When All required fields are filled in the Add Employee form "<firstName>", "<lastName>"
    Then Verify Employee is created "<firstName>", "<lastName>"
    And Close the Browser

    Examples: 
      |firstName|lastName |
      |Ritu |Simon|
      |Brown|Smith|


  @Activity4
  Scenario Outline: Creating multiple vacancies
    And Navigate to Recruitment Page
    And Click on Vacancies Menu
    Then Vacancies Page should be displayed
    When Add Button is clicked
    And Job Vacancy Form is filled and saved - job title "<title>", vacancy name "<vacancy>", hiring manager "<hiringManager>"
    Then Vacancy should be created - job title "<title>", vacancy name "<vacancy>", hiring manager "<hiringManager>"
    And Close the Browser

    Examples: 
      |title|vacancy|hiringManager|
      |DevOps Engineer |DevOps Consultant 11|Hello Tester|
      |Android Developer|Development 11|Hello Tester|

    