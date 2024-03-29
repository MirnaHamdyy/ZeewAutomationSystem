package eu.testcases;

import eu.pages.MyPlanPage;
import eu.zeewscript.SeleniumUtility.AbstractAcceptanceLoginBefore;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static eu.zeewscript.SeleniumUtility.PropertiesFile.getPropertyValue;

public class MyPlanTest extends AbstractAcceptanceLoginBefore {

    String expectedMyPlanURL = getPropertyValue("expectedMyPlanURL");

    public void clickMenuItem() {
        MyPlanPage myPlanPage = new MyPlanPage(driver);
        Actions actions = new Actions(driver);
        actions.moveToElement(myPlanPage.getBillingMainMenu());
        myPlanPage.getBillingMainMenu().click();
        actions.perform();
        myPlanPage.getMyPlanSubMenu().click();
        actions.perform();
    }

    @Test(groups = {"Opening Pages"})
    public void verifyOpeningMyPlanPage() {
        clickMenuItem();
        WebDriverWait wait = new WebDriverWait(driver, 5); // seconds
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("section.content-header > h1:nth-child(1)"), "My Market Place"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedMyPlanURL);
    }
}
