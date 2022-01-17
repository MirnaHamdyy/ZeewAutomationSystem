package eu.testcases;

import eu.pages.CMSPage;
import eu.zeewscript.SeleniumUtility.AbstractAcceptanceLoginBefore;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static eu.zeewscript.SeleniumUtility.PropertiesFile.getPropertyValue;

public class CMSTest extends AbstractAcceptanceLoginBefore {

    String expectedStaticPageURL = getPropertyValue("expectedStaticPageURL");
    String expectedAddNewStaticPageURL = getPropertyValue("expectedAddNewStaticPageURL");

    public void clickMenuItem() {
        CMSPage cmsPage = new CMSPage(driver);
        Actions actions = new Actions(driver);
        actions.moveToElement(cmsPage.getBusinessSettingsMainMenu());
        actions.perform();
        cmsPage.getBusinessSettingsMainMenu().click();
        actions.moveToElement(cmsPage.getCmsSubMenu());
        actions.perform();
        cmsPage.getCmsSubMenu().click();
    }

    @Test(priority = 1)
    public void verifyOpeningStaticPage() {
        clickMenuItem();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("section.content-header > h1:nth-child(1)"), "Manage Staticpage"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedStaticPageURL);
    }

    @Test(priority = 2)
    public void verifyOpeningAddNewStaticPage() {
        CMSPage cmsPage = new CMSPage(driver);
        clickMenuItem();
        cmsPage.getAddNewStaticPageBtn().click();
        WebDriverWait wait=new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("label[for='content']"), "Content"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedAddNewStaticPageURL);
    }

}
