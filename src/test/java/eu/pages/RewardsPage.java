package eu.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class RewardsPage extends SuperAdminTemplate{

    WebDriver driver;

    public RewardsPage(WebDriver driver1){
        super(driver1);
        driver=driver1;
        PageFactory.initElements(driver1, this);
    }

    //Click on the promotions then cick on the Rewards page
    public void clickMenuItem() {
        clickLeftSubMenuItemByIndex(21, 25);
    }

}
