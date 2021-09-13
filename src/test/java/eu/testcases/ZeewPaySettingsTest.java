package eu.testcases;

import eu.pages.ZeewPaySettingsPage;
import eu.zeewscript.SeleniumUtility.AbstractAcceptanceLoginBefore;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static eu.zeewscript.SeleniumUtility.PropertiesFile.getPropertyValue;

public class ZeewPaySettingsTest extends AbstractAcceptanceLoginBefore {

    String expectedZeewPayPageURL = getPropertyValue("expectedZeewPayPageURl");

    @Test(priority = 1, groups= {"Opening Pages"})
    public void verifyOpeningBusinessInformationPage() {
        ZeewPaySettingsPage zeewPaySettingsPage = new ZeewPaySettingsPage(driver);
        zeewPaySettingsPage.clickMenuItem();
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("label[for='businessinfo-acnorabn']"), "Business ACN or ABN"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedZeewPayPageURL);
    }

    @Test(priority = 2, groups= {"Opening Pages"})
    public void verifyOpeningBankInformationTab() {
        ZeewPaySettingsPage zeewPaySettingsPage = new ZeewPaySettingsPage(driver);
        zeewPaySettingsPage.clickMenuItem();
        zeewPaySettingsPage.getBankInformationTab().click();
        String actualRefundReserveTextFieldString = driver.findElement(By.cssSelector("label[for='bankinginfo-refundreserve']")).getText();
        Assert.assertTrue(actualRefundReserveTextFieldString.contains("Refund reserve"));
    }

    @Test(priority = 3, groups= {"Opening Pages"})
    public void verifyOpeningOwnershipInfoTab() {
        ZeewPaySettingsPage zeewPaySettingsPage = new ZeewPaySettingsPage(driver);
        zeewPaySettingsPage.clickMenuItem();
        zeewPaySettingsPage.getOwnershipInfoTab().click();
        String actualRefundReserveTextFieldString = driver.findElement(By.cssSelector("label[for='ownershipinfoarr-0-zip']")).getText();
        Assert.assertTrue(actualRefundReserveTextFieldString.contains("Business owner zip"));
    }

    @Test(priority = 4, groups= {"Opening Pages"})
    public void verifyOpeningCompanyRepresentativeTab() {
        ZeewPaySettingsPage zeewPaySettingsPage = new ZeewPaySettingsPage(driver);
        zeewPaySettingsPage.clickMenuItem();
        zeewPaySettingsPage.getCompanyRepresentativeInformationTab().click();
        String actualCompanyRepresentativeZipTextFieldString = driver.findElement(By.cssSelector("label[for='companyrep-companyrepzip']")).getText();
        Assert.assertTrue(actualCompanyRepresentativeZipTextFieldString.contains("Company representative zip"));
    }

    @Test(priority = 5,groups= {"Opening Pages"})
    public void verifyOpeningAdditionalInformationTab() {
        ZeewPaySettingsPage zeewPaySettingsPage = new ZeewPaySettingsPage(driver);
        zeewPaySettingsPage.clickMenuItem();
        zeewPaySettingsPage.getAdditionalInformationTab().click();
        String actualCompanyRepresentativeZipTextFieldString = driver.findElement(By.cssSelector("label[for='merchantagreementssign-pricingagreementdate']")).getText();
        Assert.assertTrue(actualCompanyRepresentativeZipTextFieldString.contains("Pricing agreement sign date"));
    }

}
