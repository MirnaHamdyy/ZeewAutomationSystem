package eu.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;

public class PromotionsBannerPage extends SuperAdminTemplate{

    WebDriver driver;

    public PromotionsBannerPage(WebDriver driver1) {
        super(driver1);
        driver = driver1;
        PageFactory.initElements(driver1, this);
    }

    @FindBy(css=".btn.btn-primary.pull-right")
    WebElement addNewPromotionBtn;

    

    public void clickMenuItem() {
        clickLeftSubMenuItemByIndex(21, 26);
    }

}
