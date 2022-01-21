package eu.testcases;

import eu.pages.ReportsPage;
import eu.zeewscript.SeleniumUtility.AbstractAcceptanceLoginBefore;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static eu.zeewscript.SeleniumUtility.PropertiesFile.getPropertyValue;

public class ReportsTest extends AbstractAcceptanceLoginBefore {

    String expectedReportsPageURL = getPropertyValue("expectedReportsPageURL");

    public void clickMenuItem() {
        ReportsPage reportsPage = new ReportsPage(driver);
        Actions actions = new Actions(driver);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", reportsPage.getReportingMainMenu());
        reportsPage.getReportingMainMenu().click();
        actions.perform();
        reportsPage.getReportsSubMenu().click();
        actions.perform();
    }

    @Test(priority = 1, groups = {"Opening Pages"})
    public void verifyOpeningReportsPage() {
        clickMenuItem();
        WebDriverWait wait = new WebDriverWait(driver, 5); // seconds
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("section.content-header > h1:nth-child(1)"), "Reports"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedReportsPageURL);
    }
}
