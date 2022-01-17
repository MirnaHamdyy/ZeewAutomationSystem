package eu.testcases;

import eu.pages.GlobalSettingsOperatingCitiesPage;
import eu.zeewscript.SeleniumUtility.AbstractAcceptanceLoginBefore;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static eu.zeewscript.SeleniumUtility.PropertiesFile.getPropertyValue;

public class GlobalSettingsOperatingCitiesTest extends AbstractAcceptanceLoginBefore {

    String expectedGlobalSettingsURL = getPropertyValue("expectedGlobalSettingsURL");

    public void clickMenuItem() {
        GlobalSettingsOperatingCitiesPage globalSettingsOperatingCitiesPage = new GlobalSettingsOperatingCitiesPage(driver);
        Actions actions = new Actions(driver);
        actions.moveToElement(globalSettingsOperatingCitiesPage.getGlobalSettingsMenu());
        globalSettingsOperatingCitiesPage.getGlobalSettingsMenu().click();
        actions.perform();
        actions.moveToElement(globalSettingsOperatingCitiesPage.getOperatingCitieSubMenus());
        globalSettingsOperatingCitiesPage.getOperatingCitieSubMenus().click();
        actions.perform();
    }

    @Test(groups = {"Opening Pages"})
    public void verifyOpeningGlobalSettingsPage() {
        clickMenuItem();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("section.content-header > h1:nth-child(1)"), "Global ON/OFF Settings"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedGlobalSettingsURL);
    }
}
