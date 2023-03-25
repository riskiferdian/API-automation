Feature: Testing Limit & Skip products dummyjson API
  @Tugas #Positive Case
  Scenario Outline: Get Limit and skip products with valid parameter limit and skip
    Given Get limit <limit> and skip <skip> product
    When Send request get limit and skip
    Then Status code should be 200 OK
    And response body limit is <limit> and skip is <skip>
  Examples:
    | skip | limit |
    | 5    | 40    |
    | 8    | 15    |

    @Tugas #Negative Case
  Scenario Outline: Get Limit and skip products with valid parameter limit and skip
    Given Get invalid limit "<limit>" and skip "<skip>" product
    When Send request get limit and skip
    Then Status code should be 400 Bad Request
    Examples:
      | skip | limit |
      | x    | 40    |
      | 8    | y     |

