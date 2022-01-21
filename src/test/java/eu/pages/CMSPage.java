package eu.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CMSPage extends SuperAdminTemplate {

    WebDriver driver;

    @FindBy(xpath = "//span[normalize-space()='Business Settings']")

    WebElement businessSettingsMainMenu;
    @FindBy(xpath = "//a[normalize-space()='CMS']")
    WebElement cmsSubMenu;

    public CMSPage(WebDriver driver1) {
        super(driver1);
        driver = driver1;
        PageFactory.initElements(driver1, this);
    }

    @FindBy(css = "div.col-xs-12 div.box.my-box div.box-header > a.btn.btn-primary.pull-right")
    WebElement addNewStaticPageBtn;

    public WebElement getBusinessSettingsMainMenu() {
        return businessSettingsMainMenu;
    }

    public WebElement getCmsSubMenu() {
        return cmsSubMenu;
    }

    public WebElement getAddNewStaticPageBtn() {
        return addNewStaticPageBtn;
    }

}
