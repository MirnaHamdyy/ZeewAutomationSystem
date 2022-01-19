package eu.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StoreOffersPage extends SuperAdminTemplate {

    WebDriver driver;

    public StoreOffersPage(WebDriver driver1) {
        super(driver1);
        driver = driver1;
        PageFactory.initElements(driver1, this);
    }

    @FindBy(xpath = "//span[normalize-space()='Promotions']")
    WebElement promotionsMainMenu;

    @FindBy(xpath = "//a[normalize-space()='Store Offers']")
    WebElement storeOffersSubMenu;

    @FindBy(css = "div.box-header > a.btn.btn-primary.pull-right")
    WebElement addNewOfferBtn;

    //Select a store drop down menu location
    @FindBy(id = "restaurant_id")
    WebElement storeNameSelect;

    //Select offer type radio box
    @FindBy(css = "div[class='iradio_minimal-blue checked'] ins[class='iCheck-helper']")
    WebElement offerTypeCheck;

    @FindBy(id = "normal_price")
    WebElement minimumOrderValueInput;

    @FindBy(id = "normal_percentage")
    WebElement offerPercentageInput;

    @FindBy(css = "#offer_from")
    WebElement fromDatePicker;


    @FindBy(css = "#offer_to")
    WebElement toDataPicker;

    @FindBy(css = "button[type='button']")
    WebElement submitBtn;

    public void setFromDatePicker(String strFromDate) {
        fromDatePicker.sendKeys(strFromDate);
    }

    public void setToDataPicker(String strToDate) {
        toDataPicker.sendKeys(strToDate);
    }

    public WebElement getPromotionsMainMenu() {
        return promotionsMainMenu;
    }

    public WebElement getStoreOffersSubMenu() {
        return storeOffersSubMenu;
    }

    public WebElement getStoreNameSelect() {
        return storeNameSelect;
    }

    public WebElement getFromDatePicker() {
        return fromDatePicker;
    }

    public WebElement getToDataPicker() {
        return toDataPicker;
    }

    public WebElement getAddNewOfferBtn() {
        return addNewOfferBtn;
    }


}
