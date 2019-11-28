Feature: Open is.stuba

  Scenario: Loading isStuba webpage
    Given Sergey opened browser
    When he open "https://is.stuba.sk/"
    Then he should be on "https://is.stuba.sk/"