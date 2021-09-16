package eu.testcases;

import eu.pages.EmailNotificationPage;
import eu.zeewscript.SeleniumUtility.AbstractAcceptanceLoginBefore;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static eu.zeewscript.SeleniumUtility.PropertiesFile.getPropertyValue;

public class EmailNotificationTest extends AbstractAcceptanceLoginBefore {

    String expectedEmailNotificationURL = getPropertyValue("expectedEmailNotificationURL");

    @Test
    public void verifyOpeningEmailNotificationPage() {

        EmailNotificationPage emailNotificationPage = new EmailNotificationPage(driver);
        emailNotificationPage.clickMenuItem();
        WebDriverWait wait = new WebDriverWait(driver, 5); // seconds
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("#customDomainError"), "Want to unlock this feature?"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedEmailNotificationURL);
    }
}
