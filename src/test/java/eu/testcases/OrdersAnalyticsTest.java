//package eu.testcases;
//
//import eu.pages.OrdersAnalyticsPage;
//import eu.pages.UsersAnalyticsPage;
//import eu.zeewscript.SeleniumUtility.AbstractAcceptanceLoginBefore;
//import org.openqa.selenium.By;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import static eu.zeewscript.SeleniumUtility.PropertiesFile.getPropertyValue;
//
//public class OrdersAnalyticsTest extends AbstractAcceptanceLoginBefore {
//
//    String expectedOrdersPageURL = getPropertyValue("expectedOrdersPageURL");
//
//
//    //Verify that pickup order page opens and content is dispalyed correctly
//    @Test
//    public void verifyOpeningAnalyticsOrdersPage() {
//        clickMenuItem();
//        WebDriverWait wait = new WebDriverWait(driver, 5); // seconds
//        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("div:nth-child(15) div:nth-child(1) div:nth-child(1) h3:nth-child(1)"), "Vouchers Used"));
//        Assert.assertEquals(driver.getCurrentUrl(), expectedOrdersPageURL);
//    }
//
//}
