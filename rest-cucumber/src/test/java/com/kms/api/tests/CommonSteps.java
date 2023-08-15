package com.kms.api.tests;

import io.cucumber.java.en.Given;

public class CommonSteps extends TestBase{
    private static String path = "";

    public static String getPath() {
        return path;
    }
    @Given("^the path \"([^\"]*)\" to the endpoint$")
    public void thePathToAddTheProduct(String path) {
        this.path = path;
    }
}
