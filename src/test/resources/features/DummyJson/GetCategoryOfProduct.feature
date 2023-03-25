Feature: Testing get category of product dummyjson API
  @Tugas #Positive Case
  Scenario Outline: Get products of category with valid path
    Given Get products of category with valid parameter "<category>"
    When Send request get category of product
    Then Status code should be 200 OK
    And Validate category json schema
  Examples:
    | category    |
    | smartphones |
    | laptops     |

  @Tugas #Negative Case
  Scenario Outline: Get products of category with invalid path
    Given Get products of category with invalid path "<category>"
    When Send request get category of product
    Then Status code should be 200 OK
  Examples:
    | category   |
    | smartphone |
    | laptop     |
