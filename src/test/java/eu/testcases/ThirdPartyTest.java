package eu.testcases;

import eu.pages.SiteSettingsPage;
import eu.pages.ThirdPartySettingsPage;
import eu.zeewscript.SeleniumUtility.AbstractAcceptanceLoginBefore;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class ThirdPartyTest extends AbstractAcceptanceLoginBefore {


    @Test(priority = 1, groups= {"Opening Pages"})
    public void verifyGoogleApiTab() {

        ThirdPartySettingsPage thirdPartySettingsPage = new ThirdPartySettingsPage(driver);
        thirdPartySettingsPage.clickMenuItem();
        thirdPartySettingsPage.getGoogleApiKeyTab().click();
        String actualGoogleKeyTextFieldString = driver.findElement(By.cssSelector(":nth-child(3) div.tab-pane.active:nth-child(1)")).getText();
        Assert.assertTrue(actualGoogleKeyTextFieldString.contains("Google key"));
    }

    @Test(priority = 2, groups= {"Opening Pages"})
    public void verifyFirebaseKeyTab() {

        ThirdPartySettingsPage thirdPartySettingsPage = new ThirdPartySettingsPage(driver);
        thirdPartySettingsPage.clickMenuItem();
        thirdPartySettingsPage.getFirebasekeyTab().click();
        String actualAddFCMKeyTextFieldString = driver.findElement(By.xpath("//*[@id=\"firebase\"]/div/label")).getText();
        Assert.assertTrue(actualAddFCMKeyTextFieldString.contains("Add FCM key which support both IOS and Android"));
    }

    @Test(priority = 3, groups= {"Opening Pages"})
    public void verifyPusherNotificationTab() {

        ThirdPartySettingsPage thirdPartySettingsPage = new ThirdPartySettingsPage(driver);
        thirdPartySettingsPage.clickMenuItem();
        thirdPartySettingsPage.getPusherNotificationTab().click();
        String actualAppIdTextFieldString = driver.findElement(By.xpath("//*[@id=\"pusher\"]/div[3]/label")).getText();
        Assert.assertTrue(actualAppIdTextFieldString.contains("App id"));
    }

    @Test(priority = 4, groups= {"Opening Pages"})
    public void verifyIntercomTab() {

        ThirdPartySettingsPage thirdPartySettingsPage = new ThirdPartySettingsPage(driver);
        thirdPartySettingsPage.clickMenuItem();
        thirdPartySettingsPage.getIntercomTab().click();
        String actualAppIdTextFieldString = driver.findElement(By.xpath("//*[@id=\"intercom\"]/div[3]/label")).getText();
        Assert.assertTrue(actualAppIdTextFieldString.contains("IOS Key"));
    }

    @Test(priority = 5, groups= {"Opening Pages"})
    public void verifyMessenteTab() {

        ThirdPartySettingsPage thirdPartySettingsPage = new ThirdPartySettingsPage(driver);
        thirdPartySettingsPage.clickMenuItem();
        thirdPartySettingsPage.getMessenteTab().click();
        String actualFromNameTextFieldString = driver.findElement(By.xpath("//*[@id=\"messente\"]/div[5]/label")).getText();
        Assert.assertTrue(actualFromNameTextFieldString.contains("From Name"));
    }

    @Test(priority = 5, groups= {"Opening Pages"})
    public void verifyDispatcherSettingsTab() {

        ThirdPartySettingsPage thirdPartySettingsPage = new ThirdPartySettingsPage(driver);
        thirdPartySettingsPage.clickMenuItem();
        thirdPartySettingsPage.getDispatcherSettingsTab().click();
        String actualDispatcherTextFieldString = driver.findElement(By.xpath("//*[@id=\"dispatcher-tab\"]/div[1]/label")).getText();
        Assert.assertTrue(actualDispatcherTextFieldString.contains("Dispatcher"));
    }

    @Test(priority = 6, groups= {"Opening Pages"})
    public void verifVoipSettingTab() {

        ThirdPartySettingsPage thirdPartySettingsPage = new ThirdPartySettingsPage(driver);
        thirdPartySettingsPage.clickMenuItem();
        thirdPartySettingsPage.getVoipSettingTab().click();
        String actualTwilioAppSIdTextFieldString = driver.findElement(By.xpath("//*[@id=\"voip-tab\"]/div[6]/label")).getText();
        Assert.assertTrue(actualTwilioAppSIdTextFieldString.contains("Twilio App SId"));
    }

//    @AfterClass
//    public void teardown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }

}
