@CRM
Feature: CRM Site
  
  Background: Login into the CRM Site
  	Given I navigate to Alchemy CRM site and login to the application
  

  @Activity1
  Scenario: Counting Dashlets
    Then Count the Dashlets and Print
    And Close the Browser
    
  @Activity22
  Scenario: Create leads using parameterization
  	And Navigate to Sales Leads CreateLead
    Then Fill in the Create Lead Accounts with Salution "Ms. ", First Name "Ritu", Last Name "Simon"
    And Click Save to Finish
    Then Navigate to View Leads page to see results with Salution "Ms. ", First Name "Ritu", Last Name "Simon"
    And Close the Browser
    
  @Activity3
  Scenario Outline: Schedule a meeting and invite members
    And Navigate to Activities Meetings ScheduleaMeeting
    And Enter the details of the meeting
    And Search for members and add them to the meeting    
    |fname|lname|email|
    |Chris|Olliver|chris@example.com|
    |Jim|Brennan|jim@example.com|
    |Max|Jensen|tom@example.com|
    Then Navigate to View Meetings page and confirm creation of the meeting
    And Close the Browser
    
  @Activity4
  Scenario Outline: Creating a Product
	  And Navigate to All Products CreateProduct
    And Enter Details of the Product "<productName>", "<productPrice>"
    And Click Save
    When Navigated to View Products Page
    Then All Products should be listed "<productName>"
    And Close the Browser

    Examples: 
      | productName  | productPrice |
      |toy | 5 |
      |pen | 10|
