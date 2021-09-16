package eu.testcases;

import eu.pages.GlobalSettingsPage;
import eu.zeewscript.SeleniumUtility.AbstractAcceptanceLoginBefore;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static eu.zeewscript.SeleniumUtility.PropertiesFile.getPropertyValue;

public class GlobalSettingsTest extends AbstractAcceptanceLoginBefore {

    String expectedGlobalSettingsURL = getPropertyValue("expectedGlobalSettingsURL");

    @Test(groups = {"Opening Pages"})
    public void verifyOpeningGlobalSettingsPage() {
        GlobalSettingsPage globalSettingsPage = new GlobalSettingsPage(driver);
        globalSettingsPage.clickMenuItem();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("section.content-header > h1:nth-child(1)"), "Global ON/OFF Settings"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedGlobalSettingsURL);
    }
}
