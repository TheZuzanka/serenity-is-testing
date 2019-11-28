Feature: Sending new message to Samuel

  Scenario: Entering the message card
    Given Zuzana is signed in with credentials "xwlachovska" and "Wlacha753951" and enters messages tab
    When she click on new message
    And she gives email "xvaneks@is.stuba.sk" subject "test serenity"
    And she types message "Zuzka testuje Javu. (: "
    And she save message to sent
    And she clicks send message
    Then the message should be sent