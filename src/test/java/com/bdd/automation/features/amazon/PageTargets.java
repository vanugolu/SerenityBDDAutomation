package com.bdd.automation.features.amazon;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PageTargets {
    public static Target shopByCategory = Target.the("Shop by Category").located(By.id("nav-link-shopall"));
    public static Target categoryFlyoutBlock = Target.the("Category Block").located(By.id("nav-flyout-shopAll"));
}
