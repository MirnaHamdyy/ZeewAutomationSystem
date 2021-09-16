package eu.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CountryPage extends SuperAdminTemplate{
    WebDriver driver;

    public CountryPage(WebDriver driver1){
        super(driver1);
        driver=driver1;
        PageFactory.initElements(driver1, this);
    }

    @FindBy(css = "div.box.my-box div.box-header > a.btn.btn-primary.pull-right")
    WebElement addNewCountryBtn;

    public WebElement getAddNewCountryBtn() {
        return addNewCountryBtn;
    }

    public void clickMenuItem() {
        clickLeftSubMenuItemByIndex(53, 54);
    }



}
