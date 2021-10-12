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

    @FindBy(css = "div.box-header > a.btn.btn-primary.pull-right")
    WebElement addNewVoucherBtn;

    @FindBy(xpath = "//body/div/aside/section/ul[@data-widget='tree']/li[12]/a[1]")
    WebElement promotionsMenu;

    @FindBy(xpath = "//a[normalize-space()='Vouchers']")
    WebElement voucherSubMenu;

    public WebElement getAddNewVoucherBtn() {
        return addNewVoucherBtn;
    }

    public WebElement getPromotionsMenu() {
        return promotionsMenu;
    }

    //Click on the promotions then cick on the Voucher
    //public void clickMenuItem() {
    //clickLeftSubMenuItemByIndex(21, 24);
//    }

    public WebElement getVoucherSubMenu() {
        return voucherSubMenu;
    }

    public void clickMenuItem() {
        getPromotionsMenu().click();
        getVoucherSubMenu().click();
    }
}