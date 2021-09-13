package eu.testcases;

import eu.pages.ZeewRegisteration;
import eu.zeewscript.SeleniumUtility.AbstractAcceptance;
import eu.zeewscript.SeleniumUtility.PropertiesFile;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static eu.zeewscript.SeleniumUtility.PropertiesFile.getPropertyValue;

public class SignUpTest extends PropertiesFile{

    //  String platformName = getPropertyValue("platformName");

    String expectedStoreURL = getPropertyValue("storeUrl");
    //  String email = getPropertyValue("email");
    String firstName = getPropertyValue("firstName");
    String lastName = getPropertyValue("lastName");
    String phoneNumber = getPropertyValue("phoneNumber");
    String password = getPropertyValue("password");
    String passwordConfirm = getPropertyValue("passwordConfirm");
    WebDriver driver;


//    @Test(alwaysRun = !PropertiesFile.isNewStore, threadPoolSize = 20, invocationCount = 20)
    @Test(groups= {"Opening Pages"})
    public void subscribeUserTest() throws Exception {
        String randomStr = RandomStringUtils.randomAlphabetic(3).toLowerCase();
        String platformName = ("pharmacy-" + randomStr);

       // String expectedStoreURL = "https://" + platformName + ".deliveryscripts.com/superadmin/users/onboarding?conversion=success";
        String expectedStoreURL ="https://saasdev.deliveryscripts.com/signup";

        WebDriver driver;

        WebDriverManager.chromedriver().setup();
        WebDriverManager.chromedriver().getDownloadedDriverPath();
        driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();

        options.addArguments("headless");
        options.addArguments("window-size=1200x600");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        ZeewRegisteration zeewRegisteration = new ZeewRegisteration(driver);
        zeewRegisteration.openPage();
        firstName = getPropertyValue("firstName");
        lastName = getPropertyValue("lastName");
        phoneNumber = getPropertyValue("phoneNumber");
        password = getPropertyValue("password");
        passwordConfirm = getPropertyValue("passwordConfirm");
        String email = getPropertyValue("email").replace("@", (randomStr + "@"));
        zeewRegisteration.setFirstNameInput(firstName);
        zeewRegisteration.setLastNameInput(lastName);
        zeewRegisteration.setPhoneNumberInput(phoneNumber);
        zeewRegisteration.setEmailInput(email);
        zeewRegisteration.setPasswordInput(password);
        zeewRegisteration.setPasswordConfirmInput(passwordConfirm);
        zeewRegisteration.setPlatformNameInput(platformName);
        zeewRegisteration.getIsAgreeCheckbox().click();
        zeewRegisteration.selectAddressOption();
        zeewRegisteration.getCreateYourBtn().click();
   //     WebDriverWait wait = new WebDriverWait(driver, 50); // seconds
    //    wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(".content-header h1:nth-child(1)"), "Onboarding"));
       String currentUrl = driver.getCurrentUrl();
     //   System.out.println("URL: " + currentUrl);
        Assert.assertEquals(currentUrl, expectedStoreURL);
    }

//        @AfterTest
//    public void teardown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }

}
