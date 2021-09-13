package eu.pages;

import eu.zeewscript.SeleniumUtility.AbstractAcceptanceLoginBefore;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SurChargeSettingsPage extends SuperAdminTemplate {

    WebDriver driver;

    public SurChargeSettingsPage(WebDriver driver1) {
        super(driver1);
        driver = driver1;
        PageFactory.initElements(driver1, this);
    }

    public void clickMenuItem() {
        clickLeftMenuItemByIndex(16);
    }

}
