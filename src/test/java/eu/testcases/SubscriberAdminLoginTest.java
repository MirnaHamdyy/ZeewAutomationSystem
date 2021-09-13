package eu.testcases;

import eu.pages.SuperadminLogin;
import eu.zeewscript.SeleniumUtility.AbstractAcceptance;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static eu.zeewscript.SeleniumUtility.PropertiesFile.getPropertyValue;


public class SubscriberAdminLoginTest extends AbstractAcceptance {

    //Admin can login to his store
    @BeforeMethod
    public void signinTest() {

        driver.get(getPropertyValue("storeUrl"));
        SuperadminLogin superAdminLoginObj = new SuperadminLogin(driver);
        //get email & password test date from the config properties
        String email = getPropertyValue("superAdminEmail");
        String password = getPropertyValue("superAdminPassword");

        String expectedStoreUrl = "https://automate-market-place.deliveryscripts.com/superadmin/dashboard";
        superAdminLoginObj.setEmailInput(email);
        System.out.println("Email: " + email);
        superAdminLoginObj.setPasswordInput(password);
        System.out.println("Password: " + password);
        superAdminLoginObj.getSignInButton().click();
        Assert.assertEquals(driver.getCurrentUrl(), expectedStoreUrl);



    }
}
