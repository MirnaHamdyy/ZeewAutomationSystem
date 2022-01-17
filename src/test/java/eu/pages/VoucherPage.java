package eu.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VoucherPage extends SuperAdminTemplate {

    WebDriver driver;

    public VoucherPage(WebDriver driver1) {
        super(driver1);
        driver = driver1;
        PageFactory.initElements(driver1, this);
    }

    @FindBy(xpath = "//span[normalize-space()='Promotions']")
    WebElement promotionsMainMenu;

    @FindBy(xpath = "//a[normalize-space()='Vouchers']")
    WebElement voucherSubMenu;

    @FindBy(css = "div.box-header > a.btn.btn-primary.pull-right")
    WebElement addNewVoucherBtn;


    public WebElement getPromotionsMainMenu() {
        return promotionsMainMenu;
    }

    public WebElement getVoucherSubMenu() {
        return voucherSubMenu;
    }

    public WebElement getAddNewVoucherBtn() {
        return addNewVoucherBtn;
    }

}