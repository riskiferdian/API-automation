Feature: Get single todos
  @Tugas #Positive Case
  Scenario Outline: Get a single todos with valid parameter id
    Given Get a single todos with walid parameter id <id>
    When Send request get a single todos
    Then Status code should be 200 OK
    Examples:
      | id |
      | 72 |

  @Tugas #Negative Case
  Scenario: Get a single todos with invalid parameter
    Given Get a single todos with invalid parameter "xyz"
    When Send request get a single todos
    Then Status code should be 404 Not Found