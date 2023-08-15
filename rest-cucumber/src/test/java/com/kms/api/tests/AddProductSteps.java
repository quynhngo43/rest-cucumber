package com.kms.api.tests;

import static com.kms.api.util.RestUtil.mapRestResponseToPojo;

import com.kms.api.model.LaptopBag;
import com.kms.api.requests.RequestFactory;
import com.kms.api.util.RequestBuilder;
import com.kms.api.util.ValidationUtil;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import java.util.Arrays;
import java.util.List;

public class AddProductSteps extends TestBase {

  private String path = "";
  private Object requestPayload;
  private LaptopBag reqAddLaptop;
  private static LaptopBag resAddLaptop;
  private int id;
  private Response res;

  public static LaptopBag getResAddLaptop() {
    return resAddLaptop;
  }

  @And("the payload of the request with BrandName as {}, Features as {}, LaptopName as {}")
  public void thePayloadOfTheRequestWithBrandNameAsFeaturesAsLaptopNameAs(
          String brandName, String feature, String laptopName) {
    String[] array = feature.split(",");
    List<String> lst = Arrays.asList(array);
    id = (int) (Math.random() * 10000);
    requestPayload = RequestBuilder.requestPayload(laptopName, brandName, id, lst);
  }

  @When("^I perform the POST request to add new product$")
  public void iPerformTheRequestToApplication() {
    this.path = CommonSteps.getPath();
    try {
      reqAddLaptop = (LaptopBag) requestPayload;
      res = RequestFactory.addProduct(this.path, reqAddLaptop);
      resAddLaptop = mapRestResponseToPojo(res, LaptopBag.class);
    }
    catch (Exception ex) {
      res = RequestFactory.addProduct(this.path, requestPayload);
    }

  }

  @Then("^the status code \"([^\"]*)\" should return$")
  public void theStatusCodeShouldReturn(String statusCode) {
    ValidationUtil.validateStatusCode(res, Integer.parseInt(statusCode));
  }

  @And("^the product is added successfully with an integer Id$")
  public void theProductIsAddedSuccessfullyWithAnIntegerId() {
    ValidationUtil.validateStringEqual(resAddLaptop.getId(), id);
  }

  @But("I supply invalid json payload")
  public void iSupplyInvalidJsonPayload() {
    requestPayload = "invalid json";
  }
}
