package eu.testcases;

import eu.pages.PickupOrdersPage;
import eu.zeewscript.SeleniumUtility.AbstractAcceptanceLoginBefore;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static eu.zeewscript.SeleniumUtility.PropertiesFile.getPropertyValue;

public class PickupOrdersTest extends AbstractAcceptanceLoginBefore {

    String expectedPickupOrdersList = getPropertyValue("expectedPickupOrdersList");

    public void clickMenuItem() {
        PickupOrdersPage pickupOrdersPage = new PickupOrdersPage(driver);
        Actions actions = new Actions(driver);
        actions.moveToElement(pickupOrdersPage.getOrdersMainMenu());
        actions.perform();
        pickupOrdersPage.getOrdersMainMenu().click();
        actions.moveToElement(pickupOrdersPage.getPickupSubMenu());
        actions.perform();
        pickupOrdersPage.getPickupSubMenu().click();
    }


    //Verify that pickup order page opens and content is dispalyed correctly
    @Test(priority = 1)
    public void verifyOpeningPickupOrder() {
        clickMenuItem();
        WebDriverWait wait = new WebDriverWait(driver, 5); // seconds
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("section.content-header > h1:nth-child(1)"), "Pickup Orders"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedPickupOrdersList);
    }
}
