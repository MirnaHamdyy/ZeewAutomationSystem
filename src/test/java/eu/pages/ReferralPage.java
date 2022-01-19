package eu.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReferralPage extends SuperAdminTemplate {

    WebDriver driver;

    @FindBy(xpath = "//span[normalize-space()='Promotions']")
    WebElement promotionMainMenu;

    @FindBy(xpath = "//a[normalize-space()='Referral']")
    WebElement referralSubMenu;

    public ReferralPage(WebDriver driver1) {
        super(driver1);
        driver = driver1;
        PageFactory.initElements(driver1, this);
    }

    public WebElement getPromotionMainMenu() {
        return promotionMainMenu;
    }

    public WebElement getReferralSubMenu() {
        return referralSubMenu;
    }
}
