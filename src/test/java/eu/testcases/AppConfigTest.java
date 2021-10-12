package eu.testcases;

import eu.pages.AppConfigPage;
import eu.zeewscript.SeleniumUtility.AbstractAcceptanceLoginBefore;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static eu.zeewscript.SeleniumUtility.PropertiesFile.getPropertyValue;

public class AppConfigTest extends AbstractAcceptanceLoginBefore {

    String expectedAppConfigURl = getPropertyValue("expectedAppConfigURL");

    public void clickMenuItem() throws InterruptedException {
        AppConfigPage appConfigPage = new AppConfigPage(driver);
        appConfigPage.getConfigMobileApps().click();
        Thread.sleep(3000);
        appConfigPage.getAppConfigSubMenu().click();
    }

    @Test(priority = 1)
    public void verifyOpeningOnboardingInformationPage() throws InterruptedException {
        clickMenuItem();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("section.content-header > h1:nth-child(1)"), "Onboarding"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedAppConfigURl);
    }

    @Test(priority = 2)
    public void verifyOpeningAppColorsPage() throws InterruptedException {
        AppConfigPage appConfigPage = new AppConfigPage(driver);
        clickMenuItem();
        appConfigPage.getAppColorsTab().click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(".clearfix:nth-child(5) > label.col-md-3.control-label"), "Splash Screen Background Colour"));
    }

}
