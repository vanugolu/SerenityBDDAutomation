package com.bdd.automation.features.amazon.steps;

import com.bdd.automation.features.amazon.assertion.VisibleBlocks;
import com.bdd.automation.features.amazon.hover.HoverOn;
import com.bdd.automation.features.amazon.navigate.NavigateTo;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class AmazonHomePageScenario {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("{string} Open Amazon Home Page")
    public void open_Amazon_Home_Page(String actor) {
        theActorCalled(actor).attemptsTo(NavigateTo.openAmazonHomePage());
    }

    @When("Hover on Category Link")
    public void hover_on_Category_Link() {
        OnStage.theActorInTheSpotlight().attemptsTo(HoverOn.categoryLink());
    }

    @Then("It should contain {string}")
    public void it_should_contain(String listElement) {
        OnStage.theActorInTheSpotlight().should(VisibleBlocks.seeAllCategories());
    }
}
