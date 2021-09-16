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

    @Test(priority = 1,groups= {"Opening Pages"})
    public void verifyOpeningOnboardingInformationPage() {
        AppConfigPage appConfigPage = new AppConfigPage(driver);
        appConfigPage.clickMenuItem();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("section.content-header > h1:nth-child(1)"), "Onboarding"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedAppConfigURl);
    }

    @Test(priority = 2, groups= {"Opening Pages"})
    public void verifyOpeningAppColorsPage() {
        AppConfigPage appConfigPage = new AppConfigPage(driver);
        appConfigPage.clickMenuItem();
        appConfigPage.getAppConfigTab().click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(".clearfix:nth-child(5) > label.col-md-3.control-label"), "Splash Screen Background Colour"));
    }

}
