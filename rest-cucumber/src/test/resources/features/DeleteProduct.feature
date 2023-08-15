@delete
Feature: Delete an existing product
  Background:
    Given the path "add" to the endpoint
    And the payload of the request with BrandName as "Dell", Features as "8GB RAM, 1TB Hard Drive", LaptopName as "Latitude"
    When I perform the POST request to add new product
    Then the status code "200" should return
    And the product is added successfully with an integer Id
  Scenario: Delete the existing product
    Given the path "delete" to the endpoint
    When I perform the DELETE request with id
    Then Status code "200" of the delete request should be returned
    And the product id should not exist with status code "404"

