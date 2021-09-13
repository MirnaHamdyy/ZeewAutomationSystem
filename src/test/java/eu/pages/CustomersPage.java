package eu.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomersPage extends SuperAdminTemplate {

    WebDriver driver;

    public CustomersPage(WebDriver driver1) {
        super(driver1);
        driver = driver1;
        PageFactory.initElements(driver1, this);
    }

    @FindBy(css = "div.box-header > a.btn.btn-primary.pull-right")
    WebElement addNewCustomerBtn;

    @FindBy(css="td:nth-child(10) a:nth-child(1) > i.fa.fa-pencil")
    WebElement editCustomerIcon;


    public WebElement getAddNewCustomerBtn() {
        return addNewCustomerBtn;
    }
    public WebElement getEditCustomerIcon() {
        return editCustomerIcon;
    }

    public void clickMenuItem() {
        clickLeftMenuItemByIndex(11);
    }


}
