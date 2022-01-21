package eu.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InvoicesPage extends SuperAdminTemplate {

    WebDriver driver;

    public InvoicesPage(WebDriver driver1) {
        super(driver1);
        driver = driver1;
        PageFactory.initElements(driver1, this);
    }

    @FindBy(xpath = "//span[normalize-space()='Reporting']")
    WebElement reportingMainMenu;

    @FindBy(xpath = "//a[normalize-space()='Invoices']")
    WebElement invoicesSubMenu;

    public WebElement getReportingMainMenu() {
        return reportingMainMenu;
    }

    public WebElement getInvoicesSubMenu() {
        return invoicesSubMenu;
    }
}
