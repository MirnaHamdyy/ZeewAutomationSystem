package eu.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HaveIssuesPage extends  SuperAdminTemplate{

    WebDriver driver;

    public HaveIssuesPage(WebDriver driver1){
        super(driver1);
        driver=driver1;
        PageFactory.initElements(driver1, this);
    }

    public void clickMenuItem() {
        clickLeftSubMenuItemByIndex(7, 10);
    }


}
