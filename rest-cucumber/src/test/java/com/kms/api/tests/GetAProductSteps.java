package com.kms.api.tests;

import com.kms.api.requests.RequestFactory;
import com.kms.api.util.ValidationUtil;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class GetAProductSteps extends TestBase {
    private String path="";
    private Response res;

    @When("^I perform the GET request with id as \"([^\"]*)\"$")
    public void iPerformTheGETRequestWithIdAs(String id) {
        this.path = CommonSteps.getPath() + '/' + id;
        res = RequestFactory.getProduct(path);

    }

    @Then("^Status code \"([^\"]*)\" of the get request should be returned$")
    public void statusCodeOfTheGetRequestShouldBeReturned(String statusCode) {
        ValidationUtil.validateStatusCode(res, Integer.parseInt(statusCode));
    }
}
