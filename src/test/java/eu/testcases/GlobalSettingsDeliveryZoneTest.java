package eu.testcases;

import eu.pages.GlobalSettingsDeliveryZonePage;
import eu.zeewscript.SeleniumUtility.AbstractAcceptanceLoginBefore;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static eu.zeewscript.SeleniumUtility.PropertiesFile.getPropertyValue;

public class GlobalSettingsDeliveryZoneTest extends AbstractAcceptanceLoginBefore {

    String expectedDeliveryZoneURL = getPropertyValue("expectedDeliveryZoneURL");

    public void clickMenuItem() {
        GlobalSettingsDeliveryZonePage globalSettingsDeliveryZonePage = new GlobalSettingsDeliveryZonePage(driver);
        Actions actions = new Actions(driver);
        actions.moveToElement(globalSettingsDeliveryZonePage.getGlobalSettingsMenu());
        globalSettingsDeliveryZonePage.getGlobalSettingsMenu().click();
        actions.perform();
        actions.moveToElement(globalSettingsDeliveryZonePage.getDeliveryZonesSubMenu());
        globalSettingsDeliveryZonePage.getDeliveryZonesSubMenu().click();
        actions.perform();
    }

    @Test(groups = {"Opening Pages"})
    public void verifyOpeningGlobalDeliveryZonePage() {
        clickMenuItem();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("section.content-header > h1:nth-child(1)"), "Global Delivery Zones"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedDeliveryZoneURL);
    }

}
