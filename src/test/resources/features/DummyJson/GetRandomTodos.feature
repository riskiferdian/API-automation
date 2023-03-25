Feature: Get random todos
  @Tugas #Positive Case
  Scenario: Get a random todos with valid parameter
    Given Get a random todos with valid parameter
    When Send request get a random todos
    Then Status code should be 200 OK

  @Tugas #Negative Case
 Scenario Outline:  Get a random todos with invalid parameter id
    Given Get a random todos with invalid parameter id <id>
    When Send request invalid get a random todos
    Then Status code should be 404 Not Found
    Examples:
      | id |
      | 65 |