package eu.testcases;

import eu.pages.HaveIssuesPage;
import eu.zeewscript.SeleniumUtility.AbstractAcceptanceLoginBefore;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static eu.zeewscript.SeleniumUtility.PropertiesFile.getPropertyValue;

public class HaveIssuesTest extends AbstractAcceptanceLoginBefore {

    String expectedHaveIssuesList = getPropertyValue("expectedHaveIssuesList");

    public void clickMenuItem() {
        HaveIssuesPage haveIssuesPage = new HaveIssuesPage(driver);
        Actions actions = new Actions(driver);
        actions.moveToElement(haveIssuesPage.getOrdersMainMenu());
        actions.perform();
        haveIssuesPage.getOrdersMainMenu().click();
        actions.moveToElement(haveIssuesPage.getHaveIssuesSubMenu());
        actions.perform();
        haveIssuesPage.getHaveIssuesSubMenu().click();
    }

    @Test(priority = 1)
    public void verifyOpeningHavingIssuesPage() {
        clickMenuItem();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("section.content-header > h1:nth-child(1)"), "Reported Issues"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedHaveIssuesList);
    }
}
