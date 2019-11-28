Feature: Entering messages card

  Scenario: Entering the message card
    Given Zuzana is signed in with credentials "xwlachovska" and "Wlacha753951"
    When she click on messages
    Then she should see mail box