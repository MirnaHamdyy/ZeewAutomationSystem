package eu.testcases;

import eu.pages.PromotionsBannerPage;
import eu.pages.VoucherPage;
import eu.zeewscript.SeleniumUtility.AbstractAcceptanceLoginBefore;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import static eu.zeewscript.SeleniumUtility.PropertiesFile.getPropertyValue;

public class PromotionBannersTest extends AbstractAcceptanceLoginBefore {

    String expectedPromotionBannerURL = getPropertyValue("expectedPromotionBannerURL");

    @Test(priority = 1, groups= {"Opening Pages"})
    public void verifyOpeningPromotionBannerPage() {

        PromotionsBannerPage promotionsBannerPage = new PromotionsBannerPage(driver);
        promotionsBannerPage.clickMenuItem();
        WebDriverWait wait = new WebDriverWait(driver, 5); // seconds
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("section.content-header > h1:nth-child(1)"), "Promotions Banner Settings"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedPromotionBannerURL);
    }

    @Test
    public void createNewPromotion(){

    }

}
