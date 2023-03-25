Feature: Post add a new todos
  @Tugas #Positive Case
  Scenario: Post add new todos with valid data json body
    Given Post add new todos with valid data json file
    When Send request post add new todos
    Then Status code should be 200 OK
    And Add validate json schema add new todos

  @Tugas #Negative Case
  Scenario: Post add new todos with invalid data json body
    Given Post add new todos with invalid data json body file
    When Send request invalid post add new todos
    Then Status code should be 400 Bad Request