package eu.testcases;

import eu.pages.InvoicesPage;
import eu.pages.ReportsPage;
import eu.zeewscript.SeleniumUtility.AbstractAcceptanceLoginBefore;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import static eu.zeewscript.SeleniumUtility.PropertiesFile.getPropertyValue;

public class InvoicesTest extends AbstractAcceptanceLoginBefore {

    String expectedInvoicesPageURL=getPropertyValue("expectedInvoicesPageURL");

    @Test(priority = 1)
    public void verifyOpeningInvoicesPage() {

        InvoicesPage invoicesPage = new InvoicesPage(driver);
        invoicesPage.clickMenuItem();
        WebDriverWait wait = new WebDriverWait(driver, 5); // seconds
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("section.content-header > h1:nth-child(1)"), "Manage Invoice"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedInvoicesPageURL);
    }

}
