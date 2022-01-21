package eu.testcases;

import eu.pages.SubadminPage;
import eu.zeewscript.SeleniumUtility.AbstractAcceptanceLoginBefore;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static eu.zeewscript.SeleniumUtility.PropertiesFile.getPropertyValue;

public class SubAdminTest extends AbstractAcceptanceLoginBefore {

    String expectedSubAdminPageURL = getPropertyValue("expectedSubadminPageURL");
    String expectedAddSubAdminPageURL = getPropertyValue("expectecdAddSubAdminsFormURL");

    public void clickMenuItem() {
        SubadminPage subadminPage = new SubadminPage(driver);
        Actions actions = new Actions(driver);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", subadminPage.getBusinessSettingsMainMenu());
        subadminPage.getBusinessSettingsMainMenu().click();
        actions.perform();
        jse.executeScript("arguments[0].scrollIntoView(true);", subadminPage.getSubAdminSubMenu());
        subadminPage.getSubAdminSubMenu().click();
        actions.perform();
    }

    @Test(priority = 1, groups = {"Opening Pages"})
    public void verifyOpeningSubAdminPage() {
        clickMenuItem();
        WebDriverWait wait = new WebDriverWait(driver, 10); // seconds
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("section[class='content-header'] h1"), "Subadmin"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedSubAdminPageURL);
    }

    @Test(priority = 2, groups = {"Opening Pages"})
    public void verifyOpeningAddSubAdminPage() {
        SubadminPage subadminPage = new SubadminPage(driver);
        clickMenuItem();
        subadminPage.getAddNewSubAdminBtn().click();
        WebDriverWait wait = new WebDriverWait(driver, 3); // seconds
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("div.content-wrapper:nth-child(6) section.content-header > h1:nth-child(1)"), "Add SubAdmins"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedAddSubAdminPageURL);
    }
}