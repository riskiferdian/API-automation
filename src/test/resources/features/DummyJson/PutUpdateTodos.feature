Feature: Put update todos
  @Tugas #Positive Case
  Scenario: Put update todos with valid id
    Given Put update todos with valid id 1
    When Send request put update todos
    Then Status code should be 200 OK

  @Tugas #Negative Case
  Scenario: Put update todos with invalid data json body
    Given Given Put update todos with invalid data json file
    When Send request put update invalid todos
    Then Status code should be 400 Bad Request

