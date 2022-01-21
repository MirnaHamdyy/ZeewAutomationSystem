package eu.testcases;

import eu.pages.AutoAssignSettingsPage;
import eu.zeewscript.SeleniumUtility.AbstractAcceptanceLoginBefore;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static eu.zeewscript.SeleniumUtility.PropertiesFile.getPropertyValue;

public class AutoAssignSettingsTest extends AbstractAcceptanceLoginBefore {

    String expectedAutoAssignSettingsURL = getPropertyValue("expectedAutoAssignSettingsURL");

    public void clickMenuItem() {
        AutoAssignSettingsPage autoAssignSettingsPage = new AutoAssignSettingsPage(driver);
        Actions actions = new Actions(driver);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", autoAssignSettingsPage.getBusinessSettingsMainMenu());
        autoAssignSettingsPage.getBusinessSettingsMainMenu().click();
        actions.perform();
        actions.moveToElement(autoAssignSettingsPage.getAutoAssignSettingsSubMenu());
        jse.executeScript("arguments[0].scrollIntoView(true);", autoAssignSettingsPage.getAutoAssignSettingsSubMenu());
        autoAssignSettingsPage.getAutoAssignSettingsSubMenu().click();
        actions.perform();

    }

    @Test
    public void verifyOpeningAutoAssignSettingPage() throws InterruptedException {
        clickMenuItem();
        Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver, 5); // seconds
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("form[id='passwordForm'] div h3"), "Mark Drivers As Busy"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedAutoAssignSettingsURL);
    }

}
