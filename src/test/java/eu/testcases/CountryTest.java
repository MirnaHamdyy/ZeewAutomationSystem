package eu.testcases;

import eu.pages.CountryPage;
import eu.zeewscript.SeleniumUtility.AbstractAcceptanceLoginBefore;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static eu.zeewscript.SeleniumUtility.PropertiesFile.getPropertyValue;

public class CountryTest extends AbstractAcceptanceLoginBefore {

    String expectedCountryListPageURL = getPropertyValue("expectedCountryListPageURL");
    String expectedAddNewCountryURL = getPropertyValue("expectedAddNewCountryURL");

    public void clickMenuItem() {
        CountryPage countryPage = new CountryPage(driver);
        Actions actions = new Actions(driver);
        actions.moveToElement(countryPage.getLocationMainMenu());
        actions.perform();
        countryPage.getLocationMainMenu().click();
        actions.moveToElement(countryPage.getCountrySubMenu());
        actions.perform();
        countryPage.getCountrySubMenu().click();
    }

    @Test(priority = 1, groups = {"Opening Pages"})
    public void verifyOpeningCountryList() {
        clickMenuItem();
        Assert.assertEquals(driver.getCurrentUrl(), expectedCountryListPageURL);
    }

    @Test(priority = 2, groups = {"Opening Pages"})
    public void verifyOpeningAddNewCountryForm() {
        CountryPage countryPage = new CountryPage(driver);
        clickMenuItem();
        countryPage.getAddNewCountryBtn().click();
        Assert.assertEquals(driver.getCurrentUrl(), expectedAddNewCountryURL);
    }
}
