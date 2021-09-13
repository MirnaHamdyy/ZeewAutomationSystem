package eu.testcases;

import eu.pages.HelpPage;
import eu.zeewscript.SeleniumUtility.AbstractAcceptanceLoginBefore;
import org.testng.Assert;
import org.testng.annotations.Test;

import static eu.zeewscript.SeleniumUtility.PropertiesFile.getPropertyValue;

public class HelpTest extends AbstractAcceptanceLoginBefore {

    String expectedHelpPageURL= getPropertyValue("expectedHelpPageURL");
//
//    @Test
//    public void verifyingOpeningHelpPage(){
//        HelpPage helpPage=new HelpPage(driver);
//        helpPage.clickMenuItem();
//        Assert.assertEquals(driver.getCurrentUrl(), expectedHelpPageURL);
//    }
}
