package eu.testcases;

import eu.pages.RewardsPage;
import eu.zeewscript.SeleniumUtility.AbstractAcceptanceLoginBefore;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static eu.zeewscript.SeleniumUtility.PropertiesFile.getPropertyValue;

public class RewardsTest extends AbstractAcceptanceLoginBefore {

    String expectedRewardPageURL=getPropertyValue("expectedRewardPageURL");

    @Test(priority = 1, groups= {"Opening Pages"})
    public void verifyOpeningٌRewardPage() {

        RewardsPage rewardsPage = new RewardsPage(driver);
        rewardsPage.clickMenuItem();
        WebDriverWait wait = new WebDriverWait(driver, 5); // seconds
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("section.content-header > h1:nth-child(1)"), "Reward Points"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedRewardPageURL);
    }
}
