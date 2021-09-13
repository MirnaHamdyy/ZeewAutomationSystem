package eu.zeewscript.SeleniumUtility;

import eu.pages.SuperadminLogin;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import static eu.zeewscript.SeleniumUtility.PropertiesFile.getPropertyValue;

public class AbstractAcceptance {

    protected WebDriver driver;

    @BeforeSuite
    public static void setupClass() {
        System.out.println("BeforeSuite");
        WebDriverManager.chromedriver().setup();
    }

    @BeforeClass
    public void setupTest() {
        System.out.println("Setup Test");
        WebDriverManager.chromedriver().getDownloadedDriverPath();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

//    @AfterTest
//    public void teardown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
}





