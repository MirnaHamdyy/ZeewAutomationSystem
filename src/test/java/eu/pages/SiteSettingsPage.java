package eu.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SiteSettingsPage extends SuperAdminTemplate{

    WebDriver driver;

    public SiteSettingsPage(WebDriver driver1){
        super(driver1);
        driver=driver1;
        PageFactory.initElements(driver1, this);
    }

    @FindBy(id="contactInfo")
    WebElement contactTab;

    @FindBy(id="locationInfo")
    WebElement locationTab;

    @FindBy(css="ul.nav.nav-tabs li:nth-child(4) > a:nth-child(1)")
    WebElement analyticCodeTab;

    @FindBy(css="ul.nav.nav-tabs li:nth-child(5) > a:nth-child(1)")
    WebElement mailSettingTab;

    @FindBy(css="ul.nav.nav-tabs li:nth-child(6) > a:nth-child(1)")
    WebElement invoicesTab;

    @FindBy(css="ul.nav.nav-tabs li:nth-child(7) > a:nth-child(1)")
    WebElement offlineTab;

    @FindBy(css="ul.nav.nav-tabs li:nth-child(8) > a:nth-child(1)")
    WebElement metaTagsTab;

    @FindBy(css="ul.nav.nav-tabs li:nth-child(9) > a:nth-child(1)")
    WebElement orderAssignTab;

    @FindBy(css = "ul.nav.nav-tabs li:nth-child(10) > a:nth-child(1)")
    WebElement languageTab;

    @FindBy(css= "ul.nav.nav-tabs li:nth-child(11) > a:nth-child(1)")
    WebElement bankInfoTab;

    @FindBy(css= "ul.nav.nav-tabs li:nth-child(12) > a:nth-child(1)")
    WebElement socialMediaTab;

    @FindBy(css="ul.nav.nav-tabs li:nth-child(13) > a:nth-child(1)")
    WebElement appStoreLinksTab;

    @FindBy(css="ul.nav.nav-tabs li:nth-child(14) > a:nth-child(1)")
    WebElement webSettingsTab;


    public WebElement getContactTab() {
        return contactTab;
    }

    public WebElement getLocationTab() {
        return locationTab;
    }

    public WebElement getAnalyticCodeTab() {
        return analyticCodeTab;
    }

    public WebElement getMailSettingTab() {
        return mailSettingTab;
    }

    public WebElement getInvoicesTab() {
        return invoicesTab;
    }

    public WebElement getOfflineTab() {
        return offlineTab;
    }

    public WebElement getMetaTagsTab() {
        return metaTagsTab;
    }

    public WebElement getOrderAssignTab() {
        return orderAssignTab;
    }

    public WebElement getLanguageTab() {
        return languageTab;
    }

    public WebElement getBankInfoTab() {
        return bankInfoTab;
    }

    public WebElement getSocialMediaTab() {
        return socialMediaTab;
    }

    public WebElement getAppStoreLinksTab() {
        return appStoreLinksTab;
    }

    public WebElement getWebSettingsTab() {
        return webSettingsTab;
    }

    //Click on the promotions then cick on the Rewards page
    public void clickMenuItem() {
        clickLeftSubMenuItemByIndex(40, 41);
    }

}
