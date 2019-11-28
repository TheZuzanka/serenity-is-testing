Feature: Log in is.stuba as Zuzana

  Scenario: Loading isStuba webpage
    Given she is on ais
    When she enters name "xwlachovska"
    And she enters password "Wlacha753951"
    Then she should be logged in