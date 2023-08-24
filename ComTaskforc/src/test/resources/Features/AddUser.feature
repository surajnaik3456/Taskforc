@AddUser
Feature: Feature to test Add users functionality

  @AddUserScreen
  Scenario: 
    Given user is on homepage
    When user clicks on user icon
    And user clicks on Add user button
    Then user gets Add user screen

  @UserAdded
  Scenario Outline: 
    Given user is on homepage
    When user clicks on user icon
    Then user gets user management screen
    And user clicks on Add user button
    When user fills the form with "<email>","<password>","<firstname>","<lastname>", Role and Status
    And user clicks on send invite button
    Then user gets added to Active user

    Examples: 
      | email                         | password | firstname | lastname |
      | test02_13_08_2023@yopmail.com | Abcd@124 | Test      | two      |
