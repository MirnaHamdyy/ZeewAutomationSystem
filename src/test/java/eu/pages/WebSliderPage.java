package eu.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebSliderPage extends SuperAdminTemplate{

    WebDriver driver;

    public WebSliderPage(WebDriver driver1) {
        super(driver1);
        driver = driver1;
        PageFactory.initElements(driver1, this);
    }

    @FindBy(css="div.box-header > a.btn.btn-primary.pull-right")
    WebElement AddNewWebSliderBtn;

    public WebElement getAddNewWebSliderBtn() {
        return AddNewWebSliderBtn;
    }

    public void clickMenuItem() {
        clickLeftSubMenuItemByIndex(21, 28);
    }
}
