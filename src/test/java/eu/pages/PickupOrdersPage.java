package eu.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PickupOrdersPage extends SuperAdminTemplate {

    WebDriver driver;

    public PickupOrdersPage(WebDriver driver1) {
        super(driver1);
        driver = driver1;
        PageFactory.initElements(driver1, this);
    }

    @FindBy(xpath = "//body/div/aside/section/ul[@data-widget='tree']/li[4]/a[1]")
    WebElement ordersMainMenu;

    @FindBy(xpath = "//a[@href='https://automated-store.deliveryscripts.com/superadmin/orders/collectionorder']")
    WebElement pickupSubMenu;

    public WebElement getOrdersMainMenu() {
        return ordersMainMenu;
    }

    public WebElement getPickupSubMenu() {
        return pickupSubMenu;
    }
}
