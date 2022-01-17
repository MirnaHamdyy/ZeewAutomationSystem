package eu.testcases;

import eu.pages.SurChargeSettingsPage;
import eu.zeewscript.SeleniumUtility.AbstractAcceptanceLoginBefore;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static eu.zeewscript.SeleniumUtility.PropertiesFile.getPropertyValue;

public class SurChargeTest extends AbstractAcceptanceLoginBefore {

    String expectedSurChargeSettingsURL = getPropertyValue("expectedSurChargeSettingsURL");

    public void clickMenuItem() {
        SurChargeSettingsPage surChargeSettingsPage = new SurChargeSettingsPage(driver);
        Actions actions = new Actions(driver);
        actions.moveToElement(surChargeSettingsPage.getSurChargeSettingsMainMenu());
        actions.perform();
        surChargeSettingsPage.getSurChargeSettingsMainMenu().click();
        actions.perform();
    }

    @Test(groups = {"Opening Pages"})
    public void verifyOpeningSurChargeSettingsPage() {
        clickMenuItem();
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("section.content-header > h1:nth-child(1)"), "Surcharge Settings"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedSurChargeSettingsURL);
    }

}
