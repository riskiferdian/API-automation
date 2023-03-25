Feature:
  @tugas #Positive Case
  Scenario: Get single cart with valid param
    Given Get single cart with valid id 2
    When Send request get single cart
    Then Status code should be 200 OK
    And Response body id should be 2
