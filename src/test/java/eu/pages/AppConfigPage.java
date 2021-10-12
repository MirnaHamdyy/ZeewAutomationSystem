package eu.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AppConfigPage extends SuperAdminTemplate {

    WebDriver driver;

    @FindBy(xpath = "//span[normalize-space()='Configure Mobile Apps']")
    WebElement configMobileApps;
    @FindBy(xpath = "//a[normalize-space()='App Config']")
    WebElement appConfigSubMenu;
    @FindBy(xpath = "//a[normalize-space()='App Colors']")
    WebElement appColorsTab;

    public AppConfigPage(WebDriver driver1) {
        super(driver1);
        driver = driver1;
        PageFactory.initElements(driver1, this);
    }

    public WebElement getConfigMobileApps() {
        return configMobileApps;
    }

    public WebElement getAppConfigSubMenu() {
        return appConfigSubMenu;
    }

    public WebElement getAppColorsTab() {
        return appColorsTab;
    }

//    public void clickMenuItem() {
//        clickLeftSubMenuItemByIndex(12, 13);
//    }

}