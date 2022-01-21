package eu.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GlobalSettingsDeliveryZonePage extends SuperAdminTemplate {
    WebDriver driver;

    @FindBy(xpath = "//span[normalize-space()='Global Settings']")
    WebElement globalSettingsMenu;

    @FindBy(xpath = "//a[normalize-space()='Delivery Zones']")
    WebElement deliveryZonesSubMenu;

    public GlobalSettingsDeliveryZonePage(WebDriver driver1) {
        super(driver1);
        driver = driver1;
        PageFactory.initElements(driver1, this);
    }

    public WebElement getGlobalSettingsMenu() {
        return globalSettingsMenu;
    }

    public WebElement getDeliveryZonesSubMenu() {
        return deliveryZonesSubMenu;
    }
}
