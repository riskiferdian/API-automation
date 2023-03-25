Feature: Get todos by user
  @Tugas #Positive Case
  Scenario: Get todos by user with valid parameter id
    Given Get todos by user with valid parameter id 5
    When Send request get todos by user
    Then Status code should be 200 OK

  @Tugas #Negative Case
  Scenario: Get all todos by user with invalid parameter
    Given Get all todos by user with invalid parameter "xyz"
    When Send request invalid get todos by user
    Then Status code should be 400 Bad Request
