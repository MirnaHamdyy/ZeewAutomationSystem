package eu.testcases;

import eu.pages.StoresAnalyticsPage;
import eu.zeewscript.SeleniumUtility.AbstractAcceptanceLoginBefore;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static eu.zeewscript.SeleniumUtility.PropertiesFile.getPropertyValue;

public class StoresAnalyticsTest extends AbstractAcceptanceLoginBefore {

    String expectedStoresURL = getPropertyValue("expectedStoresPageURL");

    public void clickMenuItem() {
        StoresAnalyticsPage storesAnalyticsPage = new StoresAnalyticsPage(driver);
        Actions actions = new Actions(driver);
        actions.moveToElement(storesAnalyticsPage.getAnalyticsMainMenu());
        storesAnalyticsPage.getAnalyticsMainMenu().click();
        actions.perform();
        storesAnalyticsPage.getStoreAnalyticsSubMenu().click();
        actions.perform();
    }

    //Verify that pickup order page opens and content is dispalyed correctly
    @Test
    public void verifyOpeningAnalyticsStoresPage() {
        clickMenuItem();
        WebDriverWait wait = new WebDriverWait(driver, 5); // seconds
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("div:nth-child(10) div:nth-child(1) div:nth-child(1) h3:nth-child(1)"), "Average Ratings"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedStoresURL);
    }
}
