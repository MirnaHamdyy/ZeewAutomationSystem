package eu.testcases;

import eu.pages.ReportsPage;
import eu.zeewscript.SeleniumUtility.AbstractAcceptanceLoginBefore;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static eu.zeewscript.SeleniumUtility.PropertiesFile.getPropertyValue;

public class ReportsTest extends AbstractAcceptanceLoginBefore {

    String expectedReportsPageURL=getPropertyValue("expectedReportsPageURL");

    @Test(priority = 1, groups= {"Opening Pages"})
    public void verifyOpeningReportsPage() {

        ReportsPage reportsPage = new ReportsPage(driver);
        reportsPage.clickMenuItem();
        WebDriverWait wait = new WebDriverWait(driver, 5); // seconds
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("section.content-header > h1:nth-child(1)"), "Reports"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedReportsPageURL);
    }
}
