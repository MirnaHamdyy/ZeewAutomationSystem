package eu.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Addons extends SuperAdminTemplate {

    WebDriver driver;

    public Addons(WebDriver driver1) {
        super(driver1);
        driver = driver1;
        PageFactory.initElements(driver1, this);
    }

    @FindBy(css = "div.box-header > a.btn.btn-primary.pull-right")
    WebElement addNewAddonsBtn;

    //Locator of the catgeory drop down list
    @FindBy(css = "#category_id")
    WebElement selectCategoryDropDown;

    @FindBy(id = "mainaddons_name")
    WebElement mainAddonNameInput;

    @FindBy(id = "mainaddons_mini_count")
    WebElement mainMinimumCountInput;

    @FindBy(id = "mainaddons_count")
    WebElement mainMaximumCountInput;

    @FindBy(id = "subaddons_name_0")
    WebElement subAddonNameInput;

    @FindBy(id = "subaddons_price_0")
    WebElement subAddonPriceInput;

    //Locator of the add new subaddon button
    @FindBy(css = "div.col-md-6.col-lg-2:nth-child(5) > a.btn.btn-success")
    WebElement addSubAddonBtn;

    @FindBy(id = "subaddons_name_1")
    WebElement secondSubAddonNameInput;

    @FindBy(id = "subaddons_price_1")
    WebElement secondSubAddonsPriceInput;

    @FindBy(css = "tr.odd a:nth-child(2) > i.fa.fa-pencil")
    WebElement editAddonIcon;

    //Locator of the edited main addon field
    @FindBy(css = "#mainaddons_name")
    WebElement editSubAddonName;

    //Locator of the submit button
    @FindBy(css = ".m-t-20:nth-child(3) > button.btn.btn-info.m-r-15:nth-child(1)")
    WebElement submitNewAddonsBtn;

    //Locator of the edit submit button
    @FindBy(css = ":nth-child(4) > button.btn.btn-info.m-r-15:nth-child(1)")
    WebElement editedSubmitBtn;

    @FindBy(css = "td:nth-child(6) a:nth-child(3) > i.fa.fa-trash-o")
    WebElement deleteIcon;

    @FindBy(xpath = "//span[normalize-space()='Store Management']")
    WebElement storeManagemenMainMenu;

    @FindBy(xpath = "//a[normalize-space()='Addons']")
    WebElement addonsSubMenu;


    public void setMainAddonNameInput(String strMainAddonName) {
        mainAddonNameInput.sendKeys(strMainAddonName);
    }

    public void setMainMinimumCount(String strMainMinimumAddonCount) {
        mainMinimumCountInput.sendKeys(strMainMinimumAddonCount);
    }

    public void setMainMaximumCountInput(String strMaximumAddonCount) {
        mainMaximumCountInput.sendKeys(strMaximumAddonCount);
    }

    public void setSubAddonNameInput(String strSubAddonName) {
        subAddonNameInput.sendKeys(strSubAddonName);
    }

    public void setSubAddonPriceInput(String strSubAddonPrice) {
        subAddonPriceInput.sendKeys(strSubAddonPrice);
    }

    public void setSecondSubAddonNameInput(String strSecondSubAddonName) {
        secondSubAddonNameInput.sendKeys(strSecondSubAddonName);
    }

    public void setSecondSubAddonsPriceInput(String strSecondSubAddonPrice) {
        secondSubAddonsPriceInput.sendKeys(strSecondSubAddonPrice);
    }

    public void setEditSubAddonName(String strEditSubAddonName) {
        editSubAddonName.sendKeys(strEditSubAddonName);
    }

    public WebElement getStoreManagemenMainMenu() {
        return storeManagemenMainMenu;
    }

    public WebElement getAddonsSubMenu() {
        return addonsSubMenu;
    }

    public WebElement getAddNewAddonsBtn() {
        return addNewAddonsBtn;
    }

    public WebElement getSelectCategoryDropDown() {
        return selectCategoryDropDown;
    }

    public WebElement getAddSubAddonBtn() {
        return addSubAddonBtn;
    }

    public WebElement getSubmitNewAddonsBtn() {
        return submitNewAddonsBtn;
    }

    public WebElement getEditAddonIcon() {
        return editAddonIcon;
    }

    public WebElement getEditSubAddonName() {
        return editSubAddonName;
    }

    public WebElement getEditedSubmitBtn() {
        return editedSubmitBtn;
    }

    public WebElement getDeleteAddonIcon() {
        return deleteIcon;
    }

    //Get the location by index of the management store and the addons
    public void clickMenuItem() throws InterruptedException {
        getStoreManagemenMainMenu().click();
        Thread.sleep(5000);
        Actions action = new Actions(driver);
        action.moveToElement(getAddonsSubMenu());
        action.perform();
        getAddonsSubMenu().click();

    }
}
