package eu.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ImportCSVPage extends SuperAdminTemplate{

    WebDriver driver;

    public ImportCSVPage(WebDriver driver1){
        super(driver1);
        driver=driver1;
        PageFactory.initElements(driver1, this);
    }

    public void clickMenuItem() {
        clickLeftMenuItemByIndex(58);
    }

}
