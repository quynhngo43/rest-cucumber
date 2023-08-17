@update
Feature: Update an existing product

  Background:
    Given the path "add" to the endpoint
    And the payload of the request with BrandName as "Dell", Features as "8GB RAM, 1TB Hard Drive", LaptopName as "Latitude"
    When I perform the POST request to add new product
    Then the status code "200" should return
    And the product is added successfully with an integer Id

  Scenario Outline: TC <id>: Post and then update the Laptop <name> of the Brand <brand>
    Given the path "update" to the endpoint
    When I perform the PUT request with id and BrandName as <brand>, Features as <features>, LaptopName as <name>
    Then Status code "200" should be returned
    And Details should get updated
    Examples:
      | id | brand | features                        | name     |
      | 01 | Dell  | 8GB RAM, 15 Inch Lcd, Touch Pad | Latitude |

