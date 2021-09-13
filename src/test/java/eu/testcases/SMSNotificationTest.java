package eu.testcases;

import eu.pages.PushNotificationPage;
import eu.pages.SMSNotificationPage;
import eu.zeewscript.SeleniumUtility.AbstractAcceptanceLoginBefore;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static eu.zeewscript.SeleniumUtility.PropertiesFile.getPropertyValue;

public class SMSNotificationTest extends AbstractAcceptanceLoginBefore {

    String expectedSMSNotificationURL= getPropertyValue("expectedSMSNotificationURL");

    @Test
    public void verifyOpeningPushNotificationPage() {

        SMSNotificationPage smsNotificationPage = new SMSNotificationPage(driver);
        smsNotificationPage.clickMenuItem();
        WebDriverWait wait = new WebDriverWait(driver, 5); // seconds
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("#customDomainError"), "Want to unlock this feature?"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedSMSNotificationURL);
    }
}
