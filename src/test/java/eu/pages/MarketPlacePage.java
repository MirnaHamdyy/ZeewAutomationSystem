package eu.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MarketPlacePage extends SuperAdminTemplate {

    WebDriver driver;

    public MarketPlacePage(WebDriver driver1) {
    super(driver1);
    driver=driver1;
        PageFactory.initElements(driver1, this);
    }

    public void clickMenuItem() {
        clickLeftMenuItemByIndex(15);
    }

}
