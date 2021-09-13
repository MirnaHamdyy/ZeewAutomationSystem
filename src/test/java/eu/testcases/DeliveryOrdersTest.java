package eu.testcases;

import eu.pages.DeliveryOdersPage;
import eu.zeewscript.SeleniumUtility.AbstractAcceptanceLoginBefore;
import eu.zeewscript.SeleniumUtility.PropertiesFile;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class DeliveryOrdersTest extends AbstractAcceptanceLoginBefore {

    String expectedDeliveryOrdersList = PropertiesFile.getPropertyValue("expectedDeliveryOrdersList");

    @Test(groups= {"Opening Pages"})
    public void verifyOpeningDeliveryOrder(){

        DeliveryOdersPage deliveryOdersPage=new DeliveryOdersPage(driver);
        deliveryOdersPage.clickMenuItem();
        WebDriverWait wait= new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("section.content-header > h1:nth-child(1)"), "Delivery Orders"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedDeliveryOrdersList);
    }

//    @AfterClass
//    public void teardown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
}
