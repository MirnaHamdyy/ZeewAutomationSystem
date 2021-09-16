package eu.testcases;

import eu.pages.ChangePasswordPage;
import eu.zeewscript.SeleniumUtility.AbstractAcceptanceLoginBefore;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static eu.zeewscript.SeleniumUtility.PropertiesFile.getPropertyValue;

public class ChangePasswordTest extends AbstractAcceptanceLoginBefore {

    String expectedChangePasswordURL = getPropertyValue("expectedChangePasswordURL");

    @Test(groups = {"Opening Pages"})
    public void verifyOpeningChangePasswordPage() {

        ChangePasswordPage changePasswordPage = new ChangePasswordPage(driver);
        changePasswordPage.clickMenuItem();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("div:nth-child(4) div:nth-child(1) label:nth-child(1)"), "Confirm Password"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedChangePasswordURL);
    }
}
