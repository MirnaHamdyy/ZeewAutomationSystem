package eu.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RewardsPage extends SuperAdminTemplate {

    WebDriver driver;

    @FindBy(xpath = "//span[normalize-space()='Promotions']")
    WebElement promotionsMainMenu;
    @FindBy(xpath = "//a[normalize-space()='Rewards']")
    WebElement rewardsSubMenu;

    public RewardsPage(WebDriver driver1) {
        super(driver1);
        driver = driver1;
        PageFactory.initElements(driver1, this);
    }

    public WebElement getPromotionsMainMenu() {
        return promotionsMainMenu;
    }

    public WebElement getRewardsSubMenu() {
        return rewardsSubMenu;
    }
}
