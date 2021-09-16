package eu.testcases;

import eu.pages.CustomersPage;
import eu.zeewscript.SeleniumUtility.AbstractAcceptanceLoginBefore;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static eu.zeewscript.SeleniumUtility.PropertiesFile.getPropertyValue;

public class CustomersTest extends AbstractAcceptanceLoginBefore {

    String expectedCustomersListURL = getPropertyValue("expectedCustomersList");
    String expectedAddNewCustomerURL = getPropertyValue("expectedAddNewCustomerURL");
    String expectedEditCustomerURL = getPropertyValue("expectedEditCustomerURl");

    @Test(priority = 1, groups= {"Opening Pages"})
    public void verifyOpeningCustomersPage() {
        CustomersPage customersPage = new CustomersPage(driver);
        customersPage.clickMenuItem();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("section.content-header > h1:nth-child(1)"), "Manage Customer"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedCustomersListURL);
    }

    @Test(priority = 2,groups= {"Opening Pages"})
    public void verifyOpeningAddNewCustomerForm() {
        CustomersPage customersPage = new CustomersPage(driver);
        customersPage.clickMenuItem();
        customersPage.getAddNewCustomerBtn().click();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("section.content-header > h1:nth-child(1)"), "Add Customer"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedAddNewCustomerURL);
    }

    @Test(priority = 3,groups= {"Opening Pages"})
    public void VerifyOpeningEditCustomerForm() {
        CustomersPage customersPage = new CustomersPage(driver);
        customersPage.clickMenuItem();
        customersPage.getEditCustomerIcon().click();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("section.content-header > h1:nth-child(1)"), "Edit Customer"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedEditCustomerURL);
    }

}
