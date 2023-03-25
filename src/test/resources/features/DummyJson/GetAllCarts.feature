Feature: Get All Carts

  @Tugas #Positif Case
  Scenario: Get all list of carts
    Given Get all carts list
    When Send request get all carts
    Then Status code should 200 OK

    @Tugas #Negative Case
    Scenario: Get invalid all carts
    Given Get invalid all carts
    When Send invalid Get all carts
    Then Status code should be 404 Not Found