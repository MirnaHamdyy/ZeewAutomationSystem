package eu.testcases;

import eu.pages.MobileSliderPage;
import eu.pages.PromotionsBannerPage;
import eu.zeewscript.SeleniumUtility.AbstractAcceptanceLoginBefore;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import static eu.zeewscript.SeleniumUtility.PropertiesFile.getPropertyValue;

public class MobileSliderTest extends AbstractAcceptanceLoginBefore {

    String expectedMobileSliderListURL=getPropertyValue("expectedMobileSliderListURL");
    String expectedAddMobileSliderListURL=getPropertyValue("expectedAddMobileSliderListURL");

    @Test(priority = 1, groups= {"Opening Pages"})
    public void verifyOpeningMobileSliderPage() {

        MobileSliderPage mobileSliderPage = new MobileSliderPage(driver);
        mobileSliderPage.clickMenuItem();
        WebDriverWait wait = new WebDriverWait(driver, 5); // seconds
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("section.content-header > h1:nth-child(1)"), "Mobile Slider"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedMobileSliderListURL);
    }

    @Test(priority = 2, groups= {"Opening Pages"})
    public void verifyOpeningAddMobileForm() {

      MobileSliderPage   mobileSliderPage = new MobileSliderPage(driver);
        mobileSliderPage.clickMenuItem();
        mobileSliderPage.getAddNewMobileSliderBtn().click();
        WebDriverWait wait = new WebDriverWait(driver, 5); // seconds
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("section.content-header > h1:nth-child(1)"), "Add Mobile Slider"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedAddMobileSliderListURL);
    }

//    @AfterClass
//    public void teardown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }



}
