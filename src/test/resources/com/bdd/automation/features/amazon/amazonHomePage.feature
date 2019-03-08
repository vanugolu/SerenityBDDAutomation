Feature: Launch Amazon HomePage and Hover on Categories

Meta:
@issue:SVOI-220

Scenario: Launch Amazon Home Page
    Given "Sreenivas" Open Amazon Home Page
    When Hover on Category Link
    Then It should contain "Echo & Alexa"
