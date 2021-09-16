package eu.testcases;

import eu.pages.SubadminPage;
import eu.zeewscript.SeleniumUtility.AbstractAcceptanceLoginBefore;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static eu.zeewscript.SeleniumUtility.PropertiesFile.getPropertyValue;

public class SubAdminTest extends AbstractAcceptanceLoginBefore {

    String expectedSubAdminPageURL = getPropertyValue("expectedSubadminPageURL");
    String expectedAddSubAdminPageURL = getPropertyValue("expectecdAddSubAdminsFormURL");

    @Test(priority = 1, groups = {"Opening Pages"})
    public void verifyOpeningSubAdminPage() {
        SubadminPage subadminPage = new SubadminPage(driver);
        subadminPage.clickMenuItem();
        WebDriverWait wait = new WebDriverWait(driver, 10); // seconds
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("section[class='content-header'] h1"), "Subadmin"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedSubAdminPageURL);
    }

    @Test(priority = 2, groups = {"Opening Pages"})
    public void verifyOpeningAddSubAdminPage() {
        SubadminPage subadminPage = new SubadminPage(driver);
        subadminPage.clickMenuItem();
        subadminPage.getAddNewSubAdminBtn().click();
        WebDriverWait wait = new WebDriverWait(driver, 3); // seconds
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("div:nth-child(6) > div:nth-child(1) > label:nth-child(1)"), "Address"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedAddSubAdminPageURL);
    }
}