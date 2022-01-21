package eu.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StoresAnalyticsPage extends SuperAdminTemplate {

    WebDriver driver;

    public StoresAnalyticsPage(WebDriver driver1) {
        super(driver1);
        driver = driver1;
        PageFactory.initElements(driver1, this);
    }

    @FindBy(xpath = "//span[normalize-space()='Analytics']")
    WebElement analyticsMainMenu;

    @FindBy(xpath = "//a[@class='sidebar-link'][normalize-space()='Stores']")
    WebElement storeAnalyticsSubMenu;

    public WebElement getAnalyticsMainMenu() {
        return analyticsMainMenu;
    }

    public WebElement getStoreAnalyticsSubMenu() {
        return storeAnalyticsSubMenu;
    }
}
