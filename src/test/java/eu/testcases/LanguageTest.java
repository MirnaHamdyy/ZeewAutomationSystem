package eu.testcases;

import eu.pages.LanguagePage;
import eu.zeewscript.SeleniumUtility.AbstractAcceptanceLoginBefore;
import org.testng.Assert;
import org.testng.annotations.Test;

import static eu.zeewscript.SeleniumUtility.PropertiesFile.getPropertyValue;

public class LanguageTest extends AbstractAcceptanceLoginBefore {

    String expectedWebsitePageURL = getPropertyValue("expectedWebsitePageURL");
    String getExpectedMobilesitePageURL = getPropertyValue("expectedMobilesitePageURL");

    @Test(priority = 1, groups= {"Opening Pages"})
    public void verifyOpeningWebSiteLanguagePage() {

        LanguagePage languagePage = new LanguagePage(driver);
        languagePage.clickMenuItem();
        Assert.assertEquals(driver.getCurrentUrl(), expectedWebsitePageURL);
    }

    @Test(priority = 2, groups= {"Opening Pages"})
    public void verifyOpeningMobileAppsLanguagePage() {
        LanguagePage languagePage = new LanguagePage(driver);
        languagePage.clickMenuItem();
        languagePage.selectPlatformItem();
        Assert.assertEquals(driver.getCurrentUrl(), getExpectedMobilesitePageURL);
    }
}
