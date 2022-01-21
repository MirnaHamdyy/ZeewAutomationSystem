package eu.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PromotionsBannerPage extends SuperAdminTemplate {

    WebDriver driver;

    public PromotionsBannerPage(WebDriver driver1) {
        super(driver1);
        driver = driver1;
        PageFactory.initElements(driver1, this);
    }


    @FindBy(xpath = "//span[normalize-space()='Promotions']")
    WebElement promotionsMainMenu;

    @FindBy(xpath = "//a[normalize-space()='Promotion Banners']")
    WebElement promotionBannerSubMenu;

    @FindBy(css = ".btn.btn-primary.pull-right")
    WebElement addNewPromotionBtn;

    public WebElement getPromotionsMainMenu() {
        return promotionsMainMenu;
    }

    public WebElement getPromotionBannerSubMenu() {
        return promotionBannerSubMenu;
    }

    public WebElement getAddNewPromotionBtn() {
        return addNewPromotionBtn;
    }
}
