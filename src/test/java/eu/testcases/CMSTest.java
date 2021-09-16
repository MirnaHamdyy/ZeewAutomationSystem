package eu.testcases;

import eu.pages.CMSPage;
import eu.zeewscript.SeleniumUtility.AbstractAcceptanceLoginBefore;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static eu.zeewscript.SeleniumUtility.PropertiesFile.getPropertyValue;

public class CMSTest extends AbstractAcceptanceLoginBefore {

    String expectedStaticPageURL=getPropertyValue("expectedStaticPageURL");
    String expectedAddNewStaticPageURL=getPropertyValue("expectedAddNewStaticPageURL");

    @Test(priority = 1,groups= {"Opening Pages"})
    public void verifyOpeningStaticPage(){
        CMSPage cmsPage= new CMSPage(driver);
        cmsPage.clickMenuItem();
        WebDriverWait wait=new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("section.content-header > h1:nth-child(1)"), "Manage Staticpage"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedStaticPageURL);
    }

    @Test(priority = 2, groups= {"Opening Pages"})
    public void verifyOpeningAddNewStaticPage(){
        CMSPage cmsPage= new CMSPage(driver);
        cmsPage.clickMenuItem();
        cmsPage.getAddNewStaticPageBtn().click();
        WebDriverWait wait=new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("label[for='content']"), "Content"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedAddNewStaticPageURL);
    }

}
