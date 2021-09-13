package eu.testcases;

import eu.pages.StatePage;
import eu.pages.ZipcodePage;
import eu.zeewscript.SeleniumUtility.AbstractAcceptanceLoginBefore;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static eu.zeewscript.SeleniumUtility.PropertiesFile.getPropertyValue;

public class ZipcodeTest extends AbstractAcceptanceLoginBefore {

    String expectedZipcodeListPageURL= getPropertyValue("expectedZipcodeListPageURL");
    String expectedAddNewZipcodeURL= getPropertyValue("expectedAddNewZipcodeURL");

    @Test(priority = 1, groups= {"Opening Pages"})
    public void verifyOpeningZipcodeList(){
        ZipcodePage zipcodePage=new ZipcodePage(driver);
        zipcodePage.clickMenuItem();
        WebDriverWait wait = new WebDriverWait(driver, 3); // seconds
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("section[class='content-header'] h1"), "Manage Location"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedZipcodeListPageURL);
    }

    @Test(priority = 2, groups= {"Opening Pages"})
    public void verifyOpeningAddNewZipcodeForm(){
        ZipcodePage zipcodePage=new ZipcodePage(driver);
        zipcodePage.getAddNewZipcodeBtn().click();
        WebDriverWait wait = new WebDriverWait(driver, 5); // seconds
       wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("label[for='zip_code']"), "Zipcode"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedAddNewZipcodeURL);
    }

//    @AfterTest
//    public void teardown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
}



