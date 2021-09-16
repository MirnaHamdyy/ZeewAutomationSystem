package eu.testcases;

import eu.pages.DriversAnalyticsPage;
import eu.zeewscript.SeleniumUtility.AbstractAcceptanceLoginBefore;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static eu.zeewscript.SeleniumUtility.PropertiesFile.getPropertyValue;

public class DriversAnalyticsTest extends AbstractAcceptanceLoginBefore {

    String expectedDriversPageURL  = getPropertyValue("expectedDriversPageURL");

    @Test
    public void verifyOpeningAnalyticsOrdersPage() {

        DriversAnalyticsPage driversAnalyticsPage = new DriversAnalyticsPage(driver);
        driversAnalyticsPage.clickMenuItem();
        WebDriverWait wait = new WebDriverWait(driver, 5); // seconds
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("div:nth-child(10) div:nth-child(1) div:nth-child(1) h3:nth-child(1)"), "Total Earnings"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedDriversPageURL);
    }
}
