package eu.testcases;

import eu.pages.ReferralPage;
import eu.zeewscript.SeleniumUtility.AbstractAcceptanceLoginBefore;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static eu.zeewscript.SeleniumUtility.PropertiesFile.getPropertyValue;

public class ReferralTest extends AbstractAcceptanceLoginBefore {

    String expectedReferralPageURL = getPropertyValue("expectedReferralPageURL");

    public void clickMenuItem() {
        ReferralPage referralPage = new ReferralPage(driver);
        Actions actions = new Actions(driver);
        actions.moveToElement(referralPage.getReferralSubMenu());
        referralPage.getPromotionMainMenu().click();
        actions.perform();
        referralPage.getReferralSubMenu().click();
        actions.perform();

    }

    @Test(priority = 1, groups = {"Opening Pages"})
    public void verifyOpeningReferralPage() {
        clickMenuItem();
        WebDriverWait wait = new WebDriverWait(driver, 5); // seconds
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("section.content-header > h1:nth-child(1)"), "Referral Points"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedReferralPageURL);
    }
}
