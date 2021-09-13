package eu.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SuperadminLogin {

    WebDriver driver;

    public SuperadminLogin(WebDriver driver2) {
        driver = driver2;
        PageFactory.initElements(driver2, this);
    }


    //Subscriber Super admin email field element
    @FindBy(id= "username")
    private WebElement emailInput;

    //Subscriber Super admin password
    @FindBy(id= "password")
    private WebElement passwordInput;

    //Login button element
    @FindBy(css= ".has-feedback.clearfix:nth-child(3) > button.btn.btn-primary.btn-block.btn-flat")
    private WebElement SignInButton;


    public void setEmailInput(String strEmailInput) {
        emailInput.sendKeys(strEmailInput);
    }

    public void setPasswordInput(String strPasswordInput) {
        passwordInput.sendKeys(strPasswordInput);
    }

    public WebElement getSignInButton() {
        return SignInButton;
    }

}
