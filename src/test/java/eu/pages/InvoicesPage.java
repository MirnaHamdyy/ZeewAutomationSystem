package eu.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class InvoicesPage extends SuperAdminTemplate{

    WebDriver driver;

    public InvoicesPage(WebDriver driver1) {
        super(driver1);
        driver = driver1;
        PageFactory.initElements(driver1, this);
    }


    public void clickMenuItem() {
        clickLeftSubMenuItemByIndex(35, 37);
    }

}
