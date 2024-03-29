package eu.zeewscript.SeleniumUtility;

import eu.pages.SuperadminLogin;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import static eu.zeewscript.SeleniumUtility.PropertiesFile.getPropertyValue;

public class AbstractAcceptanceLoginBefore {

    protected WebDriver driver;
    String superAdminURL = getPropertyValue("superAdminExpectedURL");

    @BeforeSuite
    public static void setupClass() {

        WebDriverManager.chromedriver().setup();
    }

    //@BeforeSuite
    @BeforeMethod
    public void setupTest() {

        WebDriverManager.chromedriver().getDownloadedDriverPath();
        ChromeOptions opt = new ChromeOptions();
     //   opt.addArguments("headless");
        driver = new ChromeDriver(opt);
        driver.manage().window().maximize();
    }

    public void runWithoutOpeningBrowser() {
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("headless");
        WebDriver d = new ChromeDriver(opt);
    }

    // @BeforeClass
    @BeforeMethod
    public void signinTest() {
        driver.get(getPropertyValue("storeUrl"));

        SuperadminLogin superAdminLoginObj = new SuperadminLogin(driver);
        //get email & password test date from the config properties
        String email = getPropertyValue("superAdminEmail");
        String password = getPropertyValue("superAdminPassword");

        superAdminLoginObj.setEmailInput(email);
        System.out.println("Email: " + email);
        superAdminLoginObj.setPasswordInput(password);
        System.out.println("Password: " + password);
        superAdminLoginObj.getSignInButton().click();
        Assert.assertEquals(driver.getCurrentUrl(), superAdminURL);
    }

//    @AfterMethod
//    public void teardown() {
//        if (driver != null) {
//            driver.quit();
//        }
    // }
}
