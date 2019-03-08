package com.bdd.automation.features.amazon.navigate;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateTo {

    public static Performable openAmazonHomePage() {
        return Open.browserOn().the(AmazonHomePage.class);
    }
}
