package eu.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SurChargeSettingsPage extends SuperAdminTemplate {

    WebDriver driver;

    public SurChargeSettingsPage(WebDriver driver1) {
        super(driver1);
        driver = driver1;
        PageFactory.initElements(driver1, this);
    }

    @FindBy(xpath = "//span[normalize-space()='Surcharge Settings']")
    WebElement surChargeSettingsMainMenu;

    public WebElement getSurChargeSettingsMainMenu() {
        return surChargeSettingsMainMenu;
    }
}
