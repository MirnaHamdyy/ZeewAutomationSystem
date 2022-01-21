package eu.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ThirdPartySettingsPage extends SuperAdminTemplate {

    WebDriver driver;

    public ThirdPartySettingsPage(WebDriver driver1) {
        super(driver1);
        driver = driver1;
        PageFactory.initElements(driver1, this);
    }

    @FindBy(xpath = "//span[normalize-space()='Business Settings']")
    WebElement businessSettingsMainMenu;

    @FindBy(xpath = "//a[normalize-space()='ThirdParty Settings']")
    WebElement thirdPartySettingsSubMenu;

    @FindBy(css = "li.active:nth-child(1) > a:nth-child(1)")
    WebElement googleApiKeyTab;

    @FindBy(xpath = "//*[@id=\"thirdPartyForm\"]/div[2]/ul/li[2]/a")
    WebElement firebasekeyTab;

    @FindBy(xpath = "//*[@id=\"thirdPartyForm\"]/div[2]/ul/li[3]/a")
    WebElement pusherNotificationTab;

    @FindBy(xpath="//*[@id=\"thirdPartyForm\"]/div[2]/ul/li[4]/a")
    WebElement intercomTab;

    @FindBy(xpath = "//*[@id=\"thirdPartyForm\"]/div[2]/ul/li[5]/a")
    WebElement messenteTab;

    @FindBy(xpath = "//*[@id=\"thirdPartyForm\"]/div[2]/ul/li[6]/a")
    WebElement dispatcherSettingsTab;

    @FindBy(xpath = "//*[@id=\"thirdPartyForm\"]/div[2]/ul/li[7]/a")
    WebElement voipSettingTab;

    public WebElement getBusinessSettingsMainMenu() {
        return businessSettingsMainMenu;
    }

    public WebElement getThirdPartySettingsSubMenu() {
        return thirdPartySettingsSubMenu;
    }

    public WebElement getGoogleApiKeyTab() {
        return googleApiKeyTab;
    }

    public WebElement getFirebasekeyTab() {
        return firebasekeyTab;
    }

    public WebElement getPusherNotificationTab() {
        return pusherNotificationTab;
    }

    public WebElement getIntercomTab() {
        return intercomTab;
    }

    public WebElement getMessenteTab() {
        return messenteTab;
    }

    public WebElement getDispatcherSettingsTab() {
        return dispatcherSettingsTab;
    }

    public WebElement getVoipSettingTab() {
        return voipSettingTab;
    }
}
