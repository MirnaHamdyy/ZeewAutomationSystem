package eu.testcases;

import eu.pages.HaveIssuesPage;
import eu.zeewscript.SeleniumUtility.AbstractAcceptanceLoginBefore;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import static eu.zeewscript.SeleniumUtility.PropertiesFile.getPropertyValue;

public class HaveIssuesTest extends AbstractAcceptanceLoginBefore {

    String expectedHaveIssuesList = getPropertyValue("expectedHaveIssuesList");

    @Test(groups= {"Opening Pages"})
    public void verifyOpeningHavingIssuesPage() {
        HaveIssuesPage haveIssuesPage = new HaveIssuesPage(driver);
        haveIssuesPage.clickMenuItem();
        WebDriverWait wait=new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("section.content-header > h1:nth-child(1)"), "Reported Issues"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedHaveIssuesList);
    }
}
