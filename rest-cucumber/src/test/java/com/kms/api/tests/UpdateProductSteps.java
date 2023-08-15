package com.kms.api.tests;

import com.kms.api.model.LaptopBag;
import com.kms.api.requests.RequestFactory;
import com.kms.api.util.RequestBuilder;
import com.kms.api.util.ValidationUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.util.Arrays;
import java.util.List;

import static com.kms.api.util.RestUtil.mapRestResponseToPojo;

public class UpdateProductSteps extends TestBase{
    private String path = "";
    private String brand;
    private String name;
    List<String> listFeature;
    LaptopBag resPayload;
    private Response res;
    private static LaptopBag resUpdateLaptop;
    @When("I perform the PUT request with id and BrandName as {}, Features as {}, LaptopName as {}")
    public void iPerformThePUTRequestWithIdAndBrandNameAsFeaturesAsLaptopNameAs(String brand, String features, String name) {
        this.path = CommonSteps.getPath();
        this.brand = brand;
        this.name = name;
        String[] feature = features.split(", ");
        List<String> list = Arrays.asList(feature);
        this.listFeature = list;
        resPayload = RequestBuilder.requestPayload(name, brand, AddProductSteps.getResAddLaptop().getId(), list);
        res = RequestFactory.updateProduct(path, resPayload);
        resUpdateLaptop = mapRestResponseToPojo(res, LaptopBag.class);
    }

    @Then("Status code \"([^\"]*)\" should be returned$")
    public void statusCodeShouldBeReturned(String statusCode) {
        ValidationUtil.validateStatusCode(res, Integer.parseInt(statusCode));
    }

    @And("Details should get updated")
    public void detailsShouldGetUpdated() {
        ValidationUtil.validateStringEqual(resUpdateLaptop.getBrandName(), this.brand);
        ValidationUtil.validateStringEqual(resUpdateLaptop.getLaptopName(), this.name);
        ValidationUtil.validateStringEqual(resUpdateLaptop.getFeatures().getFeature(), this.listFeature);
    }

}
