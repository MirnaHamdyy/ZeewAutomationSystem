package eu.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BecomePartnerPage extends SuperAdminTemplate {

    WebDriver driver;

    @FindBy(xpath = "//a[@href='/superadmin/resellers/becomePartner']//span")
    WebElement becomePartnerMainMenu;

    public BecomePartnerPage(WebDriver driver1) {
        super(driver1);
        driver = driver1;
        PageFactory.initElements(driver1, this);
    }

    public WebElement getBecomePartnerMainMenu() {
        return becomePartnerMainMenu;
    }

//    public void clickMenuItem() {
//        clickLeftMenuItemByIndex(61);
//    }


}


