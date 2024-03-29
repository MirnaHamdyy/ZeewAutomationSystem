package eu.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangePasswordPage extends SuperAdminTemplate {

    WebDriver driver;

    @FindBy(xpath = "//span[normalize-space()='Business Settings']")
    WebElement businessSettingsMainMenu;

    @FindBy(xpath = "//li[@id='36']//a")
    WebElement changePasswordSubMenu;

    public ChangePasswordPage(WebDriver driver1) {
        super(driver1);
        driver = driver1;
        PageFactory.initElements(driver1, this);
    }

    public WebElement getBusinessSettingsMainMenu() {
        return businessSettingsMainMenu;
    }

    public WebElement getChangePasswordSubMenu() {
        return changePasswordSubMenu;
    }

}
