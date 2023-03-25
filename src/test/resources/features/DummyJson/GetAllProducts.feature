Feature: get all products
  @Tugas #Positive Case
  Scenario: get all list of products
    Given Get all product list
    When Send request get all products
    Then Status code should be 200 OK

  @Tugas #Negative Case
  Scenario: get invalid all list of products
    Given Get invalid all products
    When Send request invalid get all products
    Then Status code should be 404 Not Found