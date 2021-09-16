package eu.testcases;

import eu.pages.UploadImagesPage;
import eu.zeewscript.SeleniumUtility.AbstractAcceptanceLoginBefore;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static eu.zeewscript.SeleniumUtility.PropertiesFile.getPropertyValue;

public class UploadImagesTest extends AbstractAcceptanceLoginBefore {

    String expectedUploadImagePageURL = getPropertyValue("expectedUploadImagesPageURL");

    @Test(groups= {"Opening Pages"})
    public void verifyOpeningUploadImagesPage() {
        UploadImagesPage uploadImagesPage = new UploadImagesPage(driver);
        uploadImagesPage.clickMenuItem();
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("section[class='content-header'] h1"), "Upload Images For CSV"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedUploadImagePageURL);
    }
}
