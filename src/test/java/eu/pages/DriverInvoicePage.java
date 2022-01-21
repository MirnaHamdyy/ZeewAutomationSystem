package eu.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DriverInvoicePage extends SuperAdminTemplate {

    WebDriver driver;
    ////span[normalize-space()='Reporting']
    @FindBy(xpath = "//span[normalize-space()='Reporting']")
    WebElement reportingMainMenu;
    @FindBy(xpath = "//a[normalize-space()='Driver Invoices']")
    WebElement driverInvoicesSubMenu;

    public DriverInvoicePage(WebDriver driver1) {
        super(driver1);
        driver = driver1;
        PageFactory.initElements(driver1, this);
    }

    public WebElement getReportingMainMenu() {
        return reportingMainMenu;
    }

    public WebElement getDriverInvoicesSubMenu() {
        return driverInvoicesSubMenu;
    }
}
