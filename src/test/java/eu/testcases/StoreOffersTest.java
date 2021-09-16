package eu.testcases;

import eu.pages.StoreOffersPage;
import eu.zeewscript.SeleniumUtility.AbstractAcceptanceLoginBefore;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static eu.zeewscript.SeleniumUtility.PropertiesFile.getPropertyValue;

public class StoreOffersTest extends AbstractAcceptanceLoginBefore {

    String expectedStoreOffersURL = getPropertyValue("expectedStoreOffersURL");
    String expectedAddNewOfferURl = getPropertyValue("expectedAddNewOfferURl");

    public void selectTodayDate() {

        StoreOffersPage storeOffersPage = new StoreOffersPage(driver);
        DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        Date today = calendar.getInstance().getTime();

        //String nexrtDate=dateFormat.format(futureDate);
        String todayAsString = dateFormat.format(today);
        //  String date = dateFormat.formattodayAsString(today);
        storeOffersPage.setFromDatePicker(todayAsString);
        storeOffersPage.getFromDatePicker().sendKeys(Keys.ENTER);
        System.out.println("Today Date: " + todayAsString);

        calendar.add(Calendar.DAY_OF_YEAR, 3);
        Date tomorrow = calendar.getTime();
        String tomorrowAsString = dateFormat.format(tomorrow);

        storeOffersPage.getToDataPicker().sendKeys(Keys.ARROW_RIGHT);
        storeOffersPage.getToDataPicker().sendKeys(Keys.ARROW_RIGHT);
        storeOffersPage.getToDataPicker().sendKeys(Keys.ARROW_RIGHT);
        storeOffersPage.getToDataPicker().sendKeys(Keys.ENTER);

        System.out.println("Tomorrow Date: " + tomorrowAsString);
    }


    @Test(priority = 1, groups = {"Opening Pages"})
    public void verifyOpeningStoreOffersPage() {

        StoreOffersPage storeOffersPage = new StoreOffersPage(driver);
        storeOffersPage.clickMenuItem();
        WebDriverWait wait = new WebDriverWait(driver, 3); // seconds
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("section.content-header > h1:nth-child(1)"), "Manage Offer"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedStoreOffersURL);
    }

    @Test
    public void verifySelectingDate() {
        StoreOffersPage storeOffersPage = new StoreOffersPage(driver);
        storeOffersPage.clickMenuItem();
        storeOffersPage.getAddNewOfferBtn().click();
        //Use  SimpleDateFormat to format the date as a String
        selectTodayDate();
    }


    @Test(priority = 2, groups = {"Opening Pages"})
    public void verifyOpeningNewOfferForm() {
        StoreOffersPage storeOffersPage = new StoreOffersPage(driver);
        storeOffersPage.clickMenuItem();
        storeOffersPage.getAddNewOfferBtn().click();
        WebDriverWait wait = new WebDriverWait(driver, 20); // seconds
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("section.content-header > h1:nth-child(1)"), "Add Offer"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedAddNewOfferURl);
    }
}
