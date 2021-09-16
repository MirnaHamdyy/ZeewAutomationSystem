package eu.testcases;

import eu.pages.SurChargeSettingsPage;
import eu.zeewscript.SeleniumUtility.AbstractAcceptanceLoginBefore;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static eu.zeewscript.SeleniumUtility.PropertiesFile.getPropertyValue;

public class SurChargeTest extends AbstractAcceptanceLoginBefore {

    String expectedSurChargeSettingsURL= getPropertyValue("expectedSurChargeSettingsURL");

    @Test(groups= {"Opening Pages"})
    public void verifyOpeningSurChargeSettingsPage(){
        SurChargeSettingsPage surChargeSettingsPage=new SurChargeSettingsPage(driver);
        surChargeSettingsPage.clickMenuItem();
        WebDriverWait wait=new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("section.content-header > h1:nth-child(1)"), "Surcharge Settings"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedSurChargeSettingsURL);
    }

}
