@Adduser
Feature: Feature to test Add users functionality

  Scenario: 
    Given User is on homepage
    When User clicks on user icon
    And user clicks on Add user button
    Then user gets Add user screen

  @Homepage
  Scenario Outline: 
    Given User is on homepage
    When User clicks on user icon
    Then User gets user management screen
    And User clicks on Add user button
   When user fills the form with "<email>","<password>","<firstname>","<lastname>", Role and Status
    And User clicks on send invite button
    Then User gets added to Active user

    Examples: 
      | email                         | password | firstname | lastname |
      | test_4_12_08_2023@yopmail.com | Abcd@124 | Test      | four     |
