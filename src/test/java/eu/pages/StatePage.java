package eu.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StatePage extends SuperAdminTemplate{
    WebDriver driver;

    public StatePage(WebDriver driver1){
        super(driver1);
        driver=driver1;
        PageFactory.initElements(driver1, this);
    }

    @FindBy(css = "div.box.my-box div.box-header > a.btn.btn-primary.pull-right")
    WebElement addNewStateBtn;

    public WebElement getAddNewStateBtn() {
        return addNewStateBtn;
    }

    public void clickMenuItem() {
        clickLeftSubMenuItemByIndex(53, 55);
    }

}
