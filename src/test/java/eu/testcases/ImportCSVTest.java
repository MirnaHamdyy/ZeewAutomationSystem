package eu.testcases;

import eu.pages.ImportCSVPage;
import eu.zeewscript.SeleniumUtility.AbstractAcceptanceLoginBefore;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static eu.zeewscript.SeleniumUtility.PropertiesFile.getPropertyValue;

public class ImportCSVTest extends AbstractAcceptanceLoginBefore {

    String expectedImportCVPageURL = getPropertyValue("expectedImportCSVPage");

    @Test(groups = {"Opening Pages"})
    public void verifyOpeningImportCSVPage() {

        ImportCSVPage importCSVPage = new ImportCSVPage(driver);
        importCSVPage.clickMenuItem();
        WebDriverWait wait = new WebDriverWait(driver, 5); // seconds
        if (wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("section:nth-child(4) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > h3:nth-child(1)"), "Store Menu Upload"))) {
            Assert.assertEquals(driver.getCurrentUrl(), expectedImportCVPageURL);
        } else if
        (wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("section[class='content-header'] h1"), "Market Place"))) {
            Assert.assertEquals(driver.getCurrentUrl(), expectedImportCVPageURL);
        }
    }
}
