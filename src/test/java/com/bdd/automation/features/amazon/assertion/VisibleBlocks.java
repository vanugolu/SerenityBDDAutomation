package com.bdd.automation.features.amazon.assertion;

import com.bdd.automation.features.amazon.PageTargets;
import net.serenitybdd.screenplay.Consequence;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.questions.CurrentVisibility;

public class VisibleBlocks {
    public static Consequence<Boolean> seeAllCategories() {
        return GivenWhenThen.seeThat("All Categories",
                        CurrentVisibility.of(PageTargets.categoryFlyoutBlock)
                                            .viewedBy(OnStage.theActorInTheSpotlight())
                                            .asAQuestion());
    }
}
