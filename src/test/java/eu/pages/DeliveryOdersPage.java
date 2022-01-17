package eu.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeliveryOdersPage extends SuperAdminTemplate {

    WebDriver driver;

    public DeliveryOdersPage(WebDriver driver1) {
        super(driver1);
        driver = driver1;
        PageFactory.initElements(driver1, this);
    }

    @FindBy(xpath = "//body/div/aside/section/ul[@data-widget='tree']/li[4]/a[1]")
    WebElement ordersMainMenu;

    @FindBy(xpath = "//li[@id='3']//a[@class='sidebar-link']")
    WebElement deliveryOrderSubMenu;


    public WebDriver getDriver() {
        return driver;
    }

    public WebElement getOrdersMainMenu() {
        return ordersMainMenu;
    }

    public WebElement getDeliveryOrderSubMenu() {
        return deliveryOrderSubMenu;
    }
}
