package com.kms.api.tests;

import com.kms.api.requests.RequestFactory;
import com.kms.api.util.ValidationUtil;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class GetAllProductsSteps extends TestBase{
    private String path = "";
    private Response res;
    @When("I perform the GET request")
    public void iPerformTheGETRequest() {
        this.path = CommonSteps.getPath();
        this.res = RequestFactory.getProduct(path);
    }

    @Then("^the status code \"([^\"]*)\" of the GET ALL request should be returned$")
    public void theStatusCodeOfTheGETALLRequestShouldBeReturned(String statusCode) {
        ValidationUtil.validateStatusCode(res, Integer.parseInt(statusCode));
    }
}
