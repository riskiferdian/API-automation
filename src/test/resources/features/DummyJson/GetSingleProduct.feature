Feature: Testing get single product dummy json
  #Positive case
  @Tugas
  Scenario: get all product with valid parameter
    Given Get single product with valid id 2
    When Send request get single product
    Then Status code should be 200 OK
    And Response body id should be 2
    And validate json schema get all products

    #Negative case
    @Tugas
    Scenario: Get single product with invalid parameter id
      Given Get single product with invalid id "xyz"
      When Send request get single product
      Then Status code should be 404 Not Found