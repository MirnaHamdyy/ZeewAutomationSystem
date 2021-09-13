package eu.pages;

import eu.zeewscript.SeleniumUtility.AbstractAcceptanceLoginBefore;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MobileSliderPage extends SuperAdminTemplate {

    WebDriver driver;

    public MobileSliderPage(WebDriver driver1) {
        super(driver1);
        driver = driver1;
        PageFactory.initElements(driver1, this);
    }

    @FindBy(css="div.box-header > a.btn.btn-primary.pull-right")
    WebElement AddNewMobileSliderBtn;

    public WebElement getAddNewMobileSliderBtn() {
        return AddNewMobileSliderBtn;
    }

    public void clickMenuItem() {
        clickLeftSubMenuItemByIndex(21, 27);
    }
}
