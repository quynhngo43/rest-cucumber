@all
Feature: Get details of all products
  Scenario: Get details of all products
    Given the path "all" to the endpoint
    When I perform the GET request
    Then the status code "200" of the GET ALL request should be returned