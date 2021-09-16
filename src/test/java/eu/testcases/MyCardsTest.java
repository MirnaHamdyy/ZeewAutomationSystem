package eu.testcases;

import eu.pages.MyCardPage;
import eu.zeewscript.SeleniumUtility.AbstractAcceptanceLoginBefore;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static eu.zeewscript.SeleniumUtility.PropertiesFile.getPropertyValue;

public class MyCardsTest extends AbstractAcceptanceLoginBefore {

    String expectedMyCardsURL=getPropertyValue("expectedMyCardsURL");

    @Test(groups= {"Opening Pages"})
    public void verifyOpeningMyCardsPage() {

        MyCardPage myCardPage = new MyCardPage(driver);
        myCardPage.clickMenuItem();
        WebDriverWait wait = new WebDriverWait(driver, 5); // seconds
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("section.content-header > h1:nth-child(1)"), "Manage Cards"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedMyCardsURL);
    }
}
