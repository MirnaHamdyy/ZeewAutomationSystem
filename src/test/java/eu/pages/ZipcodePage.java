package eu.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZipcodePage extends SuperAdminTemplate{

    WebDriver driver;

    public ZipcodePage(WebDriver driver1){
        super(driver1);
        driver=driver1;
        PageFactory.initElements(driver1, this);
    }

    @FindBy(xpath = "//a[normalize-space()='Add New']")
    WebElement addNewZipcodeBtn;

    public WebElement getAddNewZipcodeBtn() {
        return addNewZipcodeBtn;
    }

    public void clickMenuItem() {
        clickLeftSubMenuItemByIndex(52, 56);
    }
}
