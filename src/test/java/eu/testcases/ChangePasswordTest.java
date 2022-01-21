package eu.testcases;

import eu.pages.ChangePasswordPage;
import eu.zeewscript.SeleniumUtility.AbstractAcceptanceLoginBefore;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static eu.zeewscript.SeleniumUtility.PropertiesFile.getPropertyValue;

public class ChangePasswordTest extends AbstractAcceptanceLoginBefore {

    String expectedChangePasswordURL = getPropertyValue("expectedChangePasswordURL");

    public void clickMenuItem() {
        ChangePasswordPage changePasswordPage = new ChangePasswordPage(driver);
        Actions actions = new Actions(driver);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", changePasswordPage.getBusinessSettingsMainMenu());
        changePasswordPage.getBusinessSettingsMainMenu().click();
        actions.perform();
        changePasswordPage.getChangePasswordSubMenu().click();
        actions.perform();
    }

    @Test()
    public void verifyOpeningChangePasswordPage() {
        clickMenuItem();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("div:nth-child(4) div:nth-child(1) label:nth-child(1)"), "Confirm Password"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedChangePasswordURL);
    }
}
