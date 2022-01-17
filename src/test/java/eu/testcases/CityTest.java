package eu.testcases;

import eu.pages.CityPage;
import eu.zeewscript.SeleniumUtility.AbstractAcceptanceLoginBefore;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static eu.zeewscript.SeleniumUtility.PropertiesFile.getPropertyValue;

public class CityTest extends AbstractAcceptanceLoginBefore {

    String expectedCityListPageURL = getPropertyValue("expectedCityListPageURL");
    String expectedAddNewCityURL = getPropertyValue("expectedAddNewCityURL");

    public void clickMenuItem() {
        CityPage cityPage = new CityPage(driver);
        Actions actions = new Actions(driver);
        actions.moveToElement(cityPage.getLocationMainMenu());
        actions.perform();
        cityPage.getLocationMainMenu().click();
        actions.moveToElement(cityPage.getCitySubMenu());
        actions.perform();
        cityPage.getCitySubMenu().click();
    }

    @Test(priority = 1)
    public void verifyOpeningCityList() {
        clickMenuItem();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("section.content-header > h1:nth-child(1)"), "Manage City"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedCityListPageURL);
    }

    @Test(priority = 2)
    public void verifyOpeningAddNewStateForm() {
        CityPage cityPage = new CityPage(driver);
        clickMenuItem();
        cityPage.getAddNewCityBtn().click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("label[for='city_name']"), "City Name"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedAddNewCityURL);
    }
}
