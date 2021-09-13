package eu.testcases;

import eu.pages.PickupOrdersPage;
import eu.pages.UsersAnalyticsPage;
import eu.zeewscript.SeleniumUtility.AbstractAcceptanceLoginBefore;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static eu.zeewscript.SeleniumUtility.PropertiesFile.getPropertyValue;

public class UsersAnalyticsTest extends AbstractAcceptanceLoginBefore {

    String expectedUsersPageURL = getPropertyValue("expectedUsersPageURL");

    //Verify that pickup order page opens and content is dispalyed correctly
    @Test
    public void verifyOpeningAnalyticsUsersPage() {

        UsersAnalyticsPage usersAnalyticsPage = new UsersAnalyticsPage(driver);
        usersAnalyticsPage.clickMenuItem();
        WebDriverWait wait = new WebDriverWait(driver, 5); // seconds
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("div:nth-child(9) div:nth-child(1) div:nth-child(1) h3:nth-child(1)"), "First Orders"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedUsersPageURL);
    }
}
