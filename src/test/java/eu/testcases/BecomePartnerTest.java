package eu.testcases;

import eu.pages.BecomePartnerPage;
import eu.zeewscript.SeleniumUtility.AbstractAcceptanceLoginBefore;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static eu.zeewscript.SeleniumUtility.PropertiesFile.getPropertyValue;

public class BecomePartnerTest extends AbstractAcceptanceLoginBefore {

    String expectedBecomePartnerPage = getPropertyValue("expectedBecomePartnerPageURl");

    @Test(groups= {"Opening Pages"})
    public void verifyOpeningBecomePartnerPage(){
        BecomePartnerPage becomePartnerPage=new BecomePartnerPage(driver);
        becomePartnerPage.clickMenuItem();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("section[class='content-header'] h1"), "Become Partner"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedBecomePartnerPage);
    }


}
