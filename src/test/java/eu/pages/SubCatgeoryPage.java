package eu.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubCatgeoryPage {

    WebDriver driver;
    @FindBy(xpath = "//span[normalize-space()='Store Management']")
    WebElement storeManagementMainMenu;
    @FindBy(xpath = "//a[normalize-space()='Sub-Category']")
    WebElement subCatgeorySubMenu;
    @FindBy(css = "div.box-header > a.btn.btn-primary.pull-right")
    WebElement addSubCatgeoryBtn;
    @FindBy(xpath = "//input[@id='category_name']")
    WebElement categoryNameInput;
    @FindBy(xpath = "//button[normalize-space()='Submit']")
    WebElement submitBtn;
    @FindBy(css = "tr.odd:nth-child(1) td:nth-child(7) a:nth-child(1) > i.fa.fa-pencil")
    WebElement editSubcatgeoryIcon;
    @FindBy(css = "tr.odd:nth-child(1) td:nth-child(7) a:nth-child(2) > i.fa.fa-trash-o")
    WebElement deleteSubCatgeoryIcon;

    public SubCatgeoryPage(WebDriver driver1) {
        driver = driver1;
        PageFactory.initElements(driver1, this);

    }

    public WebElement getStoreManagementMainMenu() {
        return storeManagementMainMenu;
    }

    public WebElement getSubCatgeorySubMenu() {
        return subCatgeorySubMenu;
    }

    public WebElement getAddSubCatgeoryBtn() {
        return addSubCatgeoryBtn;
    }

    public WebElement getCategoryNameInput() {
        return categoryNameInput;
    }

    public void setCategoryNameInput(String strCategoryName) {
        categoryNameInput.sendKeys(strCategoryName);
    }

    public WebElement getSubmitBtn() {
        return submitBtn;
    }

    public WebElement getEditSubcatgeoryIcon() {
        return editSubcatgeoryIcon;
    }

    public WebElement getDeleteSubCatgeoryIcon() {
        return deleteSubCatgeoryIcon;
    }
}
