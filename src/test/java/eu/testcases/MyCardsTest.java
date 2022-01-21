package eu.testcases;

import eu.pages.MyCardPage;
import eu.zeewscript.SeleniumUtility.AbstractAcceptanceLoginBefore;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static eu.zeewscript.SeleniumUtility.PropertiesFile.getPropertyValue;

public class MyCardsTest extends AbstractAcceptanceLoginBefore {

    String expectedMyCardsURL = getPropertyValue("expectedMyCardsURL");

    public void clickMenuItem() {
        MyCardPage cardPage = new MyCardPage(driver);
        Actions actions = new Actions(driver);
        actions.moveToElement(cardPage.getBillingMainMenu());
        cardPage.getBillingMainMenu().click();
        actions.perform();
      //  actions.moveToElement(cardPage.getMyCardsSubMenuItem());
        cardPage.getMyCardsSubMenuItem().click();
        actions.perform();
    }

    @Test(groups = {"Opening Pages"})
    public void verifyOpeningMyCardsPage() {

        clickMenuItem();
        WebDriverWait wait = new WebDriverWait(driver, 5); // seconds
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("section.content-header > h1:nth-child(1)"), "Manage Cards"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedMyCardsURL);
    }
}
