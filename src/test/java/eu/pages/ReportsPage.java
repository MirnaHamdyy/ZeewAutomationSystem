package eu.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReportsPage extends SuperAdminTemplate {

    WebDriver driver;

    public ReportsPage(WebDriver driver1) {
        super(driver1);
        driver = driver1;
        PageFactory.initElements(driver1, this);
    }

    @FindBy(xpath = "//span[normalize-space()='Reporting']")
    WebElement reportingMainMenu;

    @FindBy(xpath = "//a[normalize-space()='Reports']")
    WebElement reportsSubMenu;

    public WebElement getReportingMainMenu() {
        return reportingMainMenu;
    }

    public WebElement getReportsSubMenu() {
        return reportsSubMenu;
    }
}
