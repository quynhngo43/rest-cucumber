@add @product
Feature: Add new product

  Background:
    Given the path "add" to the endpoint

  Scenario Outline: Add new product
    And the payload of the request with BrandName as <brand>, Features as <features>, LaptopName as <name>
    When I perform the POST request to add new product
    Then the status code "200" should return
    And the product is added successfully with an integer Id
    Examples:
      | brand | features               | name     |
      | Dell  | 8GB RAM,1TB Hard Drive | Latitude |
      | HP    | 16GB                   | ABC      |

  Scenario: Add new product with invalid payload (json request body)
    But I supply invalid json payload
    When I perform the POST request to add new product
    Then the status code "400" should return