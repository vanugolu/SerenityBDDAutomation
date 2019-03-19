package com.bdd.automation.features.jsonplaceholder.steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Post;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.equalTo;

public class JsonPlaceHolderSteps {

    Actor actor;

    @Before
    public void setStage() {
        OnStage.setTheStage(new OnlineCast());
        actor = Actor.named("Sreenivas").whoCan(CallAnApi.at("https://jsonplaceholder.typicode.com"));
    }

    @Given("post data")
    public void post_data() {
        try {
            Path path = Paths.get(getClass().getClassLoader()
                    .getResource("jsondata/postData.json").toURI());

            actor.attemptsTo(
                    Post.to("/users")
                        .with(request -> request.header("Content-Type", "application/json")
                                                .body(path.toFile())
                        )
            );
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @When("success code is 201")
    public void successCode() {
        actor.should(
                seeThatResponse("The user should have been successfully added",
                        response -> response.statusCode(201))
        );

    }

    @Then("assert for name")
    public void id_is_created() {
        actor.should(
                seeThatResponse(response -> response
                        .body("name", equalTo("Sreenivas")))
        );

    }

}
