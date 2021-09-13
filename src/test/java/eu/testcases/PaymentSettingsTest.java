package eu.testcases;

import eu.pages.PaymentSettingsPage;
import eu.zeewscript.SeleniumUtility.AbstractAcceptanceLoginBefore;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import static eu.zeewscript.SeleniumUtility.PropertiesFile.getPropertyValue;

public class PaymentSettingsTest extends AbstractAcceptanceLoginBefore {

    String expectedPaymentSettingsURL=getPropertyValue("expectedPaymentSettingsPageURL");
    String expectedAddPaymentMethodFormURL=getPropertyValue("expectedAddPaymentMethodFormURL");


    @Test(priority = 1, groups= {"Opening Pages"})
    public void verifyPaymentSettingsPage() {
        PaymentSettingsPage paymentSettingsPage = new PaymentSettingsPage(driver);
        paymentSettingsPage.clickMenuItem();
        WebDriverWait wait=new WebDriverWait(driver,3);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("tbody:nth-child(2) tr.card.even:nth-child(4) > td:nth-child(2)"), "Stripe"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedPaymentSettingsURL);
    }

    @Test(priority = 2, groups= {"Opening Pages"})
    public void verifyAddPage() {
        PaymentSettingsPage paymentSettingsPage = new PaymentSettingsPage(driver);
        paymentSettingsPage.clickMenuItem();
        paymentSettingsPage.getAddPaymentMethodBtn().click();
        WebDriverWait wait=new WebDriverWait(driver,3);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("div.stripeDiv div:nth-child(1) div.form-group.clearfix:nth-child(2) > label.col-md-3.control-label"), "ZeewPay Test Password"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedAddPaymentMethodFormURL);
    }
//    @AfterClass
//    public void teardown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }


}
