
Feature: Preference

  @HomeScreen
  Scenario: Verify changing wifi name
    Given user launches demo application
    When user clicks on Preference btn, Preference Dependencies btn should  appear
    When user clicks on Preference Dependencies btn, wifi check box should appear
    When user clicks on wifi check box, WifiSettings btn should appear
    When user clicks on WifiSettings btn, WifiSettings edit box should appear
    When user enters wifi name and  clicks on ok btn
    Then Wifi edit box should close

  @Views
  Scenario: Verify time change
    Given user launches demo application
    When user clicks on Views btn, Date Widgets btn should  appear
    When user clicks on Date Widgets btn, Inline btn should  appear
    When user clicks on Inline btn, time icon should  appear
    Then user should be able to change the time
