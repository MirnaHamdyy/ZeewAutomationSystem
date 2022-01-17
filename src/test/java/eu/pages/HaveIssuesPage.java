package eu.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HaveIssuesPage extends SuperAdminTemplate {

    WebDriver driver;

    public HaveIssuesPage(WebDriver driver1) {
        super(driver1);
        driver = driver1;
        PageFactory.initElements(driver1, this);
    }

    @FindBy(xpath = "//body/div/aside/section/ul[@data-widget='tree']/li[4]/a[1]")
    WebElement ordersMainMenu;

    //body/div[1]/aside[1]/section[1]/ul[1]/li[4]/ul[1]/li/a/span[contains(text(),'Have Issues')]")).getText()
    @FindBy(xpath = "//a[@href='https://automated-store.deliveryscripts.com/superadmin/orders/reported']")
    WebElement haveIssuesSubMenu;

    public WebElement getOrdersMainMenu() {
        return ordersMainMenu;
    }

    public WebElement getHaveIssuesSubMenu() {
        return haveIssuesSubMenu;
    }
}
