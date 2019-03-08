package com.bdd.automation.features.amazon.hover;

import com.bdd.automation.features.amazon.PageTargets;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.targets.Target;

public class HoverOn {
    private static Performable link(Target target) {
        return Task.where("{0} attempts to hover on the shop by category link",
                MoveMouse.to(target));
    }

    public static Performable categoryLink() {
        return link(PageTargets.shopByCategory);
    }

    public static Performable productLink() {
        return link(PageTargets.shopByCategory);
    }
}
