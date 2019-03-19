
Feature: Test Rest API using JsonPlaceHolder

  Scenario: Rest POST example
    Given post data
    When success code is 201
    Then assert for name