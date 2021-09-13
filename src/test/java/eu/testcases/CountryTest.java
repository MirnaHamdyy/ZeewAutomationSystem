package eu.testcases;

import eu.pages.CountryPage;
import eu.zeewscript.SeleniumUtility.AbstractAcceptanceLoginBefore;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import static eu.zeewscript.SeleniumUtility.PropertiesFile.getPropertyValue;

public class CountryTest extends AbstractAcceptanceLoginBefore {

    String expectedCountryListPageURL= getPropertyValue("expectedCountryListPageURL");
    String expectedAddNewCountryURL= getPropertyValue("expectedAddNewCountryURL");

    @Test(priority = 1, groups= {"Opening Pages"})
    public void verifyOpeningCountryList(){
        CountryPage countryPage=new CountryPage(driver);
        countryPage.clickMenuItem();
        Assert.assertEquals(driver.getCurrentUrl(),expectedCountryListPageURL);
    }

    @Test(priority = 2, groups= {"Opening Pages"})
    public void verifyOpeningAddNewCountryForm(){
        CountryPage countryPage=new CountryPage(driver);
        countryPage.clickMenuItem();
        countryPage.getAddNewCountryBtn().click();
        Assert.assertEquals(driver.getCurrentUrl(),expectedAddNewCountryURL);
    }
}
