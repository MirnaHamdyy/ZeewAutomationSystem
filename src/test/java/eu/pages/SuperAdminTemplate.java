package eu.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SuperAdminTemplate {
    WebDriver driver;

    public SuperAdminTemplate(WebDriver driver1) {
        driver = driver1;
        PageFactory.initElements(driver1, this);
    }

    public void clickLeftMenuItemByIndex(int index) {
        List<WebElement> elements = driver
                .findElements(By.cssSelector("ul.sidebar-menu.tree li"));

        new Actions(driver).moveToElement(elements.get(index)).click().perform();
    }

    public void clickLeftSubMenuItemByIndex(int parentIndex, int subMenuItemIndex) {
        clickLeftMenuItemByIndex(parentIndex);
        clickLeftMenuItemByIndex(subMenuItemIndex);
    }


}
