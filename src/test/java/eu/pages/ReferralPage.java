package eu.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ReferralPage extends SuperAdminTemplate{

    WebDriver driver;

    public ReferralPage(WebDriver driver1){
        super(driver1);
        driver=driver1;
        PageFactory.initElements(driver1, this);
    }

    //Click on the promotions then cick on the Referral
    public void clickMenuItem() {
        clickLeftSubMenuItemByIndex(21, 23);
    }
}
