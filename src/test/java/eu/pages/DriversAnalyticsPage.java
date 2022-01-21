package eu.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DriversAnalyticsPage extends SuperAdminTemplate {

    WebDriver driver;

    public DriversAnalyticsPage(WebDriver driver1) {
        super(driver1);
        driver = driver1;
        PageFactory.initElements(driver1, this);
    }

    @FindBy(xpath = "//span[normalize-space()='Analytics']")
    WebElement analyticsMainMenu;

    @FindBy(xpath = "//a[normalize-space()='Drivers']")
    WebElement driverAnalyticsSubMenu;

    public WebElement getAnalyticsMainMenu() {
        return analyticsMainMenu;
    }

    public WebElement getDriverAnalyticsSubMenu() {
        return driverAnalyticsSubMenu;
    }
}
