package eu.testcases;

import eu.pages.CityPage;
import eu.zeewscript.SeleniumUtility.AbstractAcceptanceLoginBefore;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static eu.zeewscript.SeleniumUtility.PropertiesFile.getPropertyValue;

public class CityTest extends AbstractAcceptanceLoginBefore {

    String expectedCityListPageURL= getPropertyValue("expectedCityListPageURL");
    String expectedAddNewCityURL= getPropertyValue("expectedAddNewCityURL");


    @Test(priority = 1,groups= {"Opening Pages"})
    public void verifyOpeningCityList(){
        CityPage cityPage=new CityPage(driver);
        cityPage.clickMenuItem();
        WebDriverWait wait=new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("section.content-header > h1:nth-child(1)"), "Manage City"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedCityListPageURL);
    }

    @Test(priority = 2, groups= {"Opening Pages"})
    public void verifyOpeningAddNewStateForm(){
        CityPage cityPage=new CityPage(driver);
        cityPage.clickMenuItem();
        cityPage.getAddNewCityBtn().click();
        WebDriverWait wait=new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("label[for='city_name']"), "City Name"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedAddNewCityURL);
    }
}
