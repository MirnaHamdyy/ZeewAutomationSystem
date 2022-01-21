package eu.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentSettingsPage extends SuperAdminTemplate {

    WebDriver driver;

    public PaymentSettingsPage(WebDriver driver1) {
        super(driver1);
        driver = driver1;
        PageFactory.initElements(driver1, this);
    }

    @FindBy(xpath = "//span[normalize-space()='Business Settings']")
    WebElement businessSettingsMainMenu;

    @FindBy(xpath = "//a[@class='sidebar-link'][normalize-space()='Payment Settings']")
    WebElement paymentSettingsSubMenu;

    @FindBy(css = "a.btn.btn-primary.pull-right:nth-child(2)")
    WebElement addPaymentMethodBtn;

    public WebElement getBusinessSettingsMainMenu() {
        return businessSettingsMainMenu;
    }


    public WebElement getPaymentSettingsSubMenu() {
        return paymentSettingsSubMenu;
    }

    public WebElement getAddPaymentMethodBtn() {
        return addPaymentMethodBtn;
    }


}
