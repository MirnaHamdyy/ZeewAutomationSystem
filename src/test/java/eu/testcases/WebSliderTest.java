package eu.testcases;

import eu.pages.WebSliderPage;
import eu.zeewscript.SeleniumUtility.AbstractAcceptanceLoginBefore;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static eu.zeewscript.SeleniumUtility.PropertiesFile.getPropertyValue;

public class WebSliderTest extends AbstractAcceptanceLoginBefore {

    String expectedWebSliderListURL = getPropertyValue("expectedWebSliderListURL");
    String expectedAddWebSliderListURL = getPropertyValue("expectedAddWebSliderListURL");

    public void clickMenuItem() {
        WebSliderPage webSliderPage = new WebSliderPage(driver);
        Actions actions = new Actions(driver);
        actions.moveToElement(webSliderPage.getPromotionsMainMenu());
        webSliderPage.getPromotionsMainMenu().click();
        actions.perform();
        webSliderPage.getWebSliderSubMenu().click();
        actions.perform();
    }

    @Test(priority = 1, groups = {"Opening Pages"})
    public void verifyOpeningWebSliderPage() {
        clickMenuItem();
        WebDriverWait wait = new WebDriverWait(driver, 3); // seconds
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("section.content-header > h1:nth-child(1)"), "Web Slider"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedWebSliderListURL);
    }

    @Test(priority = 2, groups = {"Opening Pages"})
    public void verifyOpeningAddWebSliderForm() {

        WebSliderPage webSliderPage = new WebSliderPage(driver);
        clickMenuItem();
        webSliderPage.getAddNewWebSliderBtn().click();
        WebDriverWait wait = new WebDriverWait(driver, 3); // seconds
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("section.content-header > h1:nth-child(1)"), "Add Web Slider"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedAddWebSliderListURL);
    }
}
