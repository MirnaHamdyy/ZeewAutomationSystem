package eu.testcases;

import eu.pages.ReviewsPage;
import eu.pages.SiteSettingsPage;
import eu.zeewscript.SeleniumUtility.AbstractAcceptance;
import eu.zeewscript.SeleniumUtility.AbstractAcceptanceLoginBefore;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import static eu.zeewscript.SeleniumUtility.PropertiesFile.getPropertyValue;

public class SiteSettingsTest extends AbstractAcceptanceLoginBefore {

    //String expectedSiteSettingsPageURL = getPropertyValue("expectedSiteSettingsPageURL");

    @Test(priority = 1)
    public void verifyOpeningSiteSettingsPage() {

        SiteSettingsPage siteSettingsPage = new SiteSettingsPage(driver);
        siteSettingsPage.clickMenuItem();
//        WebDriverWait wait = new WebDriverWait(driver, 20); // seconds
//        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("section.content-header > h1:nth-child(1)"), "Site Fav Icon"));
//        Assert.assertEquals(driver.getCurrentUrl(), expectedSiteSettingsPageURL);

        String actualMobileLogoTextFieldString = driver.findElement(By.xpath("//*[@id=\"site\"]/div[3]/label")).getText();
        Assert.assertTrue(actualMobileLogoTextFieldString.contains("Mobile Logo"));
    }

    @Test(priority = 2)
    public void verifyOpeningContactTab() {

        SiteSettingsPage siteSettingsPage = new SiteSettingsPage(driver);
        siteSettingsPage.clickMenuItem();
        siteSettingsPage.getContactTab().click();
       // WebDriverWait wait = new WebDriverWait(driver, 20); // seconds
        //wait until the order email title appears
        //wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"contact\"]/div[6]/label"), "Ordr Email"));
        String actualOrderEmailTextFieldString = driver.findElement(By.xpath("//*[@id=\"contact\"]/div[6]/label")).getText();
        Assert.assertTrue(actualOrderEmailTextFieldString.contains("Order Email"));
    }

    @Test(priority = 3, groups= {"Opening Pages"})
    public void verifyLocationTab() {

        SiteSettingsPage siteSettingsPage = new SiteSettingsPage(driver);
        siteSettingsPage.clickMenuItem();
        siteSettingsPage.getLocationTab().click();
        String actualSiteCityTextFieldString = driver.findElement(By.xpath("//*[@id=\"location\"]/div[4]/label")).getText();
        Assert.assertTrue(actualSiteCityTextFieldString.contains("Site City"));
    }

    @Test(priority = 4, groups= {"Opening Pages"})
    public void verifyAnalyticsCodeTab() {

        SiteSettingsPage siteSettingsPage = new SiteSettingsPage(driver);
        siteSettingsPage.clickMenuItem();
        siteSettingsPage.getAnalyticCodeTab().click();
        String actualAnalyticsCodeTextFieldString = driver.findElement(By.xpath("//*[@id=\"siteForm\"]/div[2]/ul/li[4]/a")).getText();
        Assert.assertTrue(actualAnalyticsCodeTextFieldString.contains("Analytics Code"));
    }

    @Test(priority = 5, groups= {"Opening Pages"})
    public void verifyMailSettingTab() {

        SiteSettingsPage siteSettingsPage = new SiteSettingsPage(driver);
        siteSettingsPage.clickMenuItem();
        siteSettingsPage.getMailSettingTab().click();
        String actualMailSettingTextFieldString = driver.findElement(By.xpath("//*[@id=\"siteForm\"]/div[2]/ul/li[5]/a")).getText();
        Assert.assertTrue(actualMailSettingTextFieldString.contains("Mail Setting"));
    }

    @Test(priority = 5, groups= {"Opening Pages"})
    public void verifyInvoicesTab() {
        SiteSettingsPage siteSettingsPage = new SiteSettingsPage(driver);
        siteSettingsPage.clickMenuItem();
        siteSettingsPage.getInvoicesTab().click();
        String actualVATTextFieldString = driver.findElement(By.xpath("//*[@id=\"invoice\"]/div[2]/label")).getText();
        Assert.assertTrue(actualVATTextFieldString.contains("VAT (%)"));
    }

    @Test(priority = 6, groups= {"Opening Pages"})
    public void verifyOfflineTab() {

        SiteSettingsPage siteSettingsPage = new SiteSettingsPage(driver);
        siteSettingsPage.clickMenuItem();
        siteSettingsPage.getOfflineTab().click();
        String actualOfflineStatusTextFieldString = driver.findElement(By.xpath("//*[@id=\"offline\"]")).getText();
        Assert.assertTrue(actualOfflineStatusTextFieldString.contains("Offline Status"));
    }
    @Test(priority = 7, groups= {"Opening Pages"})
    public void verifyMetaTagsTab() {

        SiteSettingsPage siteSettingsPage = new SiteSettingsPage(driver);
        siteSettingsPage.clickMenuItem();
        siteSettingsPage.getMetaTagsTab().click();
        String actualMetaDescriptionTextFieldString = driver.findElement(By.xpath("//*[@id=\"MetaTags\"]/div[3]/label")).getText();
        Assert.assertTrue(actualMetaDescriptionTextFieldString.contains("Meta Descriptions"));
    }

    @Test(priority = 8, groups= {"Opening Pages"})
    public void verifyOrderAssignTab() {

        SiteSettingsPage siteSettingsPage = new SiteSettingsPage(driver);
        siteSettingsPage.clickMenuItem();
        siteSettingsPage.getOrderAssignTab().click();
        String actualAssignMilesTextFieldString = driver.findElement(By.xpath("//*[@id=\"assign_miles\"]/label")).getText();
        Assert.assertTrue(actualAssignMilesTextFieldString.contains("Assign Miles"));
    }

    @Test(priority = 9, groups= {"Opening Pages"})
    public void verifyLanguageTab() {

        SiteSettingsPage siteSettingsPage = new SiteSettingsPage(driver);
        siteSettingsPage.clickMenuItem();
        siteSettingsPage.getLanguageTab().click();
        String actualMultipleLanguageTextFieldString = driver.findElement(By.xpath("//*[@id=\"Language\"]/div/label")).getText();
        Assert.assertTrue(actualMultipleLanguageTextFieldString.contains("Multiple Language"));
    }

    @Test(priority = 10, groups= {"Opening Pages"})
    public void verifyBankInfoTab() {

        SiteSettingsPage siteSettingsPage = new SiteSettingsPage(driver);
        siteSettingsPage.clickMenuItem();
        siteSettingsPage.getBankInfoTab().click();
        String actualBankAddressTextFieldString = driver.findElement(By.xpath("//*[@id=\"tab_12\"]/div/div[4]/label")).getText();
        Assert.assertTrue(actualBankAddressTextFieldString.contains("Bank Address"));
    }

    @Test(priority = 11, groups= {"Opening Pages"})
    public void verifySocialMediaTab() {

        SiteSettingsPage siteSettingsPage = new SiteSettingsPage(driver);
        siteSettingsPage.clickMenuItem();
        siteSettingsPage.getSocialMediaTab().click();
        String actualGoogleLoginTextFieldString = driver.findElement(By.xpath("//*[@id=\"social_media\"]/div[2]/div[2]/div[3]/label")).getText();
        Assert.assertTrue(actualGoogleLoginTextFieldString.contains("Google Login"));
    }

    @Test(priority = 12)
    public void verifyAppStoreLinksTab() {

        SiteSettingsPage siteSettingsPage = new SiteSettingsPage(driver);
        siteSettingsPage.clickMenuItem();
        siteSettingsPage.getAppStoreLinksTab().click();
        String actualAppleStoreTextFieldString = driver.findElement(By.cssSelector("div[id='store_links'] div:nth-child(3) label:nth-child(1)")).getText();
        Assert.assertTrue(actualAppleStoreTextFieldString.contains("Apple Store"));
    }

    @Test(priority = 13, groups= {"Opening Pages"})
    public void verifyWebSettingsLinksTab() {

        SiteSettingsPage siteSettingsPage = new SiteSettingsPage(driver);
        siteSettingsPage.clickMenuItem();
        siteSettingsPage.getWebSettingsTab().click();
        String actualCustomCSSTextFieldString = driver.findElement(By.xpath("//*[@id=\"web_settings\"]/div[48]/label")).getText();
        Assert.assertTrue(actualCustomCSSTextFieldString.contains("Custom CSS"));
    }

}
