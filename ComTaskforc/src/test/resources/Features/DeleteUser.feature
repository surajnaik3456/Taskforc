@DeleteUser
Feature: Feature to test Delete users functionality

  @tag1
  Scenario Outline: Test the user is getting deleted
    Given user is on homepage
    When user clicks on user icon
    Then user gets user management screen
    And user clicks on ellipsis menu for the "<email>" user
    Then the dropdown shows up
    And click on delete option
    Then Delete user screen showsup with Cancel and Delete button
    And user clicks on Delete button
    Then user is deleted from the user management table

    Examples: 
      | email                         |
      | test_4_13_08_2023@yopmail.com |