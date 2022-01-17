package eu.testcases;

import eu.pages.VoucherPage;
import eu.zeewscript.SeleniumUtility.AbstractAcceptanceLoginBefore;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static eu.zeewscript.SeleniumUtility.PropertiesFile.getPropertyValue;

public class VoucherTest extends AbstractAcceptanceLoginBefore {

    String expectedVoucherListURL = getPropertyValue("expectedVoucherListURL");
    String expectedAddVoucherFormURL = getPropertyValue("expectedAddVoucherFormURL");

    public void clickMenuItem() {
        VoucherPage voucherPage = new VoucherPage(driver);
        Actions actions = new Actions(driver);
        actions.moveToElement(voucherPage.getPromotionsMainMenu());
        voucherPage.getPromotionsMainMenu().click();
        actions.perform();
        actions.moveToElement(voucherPage.getVoucherSubMenu());

        voucherPage.getVoucherSubMenu().click();
        actions.perform();
    }

    @Test(priority = 1)
    public void verifyOpeningVoucherlistPage() {
        clickMenuItem();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("section.content-header > h1:nth-child(1)"), "Manage Voucher"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedVoucherListURL);
    }

    @Test(priority = 2)
    public void verifyOpeningNewVoucherForm() {
        clickMenuItem();
        VoucherPage voucherPage = new VoucherPage(driver);
        voucherPage.getAddNewVoucherBtn().click();
        WebDriverWait wait = new WebDriverWait(driver, 3); // seconds
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("section.content-header > h1:nth-child(1)"), "Add Voucher"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedAddVoucherFormURL);
    }
}
