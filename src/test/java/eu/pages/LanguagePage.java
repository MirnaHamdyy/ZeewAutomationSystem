package eu.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LanguagePage extends SuperAdminTemplate{

    WebDriver driver;

    public LanguagePage(WebDriver driver1){
        super(driver1);
        driver=driver1;
        PageFactory.initElements(driver1, this);
    }

    @FindBy(id="platform-type")
    WebElement selectPlatformDropDownList;

    public WebElement getSelectPlatformDropDownList() {
        return selectPlatformDropDownList;
    }

    public void selectPlatformItem(){
        Select drpPlatformCity = new Select(selectPlatformDropDownList);
        drpPlatformCity.selectByVisibleText("Mobile Apps");
    }

    public void clickMenuItem() {
        clickLeftSubMenuItemByIndex(40, 46);
    }
}
