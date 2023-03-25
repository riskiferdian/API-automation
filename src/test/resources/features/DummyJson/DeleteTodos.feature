Feature: Delete a todos
  @Tugas #Positive Case
  Scenario: Delete todos with valid id
    Given Delete todos with valid id 1
    When Send request delete todos
    Then Status code should be 200 OK

  @Tugas #Negative Case
  Scenario: Delete todos with invalid id
    Given Delete todos with invalid id 153
    When Send request invalid delete todos
    Then Status code should be 404 Not Found