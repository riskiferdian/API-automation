Feature: Testing Update a product dummyjsonAPI
  @Tugas #Positive Case
  Scenario Outline: Put update a product with valid data json body
    Given Put update a product with valid id <id> and json body
    When Send request put update product
    Then Status code should be 200 OK
    And Validate json schema update product
  Examples:
    | id |
    | 12 |
    | 99 |

  @Tugas #Negative Case
  Scenario Outline: Put update a product with invalid data json body
    Given Put update a product with valid id <id> and invalid json body
    When Send request put update product
    Then Status code should be 400 Bad Request
  Examples:
    | id |
    | 12 |
    | 99 |