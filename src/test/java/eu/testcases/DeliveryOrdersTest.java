package eu.testcases;

import eu.pages.DeliveryOdersPage;
import eu.zeewscript.SeleniumUtility.AbstractAcceptanceLoginBefore;
import eu.zeewscript.SeleniumUtility.PropertiesFile;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeliveryOrdersTest extends AbstractAcceptanceLoginBefore {

    String expectedDeliveryOrdersList = PropertiesFile.getPropertyValue("expectedDeliveryOrdersList");

    //Click on delivery page
    public void clickMenuItem() {
        DeliveryOdersPage deliveryOdersPage = new DeliveryOdersPage(driver);
        Actions actions = new Actions(driver);
        actions.moveToElement(deliveryOdersPage.getOrdersMainMenu());
        actions.perform();
        deliveryOdersPage.getOrdersMainMenu().click();
        actions.moveToElement(deliveryOdersPage.getDeliveryOrderSubMenu());
        actions.perform();
        deliveryOdersPage.getDeliveryOrderSubMenu().click();
    }

    @Test()
    public void verifyOpeningDeliveryOrder() throws InterruptedException {
        clickMenuItem();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("section.content-header > h1:nth-child(1)"), "Delivery Orders"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedDeliveryOrdersList);
    }
}
