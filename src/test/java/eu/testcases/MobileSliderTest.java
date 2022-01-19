package eu.testcases;

import eu.pages.MobileSliderPage;
import eu.zeewscript.SeleniumUtility.AbstractAcceptanceLoginBefore;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static eu.zeewscript.SeleniumUtility.PropertiesFile.getPropertyValue;

public class MobileSliderTest extends AbstractAcceptanceLoginBefore {

    String expectedMobileSliderListURL = getPropertyValue("expectedMobileSliderListURL");
    String expectedAddMobileSliderListURL = getPropertyValue("expectedAddMobileSliderListURL");

    public void clickMenuItem() {
        MobileSliderPage mobileSliderPage = new MobileSliderPage(driver);
        Actions actions = new Actions(driver);
        actions.moveToElement(mobileSliderPage.getPromotionsMainMenu());
        mobileSliderPage.getPromotionsMainMenu().click();
        actions.perform();
        mobileSliderPage.getMobileSlidersSubMenu().click();
        actions.perform();
    }

    @Test(priority = 1, groups = {"Opening Pages"})
    public void verifyOpeningMobileSliderPage() {
        clickMenuItem();
        WebDriverWait wait = new WebDriverWait(driver, 5); // seconds
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("section.content-header > h1:nth-child(1)"), "Mobile Slider"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedMobileSliderListURL);
    }

    @Test(priority = 2, groups = {"Opening Pages"})
    public void verifyOpeningAddMobileForm() {

        MobileSliderPage mobileSliderPage = new MobileSliderPage(driver);
        clickMenuItem();
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
