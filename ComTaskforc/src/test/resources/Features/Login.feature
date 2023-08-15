@LoginAndLogout
Feature: Feature to test login funtionality
@First
  Scenario Outline: Check login is succesfully with valid credentials
    Given user is on login page
    When user enters valid <email> and <password>
    And click on log in button
    Then user is navigated to homepage

    Examples: 
      | email           | password |
      | may@yopmail.com | Abcd@123 |
@Second 
  Scenario Outline: Login with invalid Email Id and valid password
    Given user is on login page
    When user enters invalid <email> and valid <password>
    And click on log in button
    Then the user should see an error message indicating Email is invalid

    Examples: 
      | email     | password |
      | may@yopmail | Abcd@123 |
@Third
  Scenario Outline: Login with valid Email Id and invalid password
    Given user is on login page
    When user enters valid <email> and invalid <password>
    And click on log in button
    Then the user should see an error message indicating Password complexity requirement

    Examples: 
      | email        | password |
      | may@yopmail.com | Abcd     |
@Four
  Scenario Outline: Login with empty username and password fields
    Given user is on login page
    When the user leaves both username and password fields empty
    And click on log in button
    Then the user should see an error message indicating required fields
@Fifth
  Scenario Outline: Logout functionality
    Given the user is logged in
    When the user clicks on the logout button
    Then the user should be logged out and redirected to the login page