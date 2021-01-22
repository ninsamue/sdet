@Job_Board
Feature: Job Board System
 
  @Activity1
  Scenario: Create a new user
    Given I navigate to Alchemy Jobs admin site and log in
    And Click on Users menu in the left hand menu
    And Click on Add New Button
    Then Add New User form should be displayed
    And Fill in the neccessary details
    And Click on Add New User Button
    Then Verify the User is created
    And Close the Browser


 @Activity2
  Scenario: Searching for jobs using XPath
    Given I navigate to Alchemy Jobs site
    And Navigate to Jobs Page
    And Enter Keyword
    And Change Job Type to show only Full Time jobs
    And Click on Search Jobs
    Then Verify Jobs are listed
    And Print the title of the Job listing
    And Click on Apply for Job button
    And Close the Browser
    
  @Activity3
  Scenario: Posting a job using parameterization
    Given I navigate to Alchemy Jobs site
    And Navigate to Post Jobs Page
    Then Enter Email "test0126@test.com", Job Title "Test Lead", Job Type "Full Time", Description " Manage Job Description", Company Name "IBM"
    And Click on Preview and Post
    And Verify in the Job Listing "Test Lead"
    And Close the Browser


  @Activity4
  Scenario Outline: Using Examples table to post a job
    Given I navigate to Alchemy Jobs site
    And Navigate to Post Jobs Page
    Then Enter Email "<email>", Job Title "<jobTitle>", Job Type "<jobType>", Description " <Description> ", Company Name " <companyName> "
    And Click on Preview and Post
    And Verify in the Job Listing "<jobTitle>"
    And Close the Browser

    Examples: 
      | email  						| jobTitle | jobType  |Description 			|companyName |
      | test1123@test.com | Tester	 | Full Time|Full Time Tester	|ABC					|
   		| test1124@test.com | Tester	 |Internship|Internship Tester|ABC					|
