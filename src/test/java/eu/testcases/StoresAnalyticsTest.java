package eu.testcases;

import eu.pages.OrdersAnalyticsPage;
import eu.pages.StoresAnalyticsPage;
import eu.zeewscript.SeleniumUtility.AbstractAcceptanceLoginBefore;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static eu.zeewscript.SeleniumUtility.PropertiesFile.getPropertyValue;

public class StoresAnalyticsTest extends AbstractAcceptanceLoginBefore {

    String expectedStoresURL = getPropertyValue("expectedStoresPageURL");

    //Verify that pickup order page opens and content is dispalyed correctly
    @Test
    public void verifyOpeningAnalyticsStoresPage() {

        StoresAnalyticsPage storesAnalyticsPage = new StoresAnalyticsPage(driver);
        storesAnalyticsPage.clickMenuItem();
        WebDriverWait wait = new WebDriverWait(driver, 5); // seconds
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("div:nth-child(10) div:nth-child(1) div:nth-child(1) h3:nth-child(1)"), "Average Ratings"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedStoresURL);
    }



}
