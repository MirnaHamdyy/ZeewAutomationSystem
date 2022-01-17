package eu.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CuisinePage extends SuperAdminTemplate {

    WebDriver driver;

    public CuisinePage(WebDriver driver1) {
        super(driver1);
        driver = driver1;
        PageFactory.initElements(driver1, this);
    }

    @FindBy(xpath = "//span[normalize-space()='Store Management']")
    WebElement storeManagementMainMenu;

    @FindBy(xpath = "//a[normalize-space()='Cuisines']")
    WebElement cuisineSubMenu;

    //Locator of the add new cuisine button
    @FindBy(css = "div.box.my-box div.box-header > a.btn.btn-primary.pull-right")
    WebElement addNewCuisineBtn;

    //Locate of the new cuisine name field
    @FindBy(id = "cuisine_name")
    WebElement cuisineNameInput;

    //Locate the submit button
    @FindBy(css = ":nth-child(5) > button.btn.btn-info.m-r-15:nth-child(1)")
    WebElement submitBtn;

    //Locator the edit icon of the cuisine
    @FindBy(css = "tr.odd:nth-child(1) td:nth-child(5) a:nth-child(1) > i.fa.fa-pencil")
    WebElement editCuisineIcon;

    //Locator of the edited cuisine name field
    @FindBy(css = "#cuisine_name")
    WebElement editCuisineNameInput;

    //Locator of the delete icon
    @FindBy(css = "tr.odd:nth-child(1) td:nth-child(5) a:nth-child(2) > i.fa.fa-trash-o")
    WebElement deleteCuisineIcon;

    public void setCuisineNameInput(String strCuisineName) {
        cuisineNameInput.sendKeys(strCuisineName);
    }

    public void setEditCuisineNameInput(String strEditCuisineName) {
        editCuisineNameInput.sendKeys(strEditCuisineName);
    }

    public WebElement getStoreManagementMainMenu() {
        return storeManagementMainMenu;
    }

    public WebElement getCuisineSubMenu() {
        return cuisineSubMenu;
    }

    public WebElement getAddNewCuisineBtn() {
        return addNewCuisineBtn;
    }

    public WebElement getSubmitBtn() {
        return submitBtn;
    }

    public WebElement getEditCuisineIcon() {
        return editCuisineIcon;
    }

    public WebElement getEditCuisineNameInput() {
        return editCuisineNameInput;
    }

    public WebElement getDeleteCuisineIcon() {
        return deleteCuisineIcon;
    }

}
