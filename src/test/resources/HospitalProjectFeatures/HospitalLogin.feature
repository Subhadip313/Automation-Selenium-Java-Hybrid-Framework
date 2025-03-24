Feature: Login functionality in Hospital Management System

  @Login
  Scenario Outline: Valid login to Hospital Management System
    Given the user is on the login page

    When the user enters "<email>" and "<password>"
    Then the user "<username>" should be logged in
    Examples:
      | email               | password | username    |
      | sudip1959@gmail.com | 12345678 | Sudip Dutta |
