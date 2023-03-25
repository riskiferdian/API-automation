Feature: Login user
  @Tugas #PositiveCase

  Scenario: Login with valid username and password
    Given Login with valid JSON
    When Send request post to login
    Then Status code should be 200 OK
    And Validate json schema success login

  @Tugas #NegativeCase
  Scenario: Login with valid username and empty password
    Given Login with invalid JSON
    When Send request post to login
    Then Should return status code 400
    And Response body message "Invalid credentials"
    And Validate json schema failed login