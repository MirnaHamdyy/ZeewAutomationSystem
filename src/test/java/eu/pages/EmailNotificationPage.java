package eu.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmailNotificationPage extends SuperAdminTemplate {

    WebDriver driver;

    public EmailNotificationPage(WebDriver driver1) {
        super(driver1);
        driver = driver1;
        PageFactory.initElements(driver1, this);
    }

    @FindBy(xpath = "//span[normalize-space()='Business Settings']")
    WebElement businessSettingsMainMenu;

    @FindBy(xpath = "//a[normalize-space()='Email Notification']")
    WebElement emailNotificationSubMenu;


    public WebElement getBusinessSettingsMainMenu() {
        return businessSettingsMainMenu;
    }

    public WebElement getEmailNotificationSubMenu() {
        return emailNotificationSubMenu;
    }
}

