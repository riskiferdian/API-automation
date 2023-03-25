Feature: Testing post search product dummyjson API
  @Tugas #Positive Case
  Scenario Outline: Get search product with valid parameter string
    Given Get search product with valid path "<string>"
    When Send request get search product
    Then Status code should be 200 OK
    And Validate json schema search product
  Examples:
    | string |
    | laptop |
    | phone  |

  @Tugas #Negative Case
  Scenario Outline: Get search product with valid parameter string
    Given Get search product with invalid parameter "<string>"
    When Send request get search product
    Then Status code should be 200 OK
  Examples:
    | string  |
    | 123     |
    | phone56 |