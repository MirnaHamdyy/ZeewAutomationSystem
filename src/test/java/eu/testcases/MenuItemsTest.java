//package eu.testcases;
//
//import eu.pages.CategoryPage;
//import eu.pages.MenuItemsPage;
//import eu.pages.RestaurantPage;
//import eu.zeewscript.SeleniumUtility.AbstractAcceptanceLoginBefore;
//import eu.zeewscript.SeleniumUtility.VideoRecorder;
//import org.apache.commons.lang3.RandomStringUtils;
//import org.assertj.core.api.Assertions;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.Test;
//
//import static eu.zeewscript.SeleniumUtility.PropertiesFile.getPropertyValue;
//
//public class MenuItemsTest extends AbstractAcceptanceLoginBefore {
//
//    String randomPart = RandomStringUtils.randomAlphabetic(3).toLowerCase();
//    String menuName = String.format(getPropertyValue("menuName") + randomPart);
//    String menuPrice = String.format(getPropertyValue("menuPrice") + randomPart);
//
//    public void shareMenuCreation(WebDriver driver) throws InterruptedException {
//        MenuItemsPage menuItemsPage = new MenuItemsPage(driver);
//        menuItemsPage.getAddMenuBtn().click();
//        randomPart = RandomStringUtils.randomAlphabetic(3).toLowerCase();
//        menuName = String.format(getPropertyValue("menuName") + randomPart);
//        menuPrice = String.format(getPropertyValue("menuPrice") + randomPart);
//
//        menuItemsPage.setMenuNameInput(getPropertyValue("menuName"));
//        menuItemsPage.setMenuPriceInput(getPropertyValue("menuPrice"));
//        menuItemsPage.setMenuImageUplaod(getPropertyValue("menuImage"));
//        menuItemsPage.getSubmitMenuBtn().click();
//    }
//
//    @Test(priority = 1)
//    public void openMenuItemsPage() throws InterruptedException {
//        MenuItemsPage menuItemsPage = new MenuItemsPage(driver);
//        menuItemsPage.clickMenuItem();
//        String expectedMenuItemsURL = "https://automated-store.deliveryscripts.com/superadmin/restaurants/menu";
//        driver.get(expectedMenuItemsURL);
//        Thread.sleep(5000);
//        WebDriverWait wait = new WebDriverWait(driver, 5); // seconds
//        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("section.content-header > h1:nth-child(1)"), "Manage Store Menu"));
//        Assert.assertEquals(driver.getCurrentUrl(), expectedMenuItemsURL);
//    }
//
//    //Select the created store
//    @Test(priority = 2)
//    public void verifyToSelectNewlyCreatedRestaurant() throws InterruptedException {
//        RestaurantPage restaurantPage = new RestaurantPage(driver);
//        restaurantPage.clickMenuItem();
//        RestaurantTest restaurantTest = new RestaurantTest();
//        restaurantTest.shareRestaurantCreation(driver);
//        Thread.sleep(3000);
//        restaurantTest.enableDisabledRestaurant(driver);
//
//        MenuItemsPage menuItemsPage = new MenuItemsPage(driver);
//        menuItemsPage.clickMenuItem();
//        Select selectRestaurant = new Select(menuItemsPage.getSelectRestaurantDrpDown());
//        selectRestaurant.selectByVisibleText(restaurantTest.getRestaurantName());
//
//        Assertions.assertThat(menuItemsPage.getSelectRestaurantDrpDown().getText().contains(restaurantTest.getRestaurantName()));
//    }
//
//    //Verify that the add new category pop up opens and has the content
//    @Test(priority = 3)
//    public void openCategoryThroughMenuItem() throws InterruptedException {
//        MenuItemsPage menuItemsPage = new MenuItemsPage(driver);
//        menuItemsPage.clickMenuItem();
//        Thread.sleep(4000);
//        Select selectRestaurant = new Select(menuItemsPage.getSelectRestaurantDrpDown());
//        selectRestaurant.selectByIndex(1);
//        menuItemsPage.getAddCategoryBtn().click();
//        WebDriverWait wait = new WebDriverWait(driver, 20);
//        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(":nth-child(10) :nth-child(2) h4.modal-title"), "Add Category"));
//    }
//
//    //Create category, restaurant and link the newly created catgeory to the newly created restaurant
//    @Test(priority = 4)
//    public void selectAndAddCategoryForRestaurant() throws InterruptedException {
//        CategoryPage categoryPage = new CategoryPage(driver);
//        categoryPage.clickMenuItem();
//        CategoryPageTest categoryTest = new CategoryPageTest();
//        categoryTest.shareCategoryCreation(driver);
//        Thread.sleep(3000);
//        RestaurantPage restaurantPage = new RestaurantPage(driver);
//        restaurantPage.clickMenuItem();
//        RestaurantTest restaurantTest = new RestaurantTest();
//        restaurantTest.shareRestaurantCreation(driver);
//        restaurantTest.enableDisabledRestaurant(driver);
//        MenuItemsPage menuItemsPage = new MenuItemsPage(driver);
//        menuItemsPage.clickMenuItem();
//        Select selectRestaurant = new Select(menuItemsPage.getSelectRestaurantDrpDown());
//        selectRestaurant.selectByVisibleText(restaurantTest.getRestaurantName());
//        menuItemsPage.getAddCategoryBtn().click();
//        Thread.sleep(5000);
//        WebDriverWait webDriverWait = new WebDriverWait(driver, 20);
//        webDriverWait.until(
//                ExpectedConditions.elementToBeClickable(menuItemsPage.getSelectCategoryDrpDown())
//        ).click();
//        menuItemsPage.setSelectCategoryInputText(categoryTest.getNewCategoryName());
//        Thread.sleep(3000);
//        menuItemsPage.getHighlightedCategoryForRestaurantSelected().click();
//        Thread.sleep(3000);
//        menuItemsPage.getSaveSelectedCategoryBtn().submit();
//
//        webDriverWait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("categories"),
//                categoryTest.getNewCategoryName()));
//    }
//
//    @Test(priority = 5)
//    public void selectAndAddCategoryAndAddMenuForRestaurant() throws Exception {
//        VideoRecorder.startRecord("selectAndAddCategoryAndAddMenuForRestaurant");
//        CategoryPage categoryPage = new CategoryPage(driver);
//        categoryPage.clickMenuItem();
//        CategoryPageTest categoryTest = new CategoryPageTest();
//        categoryTest.shareCategoryCreation(driver);
//        Thread.sleep(3000);
//        RestaurantPage restaurantPage = new RestaurantPage(driver);
//        restaurantPage.clickMenuItem();
//        RestaurantTest restaurantTest = new RestaurantTest();
//        restaurantTest.shareRestaurantCreation(driver);
//        restaurantTest.enableDisabledRestaurant(driver);
//        MenuItemsPage menuItemsPage = new MenuItemsPage(driver);
//        menuItemsPage.clickMenuItem();
//        Select selectRestaurant = new Select(menuItemsPage.getSelectRestaurantDrpDown());
//        selectRestaurant.selectByVisibleText(restaurantTest.getRestaurantName());
//        menuItemsPage.getAddCategoryBtn().click();
//        Thread.sleep(5000);
//        WebDriverWait webDriverWait = new WebDriverWait(driver, 20);
//        webDriverWait.until(
//                ExpectedConditions.elementToBeClickable(menuItemsPage.getSelectCategoryDrpDown())
//        ).click();
//        menuItemsPage.setSelectCategoryInputText(categoryTest.getNewCategoryName());
//        Thread.sleep(3000);
//        menuItemsPage.getHighlightedCategoryForRestaurantSelected().click();
//        Thread.sleep(3000);
//        menuItemsPage.getSaveSelectedCategoryBtn().submit();
//
//       webDriverWait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("categories"),
//                categoryTest.getNewCategoryName()));
//
//       webDriverWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//ul[@id='categories']/li[contains(text(),'"+ categoryTest.getNewCategoryName() +"')]")))).click();
//       Thread.sleep(200);
//
////        driver.findElement(By.xpath("//ul[@id='categories']/li[contains(text(),'"+ categoryTest.getNewCategoryName() +"')]")).click();
//        menuItemsPage.getAddMenuBtn().click();
//        randomPart = RandomStringUtils.randomAlphabetic(3).toLowerCase();
//        webDriverWait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(" div:nth-child(3) > div:nth-child(3) > label:nth-child(1)") , "Menu Name"));
//
//        menuItemsPage.setMenuNameInput(getPropertyValue("menuName") +randomPart);
//        menuItemsPage.setMenuPriceInput(getPropertyValue("menuPrice"));
//        menuItemsPage.setMenuImageUplaod(getPropertyValue("menuImage"));
//        menuItemsPage.getSubmitMenuBtn().click();
//        VideoRecorder.stopRecord();
//    }
//}
//
//
//
//
