package eu.testcases;

import eu.pages.PaymentSettingsPage;
import eu.zeewscript.SeleniumUtility.AbstractAcceptanceLoginBefore;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static eu.zeewscript.SeleniumUtility.PropertiesFile.getPropertyValue;

public class PaymentSettingsTest extends AbstractAcceptanceLoginBefore {

    String expectedPaymentSettingsURL = getPropertyValue("expectedPaymentSettingsPageURL");
    String expectedAddPaymentMethodFormURL = getPropertyValue("expectedAddPaymentMethodFormURL");

    public void clickMenuItem() {
        PaymentSettingsPage paymentSettingsPage = new PaymentSettingsPage(driver);
        Actions actions = new Actions(driver);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", paymentSettingsPage.getBusinessSettingsMainMenu());
        paymentSettingsPage.getBusinessSettingsMainMenu().click();
        actions.perform();
        paymentSettingsPage.getPaymentSettingsSubMenu().click();
        actions.perform();
    }

    @Test(priority = 1, groups = {"Opening Pages"})

    public void verifyOpeningPaymentSettingsPage() {
        clickMenuItem();
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//td[contains(text(),'Stripe')]"), "Stripe"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedPaymentSettingsURL);
    }

    @Test(priority = 2, groups = {"Opening Pages"})
    public void verifyOpeningAddPage() {
        PaymentSettingsPage paymentSettingsPage = new PaymentSettingsPage(driver);
        clickMenuItem();
        paymentSettingsPage.getAddPaymentMethodBtn().click();
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("div.stripeDiv div:nth-child(1) div.form-group.clearfix:nth-child(2) > label.col-md-3.control-label"), "ZeewPay Test Password"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedAddPaymentMethodFormURL);
    }
}
