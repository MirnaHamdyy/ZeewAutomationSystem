package eu.testcases;

import eu.pages.InvoicesPage;
import eu.zeewscript.SeleniumUtility.AbstractAcceptanceLoginBefore;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static eu.zeewscript.SeleniumUtility.PropertiesFile.getPropertyValue;

public class InvoicesTest extends AbstractAcceptanceLoginBefore {

    String expectedInvoicesPageURL = getPropertyValue("expectedInvoicesPageURL");

    public void clickMenuItem() {
        InvoicesPage invoicesPage = new InvoicesPage(driver);
        Actions actions = new Actions(driver);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", invoicesPage.getReportingMainMenu());
        invoicesPage.getReportingMainMenu().click();
        actions.perform();
        invoicesPage.getInvoicesSubMenu().click();
        actions.perform();
    }

    @Test(priority = 1)
    public void verifyOpeningInvoicesPage() {
        clickMenuItem();
        WebDriverWait wait = new WebDriverWait(driver, 5); // seconds
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("section.content-header > h1:nth-child(1)"), "Manage Invoice"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedInvoicesPageURL);
    }

}
