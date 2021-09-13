package eu.pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static eu.zeewscript.SeleniumUtility.PropertiesFile.getPropertyValue;

public class RestaurantPage extends SuperAdminTemplate {

    WebDriver driver;

    public RestaurantPage(WebDriver driver1) {
        super(driver1);
        driver = driver1;
        PageFactory.initElements(driver1, this);
    }

    //The locator of Add new store button
    @FindBy(css = "a.btn.btn-primary.pull-right:nth-child(2)")
    WebElement addNewBtn;

    @FindBy(css = "tr.odd:nth-child(1) a:nth-child(2) > i.fa.fa-pencil")
    WebElement restaurantEditedIcon;

    @FindBy(css = "tr.odd:nth-child(1) a:nth-child(3) > i.fa.fa-trash-o")
    WebElement deleteRestaurantIcon;


    //below four fields are in the Contact Info tab
    @FindBy(id = "contact_name")
    WebElement contactNameInput;

    @FindBy(id = "contact_phone")
    WebElement contactPhoneInput;

    @FindBy(id = "contact_email")
    WebElement contactEmailInput;

    @FindBy(id = "contact_address")
    WebElement addressInput;

    ///// Locators in the restaurant info page
    @FindBy(id = "restaurantInfo")
    WebElement restaurantInfoTab;

    @FindBy(id = "restaurant_name")
    WebElement restaurantNameInput;

    @FindBy(css = "#restaurant_name")
    WebElement restaurantEditName;

    @FindBy(id = "restaurant_phone")
    WebElement restaurantPhoneInput;

    @FindBy(id = "city-id")
    WebElement restaurantCitySelect;

    @FindBy(id = "restaurant_logo")
    WebElement restaurantLogoUpload;

    @FindBy(id = "restaurant_header_image")
    WebElement restaurantHeaderImageUpload;

    //////////////////////// Locators of week days
    //Locator of the Monday right slider
    @FindBy(xpath = "//*[@id=\"monday_first\"]/span[2]")
    WebElement mondayslot1RightSlider;

    //Locator of the Monday left slider
    @FindBy(xpath = "//*[@id=\"monday_first\"]/span[1]")
    WebElement mondayslot1LeftSilder;

    @FindBy(xpath = "//*[@id=\"tuesday_first\"]/span[1]")
    WebElement tuesdaySlot1LeftSlider;

    @FindBy(xpath = "//*[@id=\"tuesday_first\"]/span[2]")
    WebElement tuesdaySlot1RightSlider;

    @FindBy(xpath = "//*[@id=\"wednesday_first\"]/span[1]")
    WebElement wednesdaySlot1LeftSlider;

    @FindBy(xpath = "//*[@id=\"wednesday_first\"]/span[2]")
    WebElement wednesdaySlot1RightSlider;

    @FindBy(xpath = "//*[@id=\"thursday_first\"]/span[1]")
    WebElement thursdaySlot1LeftSlider;

    @FindBy(xpath = "//*[@id=\"thursday_first\"]/span[2]")
    WebElement thursdaySlot1RightSlider;

    @FindBy(xpath = "//*[@id=\"friday_first\"]/span[1]")
    WebElement fridaySlot1LeftSlider;

    @FindBy(xpath = "//*[@id=\"friday_first\"]/span[2]")
    WebElement fridaySlot1RightSlider;

    @FindBy(xpath = "//*[@id=\"saturday_first\"]/span[1]")
    WebElement saturdaySlot1LeftSlider;

    @FindBy(xpath = "//*[@id=\"saturday_first\"]/span[2]")
    WebElement saturdauSlot1RightSlider;

    @FindBy(id = "sunday_status")
    WebElement sundayStatus;

    @FindBy(xpath = "//*[@id=\"tab_2\"]/div/div[12]/div[1]")
    WebElement sundaySlot1;

    @FindBy(xpath = "//*[@id=\"restaurant_cuisine\"]/option[1]")
    WebElement firstCuisineItemSelect;

    @FindBy(xpath = "//*[@id=\"restaurant_cuisine\"]/option[2]")
    WebElement secondCuisineItemSelect;

    @FindBy(id = "restaurant_cuisine")
    WebElement restaurantCuisineSelect;

    @FindBy(id = "username")
    WebElement restaurantEmailInput;

    /////////Locators of the Delivery info page
    @FindBy(id = "deliveryInfo")
    WebElement deliveryInfoTab;

    @FindBy(id = "estimate_time")
    WebElement estimateTimeInput;

    @FindBy(id = "minimum_order")
    WebElement minimumOrderInput;

    @FindBy(id = "free_delivery")
    WebElement freeDeliveryInput;

    @FindBy(id = "free_delivery_charge")
    WebElement freeDeliveryChargeToCourierInput;

    @FindBy(id = "radius_0")
    WebElement kiloMeterRadiusInput;

    @FindBy(xpath = "//*[@id=\"radius_settings_0\"]/div[1]/div[2]")
    WebElement generateRadiusCursor;

    @FindBy(id = "deliveryChargeId_0")
    WebElement priceOfKiloMeterInput;

    ///////////OrderInfo Tab
    @FindBy(id = "orderInfo")
    WebElement orderInfoTab;

    ///////////Commision Tab
    @FindBy(id = "commissionInfo")
    WebElement commisionInfoTab;

    ///////////paymentInfo Tab
    @FindBy(id = "paymentInfo")
    WebElement PaymentMethodsTab;

    ///////////InvoicePeriod Tab
    @FindBy(id = "invoiceInfo")
    WebElement invoiceTab;

    ///////////MetaTag Tab
    @FindBy(css = "a[href='#tab_8']")
    WebElement metaTagTab;

    ////////////Promoions Tab
    @FindBy(css="a[href='#tab_9']")
    WebElement promoionsTab;

    ////////////RewardPoints Tab
    @FindBy(css="a[href='#tab_10']")
    WebElement rewardPointsTab;

    ////////////BankInfo Tab
    @FindBy(id="bankInfo")
    WebElement bankInfoTab;


    ///////////Locators of all fields in bank info form
    @FindBy(id = "bank_name")
    WebElement bankNameInput;

    @FindBy(id = "account_number")
    WebElement accountNumberInput;

    @FindBy(id = "swiftcode")
    WebElement swiftCodeInput;

    @FindBy(id = "bank_address")
    WebElement bankAddressInput;

    @FindBy(css = "button.btn.btn-info.m-r-15:nth-child(1)")
    WebElement submitRestaurantBtn;

    @FindBy(css = "button.btn.btn-info.m-r-15:nth-child(1)")
    WebElement submitEditedRestaurantName;

    ////Contact Info
    public void setContactNameInputText(String strContactName) {
        contactNameInput.sendKeys(strContactName);
    }

    public void setContactPhoneInputText(String strContactPhone) {
        contactPhoneInput.sendKeys(strContactPhone);
    }

    public void setContactEmailInputText(String strContactEmail) {
        contactEmailInput.sendKeys(strContactEmail);
    }

    public void setAddressInputText(String strAddress) {
        addressInput.sendKeys(strAddress);
    }

    ////Restaurant Info
    public void setRestaurantNameInputText(String strRestaurantNameInput) {
        restaurantNameInput.sendKeys(strRestaurantNameInput);
    }

    public void setRestaurantNameEditedInputText(String strRestaurantEditedNameInput) {
        restaurantEditName.sendKeys(strRestaurantEditedNameInput);
    }

    public void setRestaurantPhoneInputText(String strRestaurantPhoneInput) {
        restaurantPhoneInput.sendKeys(strRestaurantPhoneInput);
    }

    public void setRestauranLogoUploadImage(String strRestauranLogoUploadImage) {
        restaurantLogoUpload.sendKeys(strRestauranLogoUploadImage);
    }

    public void setRestauranHeaderUploadImage(String strRestauranHeaderSelectImage) {
        restaurantHeaderImageUpload.sendKeys(strRestauranHeaderSelectImage);
    }

    public void setRestauranEmailInputText(String strRestaurantEmailInput) {
        restaurantEmailInput.sendKeys(strRestaurantEmailInput);
    }

    ////Delivery Info
    public void setEstimateTimeInputNumber(String strEstimateTimeInputNumber) {
        estimateTimeInput.sendKeys(strEstimateTimeInputNumber);
    }

    public void setMinimumOrderInputNumber(String strMinimumOrderInputNumber) {
        minimumOrderInput.sendKeys(strMinimumOrderInputNumber);
    }

    public void setFreeDeliveryInputNumber(String strFreeDeliveryInput) {
        freeDeliveryInput.sendKeys(strFreeDeliveryInput);
    }

    public void setFreeDeliveryChargeToCourierInputNumber(String strFreeDeliveryChargeInput) {
        freeDeliveryChargeToCourierInput.sendKeys(strFreeDeliveryChargeInput);
    }

    public void setKiloMeterRadiusInputNumber(String strKiloMeterRadiusInputNumber) {
        kiloMeterRadiusInput.sendKeys(strKiloMeterRadiusInputNumber);
    }

    public void setPriceOfKiloMeterInputNumber(String strKiloMeterRadiusInput) {
        priceOfKiloMeterInput.sendKeys(strKiloMeterRadiusInput);
    }

    ////Bank Info
    public void setBankNameInputText(String strBankNameInput) {
        bankNameInput.sendKeys(strBankNameInput);
    }

    public void setAccountNumberInputText(String strAccountNumberInput) {
        accountNumberInput.sendKeys(strAccountNumberInput);
    }

    public void setSwiftCodeInputText(String strSwiftCodeInput) {
        swiftCodeInput.sendKeys(strSwiftCodeInput);
    }

    public void setBankAddressInputText(String strBankAddressInput) {
        bankAddressInput.sendKeys(strBankAddressInput);
    }


    /////////////
    public WebElement getAddNewBtn() {
        return addNewBtn;
    }

    public WebElement getRestaurantEditedIcon() {
        return restaurantEditedIcon;
    } //restaurantEditedName

    public WebElement getDeleteRestaurantIcon() {
        return deleteRestaurantIcon;
    }

    public WebElement getRestaurantEditName() {
        return restaurantEditName;
    }

    public WebElement getAddressInputText() {
        return addressInput;
    }

    public WebElement getRestaurantInfo() {
        return restaurantInfoTab;
    }

    public WebElement getRestaurantInfoTab() {
        return restaurantInfoTab;
    }

    public WebElement getDeliveryInfoTab() {
        return deliveryInfoTab;
    }

    public WebElement getOrderInfoTab() {
        return orderInfoTab;
    }

    public WebElement getCommisionInfoTab() {
        return commisionInfoTab;
    }

    public WebElement getPaymentMethodsTab() {
        return PaymentMethodsTab;
    }

    public WebElement getInvoiceTab() {
        return invoiceTab;
    }

    public WebElement getMetaTagTab() {
        return metaTagTab;
    }

    public WebElement getPromoionsTab() {
        return promoionsTab;
    }

    public WebElement getRewardPointsTab() {
        return rewardPointsTab;
    }

    public WebElement getBankInfoTab() {
        return bankInfoTab;
    }

    public WebElement getGenerateRadiusCursor() {
        return generateRadiusCursor;
    }

    public WebElement getSubmitRestaurantBtn() {
        return submitRestaurantBtn;
    }

    public WebElement getSubmitEditedRestaurantName() {
        return submitEditedRestaurantName;
    }

    public void clickMenuItem() {
        clickLeftSubMenuItemByIndex(29, 30);
    }

    //Select the address
    public void selectAddressOption() {
        setAddressInputText(getPropertyValue("restaurantAddress"));
        WebDriverWait wait = new WebDriverWait(driver, 20); // seconds
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".pac-container")));
        getAddressInputText().sendKeys(Keys.ARROW_DOWN);
        getAddressInputText().sendKeys(Keys.ENTER);
    }

    public void selectRestaurantCity() {
        //Declare the drop-down element "drpRestaurantCity" as an instance of the Select class.
        Select drpRetaurantCity = new Select(restaurantCitySelect);
        drpRetaurantCity.selectByVisibleText("Riga");
    }

    //Manage opening and closing the retsaurant working hours
    public void manageRestaurantWorkingHours() throws InterruptedException {

        //Use the Action class to build the list of actions to be done ont he slider
        Actions actions = new Actions(driver);
        //Move to the slider, click, perform drag and drop, to the left and right to manage restaurant working hours
        ////Use the coordinates chrome extension to get the x and y of the slider icon, x axis is in negative to the move left side

        actions.dragAndDropBy(mondayslot1LeftSilder, -488, 0).release().build().perform();
        mondayslot1LeftSilder.click();

        actions.dragAndDropBy(mondayslot1RightSlider, 744, 0).release().build().perform();
        mondayslot1RightSlider.click();

        actions.dragAndDropBy(tuesdaySlot1LeftSlider, -536, 0).release().build().perform();
        tuesdaySlot1LeftSlider.click();

        actions.dragAndDropBy(tuesdaySlot1RightSlider, 750, 0).release().build().perform();
        tuesdaySlot1RightSlider.click();

        actions.dragAndDropBy(wednesdaySlot1LeftSlider, -483, 0).release().build().perform();
        wednesdaySlot1LeftSlider.click();

        actions.dragAndDropBy(wednesdaySlot1RightSlider, 755, 0).release().build().perform();
        wednesdaySlot1RightSlider.click();

        //Scroll until the category appears
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        WebElement sundayText = driver.findElement(By.id("sunday_first"));
        jsExecutor.executeScript("arguments[0].scrollIntoView();", sundayText);

        actions.dragAndDropBy(thursdaySlot1LeftSlider, -480, 0).release().build().perform();
        thursdaySlot1LeftSlider.click();

        actions.dragAndDropBy(thursdaySlot1RightSlider, 750, 0).release().build().perform();
        thursdaySlot1RightSlider.click();

        actions.dragAndDropBy(fridaySlot1LeftSlider, -480, 0).release().build().perform();
        fridaySlot1LeftSlider.click();

        actions.dragAndDropBy(fridaySlot1RightSlider, 744, 0).release().build().perform();
        fridaySlot1RightSlider.click();

        actions.dragAndDropBy(saturdaySlot1LeftSlider, -480, 0).release().build().perform();
        saturdaySlot1LeftSlider.click();

        actions.dragAndDropBy(saturdauSlot1RightSlider, 744, 0).release().build().perform();
        saturdauSlot1RightSlider.click();
    }

    //Check is sunday is open, close it otherwise leave it closed
    public void checkAndClickOnRestaurantOpeningDayStatus() {
        if (sundaySlot1.getAttribute("class").contains("closed_mask closed")) {
            return;
        } else
            sundayStatus.click();
    }

    //while creating the store, select multiple cuisine items
    //from the cuisine list in the restaurant info tab
    public void selectCuisineForRestaurant() {

        Select select = new Select(restaurantCuisineSelect);
        Actions actions = new Actions(driver);
        //simulates a keyboard action when a specific keyboard key needs to press then perform specific action
        //keyDown() method to keep the key pressed
        actions.keyDown(Keys.CONTROL)
                .click(firstCuisineItemSelect)
                .click(secondCuisineItemSelect)
                .click(select.getOptions().get(2))
                .click(select.getOptions().get(3))
                .click(select.getOptions().get(4))
                //keyUp(): We use this method majorly in collaboration with the keyDown() method.
                .keyUp(Keys.CONTROL);
        actions.build().perform();

    }


}


