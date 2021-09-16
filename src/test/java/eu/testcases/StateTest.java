package eu.testcases;

import eu.pages.StatePage;
import eu.zeewscript.SeleniumUtility.AbstractAcceptanceLoginBefore;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static eu.zeewscript.SeleniumUtility.PropertiesFile.getPropertyValue;

public class StateTest extends AbstractAcceptanceLoginBefore {

    String expectedStateListPageURL= getPropertyValue("expectedStateListPageURL");
    String expectedAddNewStateURL= getPropertyValue("expectedAddNewStateURL");


    @Test(priority = 1, groups= {"Opening Pages"})
    public void verifyOpeningStateList(){
        StatePage statePage=new StatePage(driver);
        statePage.clickMenuItem();
        WebDriverWait wait = new WebDriverWait(driver, 10); // seconds

        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("section[class='content-header'] h1"), "Manage State"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedStateListPageURL);
    }

    @Test(priority = 2, groups= {"Opening Pages"})
    public void verifyOpeningAddNewStateForm(){
        StatePage statePage=new StatePage(driver);
        statePage.clickMenuItem();
        statePage.getAddNewStateBtn().click();
        WebDriverWait wait = new WebDriverWait(driver, 3); // seconds
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("label[for='state_name']"), "State Name"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedAddNewStateURL);
    }
}
