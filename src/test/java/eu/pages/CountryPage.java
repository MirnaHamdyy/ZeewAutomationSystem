package eu.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CountryPage extends SuperAdminTemplate {
    WebDriver driver;

    public CountryPage(WebDriver driver1) {
        super(driver1);
        driver = driver1;
        PageFactory.initElements(driver1, this);
    }

    @FindBy(xpath = "//span[normalize-space()='Locations']")
    WebElement locationMainMenu;

    @FindBy(xpath = "//a[normalize-space()='Country']")
    WebElement countrySubMenu;

    @FindBy(css = "div.box.my-box div.box-header > a.btn.btn-primary.pull-right")
    WebElement addNewCountryBtn;

    public WebElement getAddNewCountryBtn() {
        return addNewCountryBtn;
    }

    public WebElement getLocationMainMenu() {
        return locationMainMenu;
    }

    public WebElement getCountrySubMenu() {
        return countrySubMenu;
    }
}
