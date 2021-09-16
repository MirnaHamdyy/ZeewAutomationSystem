package eu.testcases;

import eu.pages.CustomDomainPage;
import eu.zeewscript.SeleniumUtility.AbstractAcceptanceLoginBefore;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static eu.zeewscript.SeleniumUtility.PropertiesFile.getPropertyValue;

public class CustomDomainTest extends AbstractAcceptanceLoginBefore {

    String expectedCustomDomainURL=getPropertyValue("expectedCustomDomainURL");

    @Test(groups= {"Opening Pages"})
    public void verifyOpeningSiteSettingsPage(){
        CustomDomainPage customDomainPage=new CustomDomainPage(driver);
        customDomainPage.clickMenuItem();
        WebDriverWait wait=new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("section.content-header > h1:nth-child(1)"), "Site Settings"));
        Assert.assertEquals(driver.getCurrentUrl(),expectedCustomDomainURL );
    }
}
