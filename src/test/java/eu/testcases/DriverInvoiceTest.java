package eu.testcases;

import eu.pages.DriverInvoicePage;
import eu.zeewscript.SeleniumUtility.AbstractAcceptanceLoginBefore;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static eu.zeewscript.SeleniumUtility.PropertiesFile.getPropertyValue;

public class DriverInvoiceTest extends AbstractAcceptanceLoginBefore {

    String expectedDriverInvoiceURL = getPropertyValue("expectedDriverInvoicePageURL");

    public void clickMenuItem() {
        DriverInvoicePage driverInvoicePage = new DriverInvoicePage(driver);
        Actions actions = new Actions(driver);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", driverInvoicePage.getReportingMainMenu());
        //    actions.moveToElement(driverInvoicePage.getReportingMainMenu());
        driverInvoicePage.getReportingMainMenu().click();
        actions.perform();
        driverInvoicePage.getDriverInvoicesSubMenu().click();
        actions.perform();
    }

    @Test
    public void verifyOpeningDriverInvoicePage() {
        clickMenuItem();
        WebDriverWait wait = new WebDriverWait(driver, 5); // seconds
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("section.content-header > h1:nth-child(1)"), "Manage Driver"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedDriverInvoiceURL);
    }


}
