package eu.testcases;

import eu.pages.PushNotificationPage;
import eu.zeewscript.SeleniumUtility.AbstractAcceptanceLoginBefore;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static eu.zeewscript.SeleniumUtility.PropertiesFile.getPropertyValue;

public class PushNotifictionTest extends AbstractAcceptanceLoginBefore {

    String expectedPushNotificationURL = getPropertyValue("expectedPushNotificationURL");

    public void clickMenuItem() {
        PushNotificationPage pushNotificationPage = new PushNotificationPage(driver);
        Actions actions = new Actions(driver);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", pushNotificationPage.getBusinessSettingsMainMenu());
        pushNotificationPage.getBusinessSettingsMainMenu().click();
        actions.perform();
        pushNotificationPage.getPushNotificationSubMenu().click();
        actions.perform();
    }

    @Test
    public void verifyOpeningPushNotificationPage() {
        clickMenuItem();
        WebDriverWait wait = new WebDriverWait(driver, 5); // seconds
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("div.content-wrapper:nth-child(6) section.content-header > h1:nth-child(1)"), "Push Notification settings"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedPushNotificationURL);
    }
}
