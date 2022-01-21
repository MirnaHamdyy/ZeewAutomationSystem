package eu.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyPlanPage extends SuperAdminTemplate {

    WebDriver driver;

    @FindBy(xpath = "//span[normalize-space()='Billing']")
    WebElement billingMainMenu;
    @FindBy(xpath = "//a[normalize-space()='My Plan']")
    WebElement myPlanSubMenu;

    public MyPlanPage(WebDriver driver1) {
        super(driver1);
        driver = driver1;
        PageFactory.initElements(driver1, this);
    }

    public WebElement getBillingMainMenu() {
        return billingMainMenu;
    }

    public WebElement getMyPlanSubMenu() {
        return myPlanSubMenu;
    }
}
