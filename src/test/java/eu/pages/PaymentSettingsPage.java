package eu.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentSettingsPage extends SuperAdminTemplate{

    WebDriver driver;

    public PaymentSettingsPage(WebDriver driver1){
        super(driver1);
        driver=driver1;
        PageFactory.initElements(driver1, this);
    }

    @FindBy(css="a.btn.btn-primary.pull-right:nth-child(2)")
    WebElement addPaymentMethodBtn;

    public WebElement getAddPaymentMethodBtn() {
        return addPaymentMethodBtn;
    }

    public void clickMenuItem() {
        clickLeftSubMenuItemByIndex(40, 42);
    }

}
