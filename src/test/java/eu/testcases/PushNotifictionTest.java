package eu.testcases;

import eu.pages.EmailNotificationPage;
import eu.pages.PushNotificationPage;
import eu.zeewscript.SeleniumUtility.AbstractAcceptanceLoginBefore;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static eu.zeewscript.SeleniumUtility.PropertiesFile.getPropertyValue;

public class PushNotifictionTest extends AbstractAcceptanceLoginBefore {

    String expectedPushNotificationURL= getPropertyValue("expectedPushNotificationURL");

    @Test
    public void verifyOpeningPushNotificationPage() {

        PushNotificationPage pushNotificationPage = new PushNotificationPage(driver);
        pushNotificationPage.clickMenuItem();
        WebDriverWait wait = new WebDriverWait(driver, 5); // seconds
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("#customDomainError"), "Want to unlock this feature?"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedPushNotificationURL);
    }
}
