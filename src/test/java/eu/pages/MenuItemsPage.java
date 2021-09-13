package eu.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuItemsPage extends SuperAdminTemplate {

    WebDriver driver;

    public MenuItemsPage(WebDriver driver1) {
        super(driver1);
        driver = driver1;
        PageFactory.initElements(driver1, this);
    }

    //Locator of the drop down from the restaurant
    @FindBy(id = "restaurant_id")
    WebElement selectRestaurantDrpDown;

    @FindBy(css = ".menu-icon-box:nth-child(1) :nth-child(4) .add-btn > a:nth-child(1)")
    WebElement addCategoryBtn;

    @FindBy(css = ".select2-container")
    WebElement selectCategoryDrpDown;

    @FindBy(css = ".select2-search--dropdown > input.select2-search__field")
    WebElement selectCategoryInput;

    @FindBy(css = "div.modal.fade.in:nth-child(10) div.modal-content:nth-child(2) div.modal-footer > button.btn.btn-primary:nth-child(2)")
    WebElement saveSelectedCategoryBtn;

    @FindBy (css=".select2-results__option--highlighted")
    WebElement highlightedCategoryForRestaurantSelected;

    @FindBy (id = "categories")
    WebElement categoryListInManageMenuPage;

    ////a[normalize-space()='ADD ITEM']
    @FindBy(xpath = "//a[normalize-space()='ADD ITEM']")
    WebElement AddMenuBtn;

    @FindBy(id= "menu_name")
    WebElement menuNameInput;

    @FindBy(id="menuImage")
    WebElement menuImageUplaod;

    @FindBy(css="#menu_price")
    WebElement menuPriceImput;

    @FindBy(id="addMenuSubmitBtn")
    WebElement submitMenuBtn;


    public void setSelectCategoryInputText(String strSelectCategoryInput) {
        selectCategoryInput.sendKeys(strSelectCategoryInput);
    }

    public void setAddCategoryBtn(WebElement addCategoryBtn) {
        this.addCategoryBtn = addCategoryBtn;
    }

    public void setMenuNameInput(String strMenuNameInput) {
      menuNameInput.sendKeys(strMenuNameInput);
    }

    public void setMenuPriceInput(String strMenuPriceInput) {
        menuPriceImput.sendKeys(strMenuPriceInput);
    }

    public void setMenuImageUplaod(String strMenuImageUpload) {
       menuImageUplaod.sendKeys(strMenuImageUpload);
    }

    public WebElement getSelectRestaurantDrpDown() {
        return selectRestaurantDrpDown;
    }

    public WebElement getAddCategoryBtn() {
        return addCategoryBtn;
    }

    public WebElement getSelectCategoryDrpDown() {
        return selectCategoryDrpDown;
    }


    public WebElement getHighlightedCategoryForRestaurantSelected() {
        return highlightedCategoryForRestaurantSelected;
    }

    public WebElement getCategoryListInManageMenuPage() {
        return categoryListInManageMenuPage;
    }

    public WebElement getSaveSelectedCategoryBtn() {
        return saveSelectedCategoryBtn;
    }

    public WebElement getAddMenuBtn() {
        return AddMenuBtn;
    }

    public WebElement getSubmitMenuBtn() {
        return submitMenuBtn;
    }

    public void clickMenuItem() {
        clickLeftSubMenuItemByIndex(29, 31);
    }

//    public void selectCategoryForRestaurant() {
//        CategoryTest categoryTest=new CategoryTest();
//        //Declare the drop-down element "drpRestaurantCity" as an instance of the Select class.
//        Select drpCategory = new Select(selectCategoryDrpDown);
//        drpCategory.selectByVisibleText(categoryTest.getNewCategoryName());
//    }

}
