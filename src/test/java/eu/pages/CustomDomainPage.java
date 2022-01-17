package eu.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomDomainPage extends SuperAdminTemplate {
    WebDriver driver;

    public CustomDomainPage(WebDriver driver1) {
        super(driver1);
        driver = driver1;
        PageFactory.initElements(driver1, this);
    }

    @FindBy(xpath = "//span[normalize-space()='Custom Domain']")
    WebElement customDomainMenuItem;

    public WebElement getCustomDomainMenuItem() {
        return customDomainMenuItem;
    }
}
