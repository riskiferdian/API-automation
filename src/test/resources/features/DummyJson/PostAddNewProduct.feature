Feature: testing add product
  @Tugas #Positive Case
  Scenario: Post a new product with valid data json body
    Given Post new product with valid json
    When Send request post new product
    Then Status code should be 200 OK
    And Response body page is new product with id

  @Tugas #Negative Case
  Scenario: Post a new product with invalid data json body
    Given Post new product with empty json
    When Send request post new product
    Then Status code should be 400 Bad Request