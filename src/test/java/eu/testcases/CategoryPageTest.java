package eu.testcases;

import eu.pages.CategoryPage;
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

public class CategoryPageTest extends AbstractAcceptanceLoginBefore {

    String randomPart = RandomStringUtils.randomAlphabetic(3).toLowerCase();
    String newCategoryName = String.format(getPropertyValue("categoryName") + randomPart);
    String newEditedCategoryName = String.format(getPropertyValue("editCategoryName") + randomPart);
    String expectedCategoryListURL = getPropertyValue("expectedCategoryListURL");
    String expectedAddCategoryFormURl = getPropertyValue("expectedAddCategoryFormURl");

    //Click on the main menu and sub menu (Catgeory)
    public void clickMenuItem() throws InterruptedException {
        CategoryPage categoryPage = new CategoryPage(driver);
        categoryPage.getStoreManagementMainMenu().click();
        Thread.sleep(5000);
        Actions actions = new Actions(driver);
        actions.moveToElement(categoryPage.getCategorySubMenu());
        actions.perform();
        categoryPage.getCategorySubMenu().click();
    }

    //Create a new category starting the clicking on add new button step
    public void shareCategoryCreation(WebDriver driver) {
        CategoryPage categoryPageObject = new CategoryPage(driver);
        categoryPageObject.getAddNewCategoryBtn().click();
        randomPart = RandomStringUtils.randomAlphabetic(3).toLowerCase();
        newCategoryName = String.format(getPropertyValue("categoryName") + randomPart);
        categoryPageObject.setCategoryNameInput(newCategoryName);
        categoryPageObject.getCategorySubmitBtn().click();
    }

    public void enableDisabledCategory(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#categotryTable")));
        WebElement nextBtn = driver.findElement(By.cssSelector(".paginate_button.next a"));
        WebElement categotryTable = driver.findElement(By.cssSelector("#categotryTable"));
        while (nextBtn.isEnabled()) {
            categotryTable = driver.findElement(By.cssSelector("#categotryTable"));
            if (categotryTable.getText().contains(newCategoryName)) {
                WebElement tableCellWithNewCategoryName = driver.findElement(By.xpath("//td[text()='" + newCategoryName + "']"));
                WebElement tableRowWhereNewCategoryLocated = tableCellWithNewCategoryName.findElement(By.xpath("./.."));
                //    tableRowWhereNewCategoryLocated.findElement(By.cssSelector("td[id^='status_'] button")).click();

                if (tableRowWhereNewCategoryLocated.getText().contains("close")) {

                    tableRowWhereNewCategoryLocated.findElement(By.cssSelector("td[id^='status_'] button")).click();
                }
                return;
            }
            nextBtn = driver.findElement(By.cssSelector(".paginate_button.next a"));
            nextBtn.click();
            //here you do something like update or save
            //then you define the button element again before you use it
            nextBtn = driver.findElement(By.cssSelector(".paginate_button.next a"));

        }
        Assertions.fail("New Category never found in table");
    }

    //Test that the category page opens and content displays correctly
    @Test(priority = 1)
    public void openCategoryListPage() throws InterruptedException {
        clickMenuItem();
        driver.get(expectedCategoryListURL);
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, 5); // seconds
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("section.content-header > h1:nth-child(1)"), "Manage Category"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedCategoryListURL);
    }

    //Verify that add a new category form opens and content is diplayed correctly
    @Test(priority = 2)
    public void verifyOpeningAddCategoryForm() throws InterruptedException {
        CategoryPage categoryPageObj = new CategoryPage(driver);
        clickMenuItem();
        Thread.sleep(5000);
        categoryPageObj.getAddNewCategoryBtn().click();
        WebDriverWait wait = new WebDriverWait(driver, 5); // seconds
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("section.content-header > h1:nth-child(1)"), "Add Category"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedAddCategoryFormURl);
    }

    @Test(priority = 3)
    public void createCategoryTest() throws InterruptedException {
        clickMenuItem();
        shareCategoryCreation(driver);
        //Send the category name to the catgeory name field
        System.out.println("The new category is: " + newCategoryName);
        WebDriverWait wait = new WebDriverWait(driver, 20); // seconds
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#categotryTable")));
        //Table in HTML is a collection of <tr> and <td> elements for rows and cells here the table can be located as a WebElement using its id
        WebElement categoryTable = driver.findElement(By.cssSelector("#categotryTable"));
        WebElement nextBtn = driver.findElement(By.cssSelector(".paginate_button.next a"));
        while (!categoryTable.getText().contains(newCategoryName) && nextBtn.isEnabled()) {
            nextBtn.click();
            categoryTable = driver.findElement(By.cssSelector("#categotryTable"));
            nextBtn = driver.findElement(By.cssSelector(".paginate_button.next a"));
        }
        Assertions.assertThat(categoryTable.getText()).contains(newCategoryName);
    }

    @Test(priority = 4)
    public void checkCategoryDefaultStatusIsDisabled() throws InterruptedException {
        clickMenuItem();
        shareCategoryCreation(driver);
        WebDriverWait wait = new WebDriverWait(driver, 20); // seconds
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#categotryTable")));
        WebElement nextBtn = driver.findElement(By.cssSelector(".paginate_button.next a"));
        WebElement categotryTable = driver.findElement(By.cssSelector("#categotryTable"));
        while (nextBtn.isEnabled()) {
            categotryTable = driver.findElement(By.cssSelector("#categotryTable"));
            if (categotryTable.getText().contains(newCategoryName)) {
                // select td (table data cell) where new category name located
                WebElement tableCellWithNewCategoryName = categotryTable.findElement(By.xpath("//td[text()='" + newCategoryName + "']"));
                // Select the whole table row done by select parent of previous element
                WebElement tableRowWhereNewCategoryLocated = tableCellWithNewCategoryName.findElement(By.xpath("./.."));
                // Now by using table row select td starts which has an id starts with 'status_', then select button tag then select i tag which represents the button icon
                // we then check if the i tag's class contain the word close that means the button shows x
                Assertions.assertThat(
                                tableRowWhereNewCategoryLocated
                                        .findElement(By.cssSelector("td[id^='status_'] button i")).getAttribute("class"))
                        .contains("close");
                return;
            }
            nextBtn = driver.findElement(By.cssSelector(".paginate_button.next a"));
            nextBtn.click();
            nextBtn = driver.findElement(By.cssSelector(".paginate_button.next a"));

        }
        Assertions.fail("New category never found in table");
    }

    //Navigate to the edit category page then check if the content is displayed
    @Test(priority = 5)
    public void verifyNavigationToEditCategoryPageTest() throws InterruptedException {
        CategoryPage categoryPageObj = new CategoryPage(driver);
        clickMenuItem();
        Thread.sleep(5000);
        categoryPageObj.getEditCategoryIcon().click();
        WebDriverWait wait = new WebDriverWait(driver, 20); // seconds
        //Wait until get the location of the edit category header and header appears
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("section.content-header > h1:nth-child(1)"), "Edit Category"));
    }

    @Test(priority = 6)
    public void enableTheDisabledCreatedCategory() throws InterruptedException {
        clickMenuItem();
        shareCategoryCreation(driver);
        enableDisabledCategory(driver);

    }

    @Test(priority = 7)
    public void editCategoryTest() throws InterruptedException {
        CategoryPage categoryPageObj = new CategoryPage(driver);
        clickMenuItem();
        categoryPageObj.getEditCategoryIcon().click();
        categoryPageObj.getEditCategoryNameInput().clear();
        categoryPageObj.setEditCategoryNameInput(newEditedCategoryName);
        categoryPageObj.getSubmitEditedCategoryBtn().click();
        System.out.println("Edit category name is:" + newEditedCategoryName);
        WebDriverWait wait = new WebDriverWait(driver, 20); // seconds
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#categotryTable")));
        WebElement categoryTable = driver.findElement(By.cssSelector("#categotryTable"));
        WebElement nextBtn = driver.findElement(By.cssSelector(".paginate_button.next a"));
        while (!categoryTable.getText().contains(newEditedCategoryName) && nextBtn.isEnabled()) {
            nextBtn.click();
            categoryTable = driver.findElement(By.cssSelector("#categotryTable"));
            nextBtn = driver.findElement(By.cssSelector(".paginate_button.next a"));
        }
        Assertions.assertThat(categoryTable.getText()).contains(newEditedCategoryName);
    }

    @Test(priority = 8)
    public void deleteCategoryTest() throws InterruptedException {
        CategoryPage categoryPageObj = new CategoryPage(driver);
        clickMenuItem();
        categoryPageObj.getDeleteCategoryIcon().click();
        driver.switchTo().alert().accept();
        // WebDriverWait wait = new WebDriverWait(driver, 20); // seconds
        // wait.until(ExpectedConditions.invisibilityOfElementWithText(By.cssSelector("#categotryTable")));
    }

}
