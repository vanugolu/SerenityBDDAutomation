Feature: Test Rest API

  Scenario: Searching for a country
    Given search for country code "IN"
    When success is 200
    Then check if name is "India"