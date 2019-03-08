package com.bdd.automation.features.steps;

import com.bdd.automation.features.model.response.CountryResponse;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;

public class CountrySearchSteps {

    private String ISO_CODE_SEARCH = "http://services.groupkt.com/country/get/iso2code/";
    private Response response;
    private CountryResponse countryData;

    @Given("search for country code {string}")
    public void search_for_country_code(String code) {
        response = SerenityRest.when().get(ISO_CODE_SEARCH + code);
        System.out.println(response.getBody().print());
        countryData = response.as(CountryResponse.class);
    }

    @When("success is {int}")
    public void success_is(int statusCode) {
       response.then().statusCode(200);
    }

    @Then("check if name is {string}")
    public void check_if_name_is(String name) {
        response.then().body("RestResponse.result.name", Matchers.is(name));
        //Assert.assertEquals(name, countryData.getResult().getName());
    }
}
