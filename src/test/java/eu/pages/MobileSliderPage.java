package eu.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MobileSliderPage extends SuperAdminTemplate {

    WebDriver driver;

    public MobileSliderPage(WebDriver driver1) {
        super(driver1);
        driver = driver1;
        PageFactory.initElements(driver1, this);
    }

    @FindBy(xpath = "//span[normalize-space()='Promotions']")
    WebElement promotionsMainMenu;

    @FindBy(xpath = "//a[normalize-space()='Mobile sliders']")
    WebElement mobileSlidersSubMenu;


    @FindBy(css = "div.box-header > a.btn.btn-primary.pull-right")
    WebElement AddNewMobileSliderBtn;

    public WebElement getPromotionsMainMenu() {
        return promotionsMainMenu;
    }

    public WebElement getMobileSlidersSubMenu() {
        return mobileSlidersSubMenu;
    }

    public WebElement getAddNewMobileSliderBtn() {
        return AddNewMobileSliderBtn;
    }
}
