package eu.testcases;

import eu.pages.EmailNotificationPage;
import eu.zeewscript.SeleniumUtility.AbstractAcceptanceLoginBefore;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static eu.zeewscript.SeleniumUtility.PropertiesFile.getPropertyValue;

public class EmailNotificationTest extends AbstractAcceptanceLoginBefore {

    String expectedEmailNotificationURL = getPropertyValue("expectedEmailNotificationURL");

    public void clickMenuItem() {
        EmailNotificationPage emailNotificationPage = new EmailNotificationPage(driver);
        Actions actions = new Actions(driver);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", emailNotificationPage.getBusinessSettingsMainMenu());
        emailNotificationPage.getBusinessSettingsMainMenu().click();
        actions.perform();
        emailNotificationPage.getEmailNotificationSubMenu().click();
        actions.perform();
    }

    @Test
    public void verifyOpeningEmailNotificationPage() {
        clickMenuItem();
        WebDriverWait wait = new WebDriverWait(driver, 5); // seconds
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("div.content-wrapper:nth-child(6) section.content-header > h1:nth-child(1)"), "Email settings"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedEmailNotificationURL);
    }
}
