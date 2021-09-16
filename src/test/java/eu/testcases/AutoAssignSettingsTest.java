package eu.testcases;

import eu.pages.AutoAssignSettingsPage;
import eu.zeewscript.SeleniumUtility.AbstractAcceptanceLoginBefore;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static eu.zeewscript.SeleniumUtility.PropertiesFile.getPropertyValue;

public class AutoAssignSettingsTest extends AbstractAcceptanceLoginBefore {

    String expectedAutoAssignSettingsURL = getPropertyValue("expectedAutoAssignSettingsURL");


    @Test
    public void verifyOpeningAutoAssignSettingPage() {
        AutoAssignSettingsPage autoAssignSettingsPage = new AutoAssignSettingsPage(driver);
        autoAssignSettingsPage.clickMenuItem();
        WebDriverWait wait = new WebDriverWait(driver, 5); // seconds
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("form[id='passwordForm'] div h3"), "Mark Drivers As Busy"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedAutoAssignSettingsURL);
    }

}
