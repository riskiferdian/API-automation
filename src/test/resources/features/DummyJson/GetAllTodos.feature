Feature: get all todos
  @Tugas #Positive Case
  Scenario: Get all todos with valid parameter
    Given Get all todos with valid parameter
    When Send request get all todos
    Then Status code should be 200 OK

  @Tugas #Negative Case
  Scenario Outline: Get all todos with invalid parameter id
    Given Get all todos with invalid parameter id <id>
    When Send request invalid get all todos
    Then Status code should be 404 Not Found
    Examples:
      | id   |
      | 1000 |
