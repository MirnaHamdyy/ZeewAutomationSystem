package eu.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import javax.xml.xpath.XPath;

import static eu.zeewscript.SeleniumUtility.PropertiesFile.getPropertyValue;
//All Signup Web Elements of the AUT and the method that operate on these Web Elements are maintained inside a class file

public class ZeewRegisteration {

    WebDriver driver;

    public void openPage() {
        driver.get("https://saasdev.deliveryscripts.com/signup");
    }

    public ZeewRegisteration(WebDriver driver1) {
        driver = driver1;
        PageFactory.initElements(driver1, this);
    }

    @FindBy(id = "first-name")
    WebElement firstNameInput;

    @FindBy(id = "last-name")
    WebElement lastNameInput;

    @FindBy(id = "phone-number")
    WebElement phoneNumberInput;

    //Email
    @FindBy(id = "username")
    WebElement emailInput;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(id = "password-confirm")
    WebElement passwordConfirmInput;

    @FindBy(id = "remove_color1")
    WebElement storeTypeSelect;

    @FindBy(id = "store-name")
    WebElement platformNameInput;

    @FindBy(id = "store-email")
    WebElement storeEmailInput;

    @FindBy(id = "address")
    WebElement addressInput;

    @FindBy(id = "is_agree")
    WebElement isAgreeCheckbox;

    @FindBy(css = "div.form-group.col-md-12:nth-child(12) > button.submit_btn")
    WebElement createYourBtn;


    public WebDriver getDriver() {
        return driver;
    }


    public WebElement getIsAgreeCheckbox() {
        return isAgreeCheckbox;
    }

    public WebElement getCreateYourBtn() {
        return createYourBtn;
    }

    // This method is to set the first name in the First Name field
    public void setFirstNameInput(String strFirstName) {
        firstNameInput.sendKeys(strFirstName);
    }

    // This method is to set the last name in the Last Name field
    public void setLastNameInput(String strLastName) {
        lastNameInput.sendKeys(strLastName);
    }

    // This method is to set the phone number in the Phone Number field
    public void setPhoneNumberInput(String strPhoneNumber) {
        phoneNumberInput.sendKeys(strPhoneNumber);
    }

    public void setEmailInput(String strEmail) {
        emailInput.sendKeys(strEmail);
    }

    // This method is to set the password in the Password field
    public void setPasswordInput(String strPassword) {
        passwordInput.sendKeys(strPassword);
    }

    // This method is to set the confirm password in the Confirm Password field
    public void setPasswordConfirmInput(String strPasswordConfirm) {
        passwordConfirmInput.sendKeys(strPasswordConfirm);
    }

//    // This method is to select store type from the select Store Type drop down list
//    public void setStoreTypeSelect(int storeIndexType) {
//        //The 'Select' class in Selenium WebDriver is used for selecting and deselecting option in a dropdown.
//        //The objects of Select type can be initialized by passing the dropdown webElement as parameter to its constructor.
//        Select storeSelect = new Select(storeTypeSelect);
//        storeSelect.selectByIndex(storeIndexType);
//    }

    public void setPlatformNameInput(String strPlatformName) {
        platformNameInput.sendKeys(strPlatformName);
    }

    public void setAddressInput(String strAddress) {
        addressInput.sendKeys(strAddress);
    }

    public WebElement getAddressInput() {
        return addressInput;
    }

    public void selectAddressOption() throws InterruptedException {
        setAddressInput(getPropertyValue("address"));
        WebDriverWait wait = new WebDriverWait(driver, 20); // seconds
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".pac-container")));
        getAddressInput().sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(2000);
        getAddressInput().sendKeys(Keys.ENTER);
        Thread.sleep(2000);
    }


}
