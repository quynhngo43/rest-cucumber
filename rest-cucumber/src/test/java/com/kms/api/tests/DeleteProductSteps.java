package com.kms.api.tests;

import com.kms.api.requests.RequestFactory;
import com.kms.api.util.ValidationUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class DeleteProductSteps extends TestBase{
    private int id;
    private String path = "";
    Response res;
    private final String GET_PRODUCT_PATH = "find" + '/'+id;

    @Then("Status code \"([^\"]*)\" of the delete request should be returned$")
    public void statusCodeOfTheDeleteRequestShouldBeReturned(String statusCode) {
        ValidationUtil.validateStatusCode(res, Integer.parseInt(statusCode));
    }

    @When("I perform the DELETE request with id")
    public void iPerformTheDELETERequestWithId() {
        this.id = AddProductSteps.getResAddLaptop().getId();
        this.path = CommonSteps.getPath() +'/'+id;
        res = RequestFactory.deleteProduct(path);
    }

    @And("^the product id should not exist with status code \"([^\"]*)\"$")
    public void theProductIdShouldNotExistWithStatusCode(String statusCode) {
        Response getProductRes = RequestFactory.getProduct(GET_PRODUCT_PATH);
        ValidationUtil.validateStatusCode(getProductRes, Integer.parseInt(statusCode));
    }
}
