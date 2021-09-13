package eu.testcases;

import eu.pages.PickupOrdersPage;
import eu.zeewscript.SeleniumUtility.AbstractAcceptanceLoginBefore;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import static eu.zeewscript.SeleniumUtility.PropertiesFile.getPropertyValue;

public class PickupOrdersTest extends AbstractAcceptanceLoginBefore {

    String expectedPickupOrdersList = getPropertyValue("expectedPickupOrdersList");

    //Verify that pickup order page opens and content is dispalyed correctly
    @Test(groups= {"Opening Pages"})
    public void verifyOpeningPickupOrder() {

        PickupOrdersPage pickupOrdersPage = new PickupOrdersPage(driver);
        pickupOrdersPage.clickMenuItem();
        WebDriverWait wait = new WebDriverWait(driver, 5); // seconds
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("section.content-header > h1:nth-child(1)"), "Pickup Orders"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedPickupOrdersList);
    }
}
