package eu.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubadminPage extends SuperAdminTemplate {

    WebDriver driver;

    public SubadminPage(WebDriver driver1) {
        super(driver1);
        driver = driver1;
        PageFactory.initElements(driver1, this);
    }

    @FindBy(xpath = "//span[normalize-space()='Business Settings']")
    WebElement businessSettingsMainMenu;

    @FindBy(xpath = "//a[normalize-space()='Subadmins']")
    WebElement subAdminSubMenu;

    @FindBy(xpath = "/html/body/div[1]/div[2]/section[2]/div/div/div/div[1]/a")
    WebElement addNewSubAdminBtn;

    public WebElement getAddNewSubAdminBtn() {
        return addNewSubAdminBtn;
    }

    public WebElement getBusinessSettingsMainMenu() {
        return businessSettingsMainMenu;
    }

    public WebElement getSubAdminSubMenu() {
        return subAdminSubMenu;
    }
}
