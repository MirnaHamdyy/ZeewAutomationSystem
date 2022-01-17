package eu.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MarketPlacePage extends SuperAdminTemplate {

    WebDriver driver;

    public MarketPlacePage(WebDriver driver1) {
        super(driver1);
        driver = driver1;
        PageFactory.initElements(driver1, this);
    }

    @FindBy(xpath = "//a[@href='https://automated-store.deliveryscripts.com/superadmin/MarketPlace']")
    WebElement marketPlaceMainMenu;

    public WebElement getMarketPlaceMainMenu() {
        return marketPlaceMainMenu;
    }
}
