@activity2_5
Feature: Login Test

  Scenario Outline: Testing Login with Example
    Given User is on Login page
    When User enters "<username>" and "<password>"
    Then Read the page title and confirmation message
    And Close the Login Form Webpage

    Examples: 
      | username  | password |
      | admin     | password |
      | adminUser | password |
