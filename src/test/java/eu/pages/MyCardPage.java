package eu.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyCardPage extends SuperAdminTemplate {

    WebDriver driver;

    @FindBy(xpath = "//span[normalize-space()='Billing']")
    WebElement billingMainMenu;

    @FindBy(xpath = "//a[normalize-space()='My Cards']")
    WebElement myCardsSubMenuItem;

    public MyCardPage(WebDriver driver1) {
        super(driver1);
        driver = driver1;
        PageFactory.initElements(driver1, this);
    }

    public WebElement getBillingMainMenu() {
        return billingMainMenu;
    }

    public WebElement getMyCardsSubMenuItem() {
        return myCardsSubMenuItem;
    }
}

