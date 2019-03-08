Feature: Search Recommendations

Scenario: Launch Google Search Page
    Given "Sreenivas" Open Google Search Page
    When Search the keyword "cucumber"
    Then It should give  recommendations
