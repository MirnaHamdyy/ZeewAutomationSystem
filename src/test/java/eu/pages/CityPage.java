package eu.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CityPage extends SuperAdminTemplate {

    WebDriver driver;

    @FindBy(xpath = "//span[normalize-space()='Locations']")
    WebElement locationMainMenu;
    @FindBy(xpath = "//li[@id='43']//a")
    WebElement citySubMenu;

    public CityPage(WebDriver driver1) {
        super(driver1);
        driver = driver1;
        PageFactory.initElements(driver1, this);
    }

    @FindBy(css = "div.box.my-box div.box-header > a.btn.btn-primary.pull-right")
    WebElement addNewCityBtn;

    public WebElement getLocationMainMenu() {
        return locationMainMenu;
    }

    public WebElement getCitySubMenu() {
        return citySubMenu;
    }

    public WebElement getAddNewCityBtn() {
        return addNewCityBtn;
    }

    public void clickMenuItem() {
        clickLeftSubMenuItemByIndex(53, 56);
    }

}
