package eu.testcases;

import eu.pages.RestaurantPage;
import eu.zeewscript.SeleniumUtility.AbstractAcceptanceLoginBefore;
import org.apache.commons.lang3.RandomStringUtils;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static eu.zeewscript.SeleniumUtility.PropertiesFile.getPropertyValue;

public class RestaurantTest extends AbstractAcceptanceLoginBefore {

    String randomPart = RandomStringUtils.randomAlphabetic(3).toLowerCase();
    String restaurantName = String.format(getPropertyValue("restaurantName") + randomPart);
    String restaurantEmail = String.format(getPropertyValue("restaurantEmail") + randomPart);
    String restaurantEditedName = String.format(getPropertyValue("restaurantEditedName") + randomPart);
    String expectedStoreListPage = getPropertyValue("expectedStoreListURL");
    String expectedNewStoreFormURL = getPropertyValue("expectedNewStoreFormURL");

    public void clickMenuItem() {
        RestaurantPage restaurantPage = new RestaurantPage(driver);
        Actions actions = new Actions(driver);
        actions.moveToElement(restaurantPage.getStoreManagementMainMenu());
        restaurantPage.getStoreManagementMainMenu().click();
        actions.perform();
        actions.moveToElement(restaurantPage.getManageStoreSubMenu());
        restaurantPage.getManageStoreSubMenu().click();
        actions.perform();
    }

    public void shareRestaurantCreation(WebDriver driver) throws InterruptedException {
        RestaurantPage restaurantPage = new RestaurantPage(driver);
        restaurantPage.getAddNewBtn().click();
        randomPart = RandomStringUtils.randomAlphabetic(3).toLowerCase();
        restaurantName = String.format(getPropertyValue("restaurantName") + randomPart);
        restaurantEmail = String.format(getPropertyValue("restaurantEmail") + randomPart);
        Thread.sleep(5000);
        //Set all data in the contact info
        restaurantPage.setContactNameInputText(getPropertyValue("contactName"));
        restaurantPage.setContactPhoneInputText(getPropertyValue("contactPhone"));
        restaurantPage.setContactEmailInputText(getPropertyValue("contactEmail"));
        restaurantPage.selectAddressOption();
        //Set all data in the restaurant info
        restaurantPage.getRestaurantInfo().click();
        restaurantPage.setRestaurantNameInputText(restaurantName);
        restaurantPage.setRestaurantPhoneInputText(getPropertyValue("restaurantPhone"));
        restaurantPage.setRestauranLogoUploadImage(getPropertyValue("restaurantLogo"));
        restaurantPage.setRestauranHeaderUploadImage(getPropertyValue("restaurantHeader"));
        restaurantPage.selectRestaurantCity();
        restaurantPage.manageRestaurantWorkingHours();
        restaurantPage.checkAndClickOnRestaurantOpeningDayStatus();
        restaurantPage.selectCuisineForRestaurant();
        restaurantPage.setRestauranEmailInputText(restaurantEmail);

        //Set all data in the delivery info
        restaurantPage.getSubmitRestaurantBtn().click();
        restaurantPage.setEstimateTimeInputNumber(getPropertyValue("estimateTime"));
        restaurantPage.setMinimumOrderInputNumber(getPropertyValue("minimumOrder"));
        restaurantPage.setFreeDeliveryInputNumber(getPropertyValue("freeDelivery"));
        restaurantPage.setFreeDeliveryChargeToCourierInputNumber
                (getPropertyValue("freeDeliveryChargeToCourier"));
        restaurantPage.setKiloMeterRadiusInputNumber(getPropertyValue("kiloMeterRadius"));
        Thread.sleep(8000);
        restaurantPage.getGenerateRadiusCursor().click();
        Thread.sleep(8000);
        restaurantPage.setPriceOfKiloMeterInputNumber(getPropertyValue("kiloMeterRadiusPrice"));
        restaurantPage.getSubmitRestaurantBtn().click();

        restaurantPage.setBankNameInputText(getPropertyValue("bankName"));
        restaurantPage.setAccountNumberInputText(getPropertyValue("accountNumber"));
        restaurantPage.setSwiftCodeInputText(getPropertyValue("swiftCode"));
        restaurantPage.setBankAddressInputText(getPropertyValue("bankAddress"));
        restaurantPage.getSubmitRestaurantBtn().click();

    }

    public void enableDisabledRestaurant(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 30); // seconds
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#restaurantTable")));
        WebElement nextBtn = driver.findElement(By.cssSelector(".paginate_button.next a"));
        WebElement restaurantTable = driver.findElement(By.cssSelector("#restaurantTable"));
        while (nextBtn.isEnabled()) {
            restaurantTable = driver.findElement(By.cssSelector("#restaurantTable"));
            if (restaurantTable.getText().contains(restaurantName)) {
                WebElement tableCellWithNewRestaurantName = driver.findElement(By.xpath("//td[text()='" + restaurantName + "']"));
                WebElement tableRowWhereNewRestaurantLocated = tableCellWithNewRestaurantName.findElement(By.xpath("./.."));
                tableRowWhereNewRestaurantLocated.findElement(By.cssSelector("td[id^='status_'] button")).click();

                wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(
                        tableRowWhereNewRestaurantLocated,
                        By.cssSelector("td[id^='status_'] button i.fa-check")
                ));
                return;
            }
            nextBtn = driver.findElement(By.cssSelector(".paginate_button.next a"));
            nextBtn.click();
            //here you do something like update or save
            //then you define the button element again before you use it
            nextBtn = driver.findElement(By.cssSelector(".paginate_button.next a"));
        }
        Assertions.fail("New Restaurant never found in table");

    }

    @Test(priority = 1)
    public void openRestaurantsListPage() throws InterruptedException {
        clickMenuItem();
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, 5); // seconds
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("section.content-header > h1:nth-child(1)"), "Store"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedStoreListPage);
    }

    @Test(priority = 2)
    public void openAddNewRestaurantPage() throws InterruptedException {
        RestaurantPage restaurantPage = new RestaurantPage(driver);
        clickMenuItem();
        restaurantPage.getAddNewBtn().click();
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, 5); // seconds
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("section.content-header > h1:nth-child(1)"), "Add Store"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedNewStoreFormURL);
    }

    @Test(priority = 3)
    public void verifyOpeningRestaurantInfoTab() {
        RestaurantPage restaurantPage = new RestaurantPage(driver);
        clickMenuItem();
        restaurantPage.getAddNewBtn().click();
        restaurantPage.getRestaurantInfo().click();
        String actualEmailTextFieldString = driver.findElement(By.xpath("//body/div/div/section/div/div/div/form[@id='restaurantAdd']/div/div/div[@id='tab_2']/div/div[1]/label[1]")).getText();
        Assert.assertTrue(actualEmailTextFieldString.contains("Name"));
    }

    @Test(priority = 4)
    public void verifyOpeningDeliveryInfoTab() {
        RestaurantPage restaurantPage = new RestaurantPage(driver);
        clickMenuItem();
        restaurantPage.getAddNewBtn().click();
        restaurantPage.getDeliveryInfoTab().click();
        String actualFreeDeliveryTextFieldString = driver.findElement(By.xpath("//label[normalize-space()='Free Delivery']")).getText();
        Assert.assertTrue(actualFreeDeliveryTextFieldString.contains("Free Delivery"));
    }

    @Test(priority = 5)
    public void verifyOpeningOrderInfoTab() {
        RestaurantPage restaurantPage = new RestaurantPage(driver);
        clickMenuItem();
        restaurantPage.getAddNewBtn().click();
        restaurantPage.getOrderInfoTab().click();
        String actualEmailOrderTextFieldString = driver.findElement(By.xpath("//label[normalize-space()='Email Order']")).getText();
        Assert.assertTrue(actualEmailOrderTextFieldString.contains("Email Order"));
    }

    @Test(priority = 6)
    public void verifyOpeningCommissionInfoTab() {
        RestaurantPage restaurantPage = new RestaurantPage(driver);
        clickMenuItem();
        restaurantPage.getAddNewBtn().click();
        restaurantPage.getCommisionInfoTab().click();
        String actualPickupCommissionTextFieldString = driver.findElement(By.xpath("//div[@id='tab_5']//div[3]//label[1]")).getText();
        Assert.assertTrue(actualPickupCommissionTextFieldString.contains("Commission"));
    }

    @Test(priority = 7)
    public void verifyOpeningPaymentMethodTab() {
        RestaurantPage restaurantPage = new RestaurantPage(driver);
        clickMenuItem();
        restaurantPage.getAddNewBtn().click();
        restaurantPage.getPaymentMethodsTab().click();
        String actualStripeRadioBoxText = driver.findElement(By.xpath("//form[@id='restaurantAdd']/div/div/div[@id='tab_6']/div/div/label[1]")).getText();
        Assert.assertTrue(actualStripeRadioBoxText.contains("COD"));
    }

    @Test(priority = 8)
    public void verifyOpeningInvoicesTab() {
        RestaurantPage restaurantPage = new RestaurantPage(driver);
        clickMenuItem();
        restaurantPage.getAddNewBtn().click();
        restaurantPage.getInvoiceTab().click();
        String actualInvoicePeriodTextField = driver.findElement(By.xpath("//div[@id='tab_7']//div//div//label")).getText();
        Assert.assertTrue(actualInvoicePeriodTextField.contains("Invoice Period"));
    }

    @Test(priority = 9)
    public void verifyOpeningMetaTagTab() {
        RestaurantPage restaurantPage = new RestaurantPage(driver);
        clickMenuItem();
        restaurantPage.getAddNewBtn().click();
        restaurantPage.getMetaTagTab().click();
        String actualMetaTagTextField = driver.findElement(By.xpath("//label[normalize-space()='Meta Description']")).getText();
        Assert.assertTrue(actualMetaTagTextField.contains("Meta Description"));
    }

    @Test(priority = 10)
    public void verifyPromotionTab() {
        RestaurantPage restaurantPage = new RestaurantPage(driver);
        clickMenuItem();
        restaurantPage.getAddNewBtn().click();
        restaurantPage.getPromoionsTab().click();
        String actualPromotionImageField = driver.findElement(By.xpath("//div[@id='promo_image']//label")).getText();
        Assert.assertTrue(actualPromotionImageField.contains("Promotion Image"));
    }

    @Test(priority = 11)
    public void verifyOpeningRewardPointTab() {
        RestaurantPage restaurantPage = new RestaurantPage(driver);
        clickMenuItem();
        restaurantPage.getAddNewBtn().click();
        restaurantPage.getRewardPointsTab().click();
        String actualRewardPointRadioText = driver.findElement(By.xpath("//label[normalize-space()='Reward Point']")).getText();
        Assert.assertTrue(actualRewardPointRadioText.contains("Reward Point"));
    }

    @Test(priority = 12)
    public void verifyOpeningBankInfoTab() {
        RestaurantPage restaurantPage = new RestaurantPage(driver);
        clickMenuItem();
        restaurantPage.getAddNewBtn().click();
        restaurantPage.getBankInfoTab().click();
        String actualBankAddressTextField = driver.findElement(By.xpath("//div[@id='tab_11']//div[2]//div[1]//label[1]")).getText();
        Assert.assertTrue(actualBankAddressTextField.contains("Bank address"));
    }

    @Test(priority = 13)
    public void createNewRestauarnt() throws Exception {
        // VideoRecorder.startRecord("createNewRestauarnt");
        clickMenuItem();
        shareRestaurantCreation(driver);
        WebDriverWait wait = new WebDriverWait(driver, 50); // seconds
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#restaurantTable")));
        //Table in HTML is a collection of <tr> and <td> elements for rows and cells here the table can be located as a WebElement using its id
        WebElement restaurantTable = driver.findElement(By.cssSelector("#restaurantTable"));
        WebElement nextBtn = driver.findElement(By.cssSelector(".paginate_button.next a"));
        while (!restaurantTable.getText().contains(restaurantName) && nextBtn.isEnabled()) {
            nextBtn.click();
            restaurantTable = driver.findElement(By.cssSelector("#restaurantTable"));
            nextBtn = driver.findElement(By.cssSelector(".paginate_button.next a"));
        }
        Assertions.assertThat(restaurantTable.getText()).contains(restaurantName);
    }

    //After creating the restaurant check that the default value is disabled
    @Test(priority = 14)
    public void checkRestaurantDefaultStatusIsDisabled() throws InterruptedException {
        RestaurantPage restaurantPage = new RestaurantPage(driver);
        clickMenuItem();
        shareRestaurantCreation(driver);
        WebDriverWait wait = new WebDriverWait(driver, 20); // seconds
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#restaurantTable")));
        WebElement nextBtn = driver.findElement(By.cssSelector(".paginate_button.next a"));
        WebElement restaurantTable = driver.findElement(By.cssSelector("#restaurantTable"));
        while (nextBtn.isEnabled()) {
            restaurantTable = driver.findElement(By.cssSelector("#restaurantTable"));
            if (restaurantTable.getText().contains(restaurantName)) {
                // select td (table data cell) where new category name located
                WebElement tableCellWithNewRestaurantName = restaurantTable.findElement(By.xpath("//td[text()='" + restaurantName + "']"));
                // Select the whole table row done by select parent of previous element
                WebElement tableRowWhereNewRestaurantLocated = tableCellWithNewRestaurantName.findElement(By.xpath("./.."));
                // Now by using table row select td starts which has an id starts with 'status_', then select button tag then select i tag which represents the button icon
                // we then check if the i tag's class contain the word close that means the button shows x
                Assertions.assertThat(
                                tableRowWhereNewRestaurantLocated
                                        .findElement(By.cssSelector("td[id^='status_'] button i")).getAttribute("class"))
                        .contains("close");
                return;
            }
            nextBtn = driver.findElement(By.cssSelector(".paginate_button.next a"));
            nextBtn.click();
            nextBtn = driver.findElement(By.cssSelector(".paginate_button.next a"));

        }
        Assertions.fail("New Restaurant never found in table");
    }

    //Navigate to the edit Restaurant page then check if the content is displayed
    @Test(priority = 15)
    public void verifyNavigationToEditRestaurantPageTest() {
        RestaurantPage restaurantPage = new RestaurantPage(driver);
        clickMenuItem();
        restaurantPage.getRestaurantEditedIcon().click();
        WebDriverWait wait = new WebDriverWait(driver, 20); // seconds
        //Wait until get the location of the edit category header and header appears
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("section.content-header > h1:nth-child(1)"), "Edit Store"));
    }

    @Test(priority = 16)
    public void enableRestaurantDefaultValue() throws InterruptedException {
        clickMenuItem();
        shareRestaurantCreation(driver);
        enableDisabledRestaurant(driver);
    }

    @Test(priority = 17)
    public void editRestaurantTest() throws InterruptedException {
        RestaurantPage restaurantPage = new RestaurantPage(driver);
        clickMenuItem();
        restaurantPage.getRestaurantEditedIcon().click();
        Thread.sleep(4000);
        restaurantPage.getRestaurantInfo().click();
        restaurantPage.getRestaurantEditName().clear();
        restaurantPage.setRestaurantNameEditedInputText(restaurantEditedName);
        restaurantPage.getSubmitEditedRestaurantName().click();
        System.out.println("Edit restaurant name is:" + restaurantEditedName);
        WebDriverWait wait = new WebDriverWait(driver, 20); // seconds
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#restaurantTable")));
        WebElement restaurantTable = driver.findElement(By.cssSelector("#restaurantTable"));
        WebElement nextBtn = driver.findElement(By.cssSelector(".paginate_button.next a"));
        while (!restaurantTable.getText().contains(restaurantEditedName) && nextBtn.isEnabled()) {
            nextBtn.click();
            restaurantTable = driver.findElement(By.cssSelector("#restaurantTable"));
            nextBtn = driver.findElement(By.cssSelector(".paginate_button.next a"));
        }
        Assertions.assertThat(restaurantTable.getText()).contains(restaurantEditedName);
    }

    @Test(priority = 18)
    public void deleteRestaurantTest() {
        RestaurantPage restaurantPage = new RestaurantPage(driver);
        clickMenuItem();
        restaurantPage.getDeleteRestaurantIcon().click();
        driver.switchTo().alert().accept();
        // WebDriverWait wait = new WebDriverWait(driver, 20); // seconds
        // wait.until(ExpectedConditions.invisibilityOfElementWithText(By.cssSelector("#categotryTable")));
    }
}



