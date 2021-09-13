package eu.testcases;

import eu.pages.MarketPlacePage;
import eu.zeewscript.SeleniumUtility.AbstractAcceptanceLoginBefore;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import static eu.zeewscript.SeleniumUtility.PropertiesFile.getPropertyValue;

public class MarketPlaceTest extends AbstractAcceptanceLoginBefore {

    String expectedMarketPlaceURL = getPropertyValue("expectedMarketPlaceURL");

    @Test(groups= {"Opening Pages"})
    public void verifyOpeningMarketPlacePage() {
        MarketPlacePage marketPlacePage = new MarketPlacePage(driver);
        marketPlacePage.clickMenuItem();
        WebDriverWait wait=new WebDriverWait(driver,3);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("section.content-header > h1:nth-child(1)"), "Market Place"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedMarketPlaceURL);

    }

}
