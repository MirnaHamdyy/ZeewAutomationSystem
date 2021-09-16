package eu.testcases;

import eu.pages.WebSliderPage;
import eu.zeewscript.SeleniumUtility.AbstractAcceptanceLoginBefore;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static eu.zeewscript.SeleniumUtility.PropertiesFile.getPropertyValue;

public class WebSliderTest extends AbstractAcceptanceLoginBefore {

    String expectedWebSliderListURL = getPropertyValue("expectedWebSliderListURL");
    String expectedAddWebSliderListURL = getPropertyValue("expectedAddWebSliderListURL");

    @Test(priority = 1, groups = {"Opening Pages"})
    public void verifyOpeningWebSliderPage() {

        WebSliderPage webSliderPage = new WebSliderPage(driver);
        webSliderPage.clickMenuItem();
        WebDriverWait wait = new WebDriverWait(driver, 3); // seconds
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("section.content-header > h1:nth-child(1)"), "Web Slider"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedWebSliderListURL);
    }

    @Test(priority = 2, groups = {"Opening Pages"})
    public void verifyOpeningAddWebSliderForm() {

        WebSliderPage webSliderPage = new WebSliderPage(driver);
        webSliderPage.clickMenuItem();
        webSliderPage.getAddNewWebSliderBtn().click();
        WebDriverWait wait = new WebDriverWait(driver, 3); // seconds
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("section.content-header > h1:nth-child(1)"), "Add Web Slider"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedAddWebSliderListURL);
    }
}
