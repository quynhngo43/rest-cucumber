@add
Feature: Add new product

  Scenario Outline: Add new product
    Given the path "add" to the endpoint
    And the payload of the request with BrandName as <brand>, Features as <features>, LaptopName as <name>
    When I perform the POST request to add new product
    Then the status code "200" should return
    And the product is added successfully with an integer Id
    Examples:
      | brand | features               | name     |  |
      | Dell  | 8GB RAM,1TB Hard Drive | Latitude |  |

  Scenario: Add new product with invalid payload (json request body)
    Given the path "add" to the endpoint
    But I supply invalid json payload
    When I perform the POST request to add new product
    Then the status code "200" should return