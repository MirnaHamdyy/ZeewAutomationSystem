package eu.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoryPage {

    WebDriver driver;

    public CategoryPage(WebDriver driver1) {
        //  super(driver1);
        driver = driver1;
        PageFactory.initElements(driver1, this);
    }

    @FindBy(xpath = "//span[normalize-space()='Store Management']")
    WebElement storeManagementMainMenu;

    @FindBy(xpath = "//a[normalize-space()='Category']")
    WebElement categorySubMenu;

    //add the css of the add new category button
    @FindBy(css = "section.content.clearfix > div > div > div > div.box-header > a")
    WebElement addNewCategoryBtn;

    //Category name field
    @FindBy(id = "category_name")
    WebElement categoryNameInput;

    @FindBy(id = "categoryImage")
    WebElement chooseImageInput;

    //Submit button to add a new category
    @FindBy(css = "#catAddEditForm > div.col-xs-12.no-padding.m-t-20 > button")
    WebElement categorySubmitBtn;

    //Edit category icon
    @FindBy(css = "tbody tr:nth-child(1) td:nth-child(7) a:nth-child(2) i:nth-child(1)")
    WebElement editCategoryIcon;

    //get the category name field which will be edited
    @FindBy(id= "category_name")
    WebElement editCategoryNameInput;

    //Submit button of edit category
    @FindBy(css= ".no-padding.m-t-20:nth-child(5) > button.btn.btn-info.m-r-15:nth-child(1)")
    WebElement submitEditedCategoryBtn;

    //Delete category icon
    @FindBy(css = "tr:nth-child(1) > td:nth-child(7) > a:nth-child(3)")
    WebElement deleteCategoryIcon;


    public void setCategoryNameInput(String strCategoryName) {
        categoryNameInput.sendKeys(strCategoryName);
    }

    public void setEditCategoryNameInput(String strEditCategoryName) {
        editCategoryNameInput.sendKeys(strEditCategoryName);
    }

    public WebElement getStoreManagementMainMenu() {
        return storeManagementMainMenu;
    }

    public WebElement getCategorySubMenu() {
        return categorySubMenu;
    }

    public WebElement getAddNewCategoryBtn() {
        return addNewCategoryBtn;
    }

    public WebElement getCategorySubmitBtn() {
        return categorySubmitBtn;
    }

    public WebElement getEditCategoryIcon() {
        return editCategoryIcon;
    }

    public WebElement getEditCategoryNameInput() {
        return editCategoryNameInput;
    }

    public WebElement getSubmitEditedCategoryBtn() {
        return submitEditedCategoryBtn;
    }

    public WebElement getDeleteCategoryIcon() {
        return deleteCategoryIcon;
    }

    //Get the index "locator" of the managament store and category"
//        public void clickMenuItem(){
//            clickLeftSubMenuItemByIndex(29, 32);
//        }
}
