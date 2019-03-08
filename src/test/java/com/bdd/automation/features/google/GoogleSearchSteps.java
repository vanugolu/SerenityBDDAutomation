package com.bdd.automation.features.google;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.AggregateQuestions;
import net.serenitybdd.screenplay.questions.targets.TheTarget;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.List;

public class GoogleSearchSteps {

    @Before
    public void beforeScenario() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("{string} Open Google Search Page")
    public void open_Google_Search_Page(String actor) {
        OnStage.theActorCalled(actor).attemptsTo(Open.browserOn().thePageNamed("googleSearchPage"));
    }

    @When("Search the keyword {string}")
    public void search_the_keyword(String keyword) {
        OnStage.theActorInTheSpotlight().attemptsTo(getTask(keyword));
    }

    private Performable getTask(String keyword) {
        return Task.where("Search String",
                Enter.theValue(keyword).into(getTarget()),
                Hit.the(Keys.ENTER).into(getTarget()));
    }

    private Target getTarget() {
        return Target.the("text box").located(By.name("q"));
    }

    @Then("It should give  recommendations")
    public void it_should_give_recommendations() {
        List<String> textValues = TheTarget.textValuesOf(getResultId()).answeredBy(OnStage.theActorInTheSpotlight());
        boolean test = textValues.stream().allMatch(text -> text.contains("cucumber"));
        System.out.println("TEST " + test);

        WaitUntil.the(getResultId(), WebElementStateMatchers.isVisible()).performAs(OnStage.theActorInTheSpotlight());
        OnStage.theActorInTheSpotlight().should(eventuallySee());
    }

    private Consequence eventuallySee() {
        return EventualConsequence.eventually(getConsequence());
    }

    private Consequence getConsequence() {
        System.out.println(TheTarget.textValuesOf(getResultId()).answeredBy(OnStage.theActorInTheSpotlight()));
        return GivenWhenThen.seeThat("See search results", AggregateQuestions.theTotalNumberOf(TheTarget.textValuesOf(getResultId())),
                Matchers.greaterThan(0));
    }

    private Target getResultId() {
        return Target.the("Result Container").located(By.id("ires"));
    }
}
