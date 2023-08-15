@get
Feature: Get details of a specific product
  Scenario: Get details of an existing product
    Given the path "find" to the endpoint
    When I perform the GET request with id as "2708"
    Then Status code "200" of the get request should be returned