Feature: testing get all product categorise dummyjson API
  @Tugas #Positive Case
  Scenario: Get all products categories with valid path
    Given Get all products categories with valid path
    When Send request get all categories
    Then Status code should be 200 OK
    And Validate all categories json schema

  @Tugas #Negative Case
  Scenario: Get all products categories with invalid path
    Given Get all products categories with invalid path
    When Send request get invalid all categories
    Then Status code should be 404 Not Found