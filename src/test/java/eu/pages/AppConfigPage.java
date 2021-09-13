package eu.pages;

import net.bytebuddy.implementation.bind.annotation.Super;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AppConfigPage extends SuperAdminTemplate{

    WebDriver driver;
    public AppConfigPage(WebDriver driver1){
        super(driver1);
        driver=driver1;
        PageFactory.initElements(driver1, this);
    }

    @FindBy(css=".nav-tabs :nth-child(2) > a:nth-child(1)")
    WebElement AppConfigTab;

    public WebElement getAppConfigTab() {
        return AppConfigTab;
    }

    public void clickMenuItem() {
        clickLeftSubMenuItemByIndex(12, 13);
    }

}
