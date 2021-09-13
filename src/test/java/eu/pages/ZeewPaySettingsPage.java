package eu.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZeewPaySettingsPage extends SuperAdminTemplate{

    WebDriver driver;
    public ZeewPaySettingsPage(WebDriver driver1){
        super(driver1);
        driver=driver1;
        PageFactory.initElements(driver1, this);
    }

    @FindBy(id="bank-info-tab")
    WebElement bankInformationTab;

    @FindBy(id="ownership-info-tab")
    WebElement ownershipInfoTab;

    @FindBy(id="company-representative-info-tab")
    WebElement companyRepresentativeInformationTab;

    @FindBy(id="additional-info-tab")
    WebElement additionalInformationTab;

    public WebElement getBankInformationTab() {
        return bankInformationTab;
    }

    public WebElement getOwnershipInfoTab() {
        return ownershipInfoTab;
    }

    public WebElement getCompanyRepresentativeInformationTab() {
        return companyRepresentativeInformationTab;
    }

    public WebElement getAdditionalInformationTab() {
        return additionalInformationTab;
    }

    public void clickMenuItem() {
        clickLeftMenuItemByIndex(59);
    }


}
