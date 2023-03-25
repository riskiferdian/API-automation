Feature: Limit and skip todos
  @Tugas #Positive Case
  Scenario Outline: Get Limit and skip todos with valid parameter limit and skip
    Given Get limit <limit> and skip <skip> todos
    When Send request get limit and skip
    Then Status code should be 200 OK
    And responses body limit is <limit> and skip is <skip>
    Examples:
      | skip | limit |
      | 10   | 3     |

  @Tugas #Negative Case
  Scenario Outline: Get Limit and skip todos with invalid parameter limit and skip
    Given Get limit <limit> and invalid skip "<skip>" todos
    When Send request get limit and skip
    Then Status code should be 400 Bad Request
    Examples:
      | skip | limit |
      | null | 3     |