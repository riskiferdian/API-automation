Feature: Testing delete a product dummyjson API
  @Tugas #Positive Case
  Scenario Outline: Delete product with valid id
    Given Delete product with valid parameter id <id>
    When Send request delete product
    Then Status code should be 200 OK
  Examples:
    | id |
    | 23 |
    | 14 |

  @Tugas #Negative Case
  Scenario Outline: Delete product with invalid id
    Given Delete product with invalid id "<id>"
    When Send request delete product
    Then Status code should be 404 Not Found
  Examples:
    | id  |
    | xyz |
    | 200 |




