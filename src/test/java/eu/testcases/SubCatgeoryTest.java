package eu.testcases;

import eu.pages.SubCatgeoryPage;
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

public class SubCatgeoryTest extends AbstractAcceptanceLoginBefore {

    String expectedSubCatgeoryURL = getPropertyValue("expectedSubCategoryListURL");
    String expectedAddSubCatgeoryURL = getPropertyValue("expectedAddSubCatgeoryURL");
    String randomPart = RandomStringUtils.randomAlphabetic(3).toLowerCase();
    String newCategoryName = String.format(getPropertyValue("subCategoryName") + randomPart);
    String newEditedSubCategoryName = String.format(getPropertyValue("editedSubCatgeoryName") + randomPart);

    public void clickMenuItem() {
        SubCatgeoryPage subCatgeoryPage = new SubCatgeoryPage(driver);
        Actions actions = new Actions(driver);
        actions.moveToElement(subCatgeoryPage.getStoreManagementMainMenu());
        subCatgeoryPage.getStoreManagementMainMenu().click();
        actions.perform();
        subCatgeoryPage.getSubCatgeorySubMenu().click();
        actions.perform();
    }

    //Create a new category starting the clicking on add new button step
    public void shareSubCategoryCreation(WebDriver driver) {
        SubCatgeoryPage subCatgeoryPage = new SubCatgeoryPage(driver);
        subCatgeoryPage.getAddSubCatgeoryBtn().click();
        randomPart = RandomStringUtils.randomAlphabetic(3).toLowerCase();
        newCategoryName = String.format(getPropertyValue("categoryName") + randomPart);
        subCatgeoryPage.setCategoryNameInput(newCategoryName);
        subCatgeoryPage.getSubmitBtn().click();
    }

    //Test that the sub-category page opens and content displays correctly
    @Test(priority = 1)
    public void openSubCategoryListPage() throws InterruptedException {
        clickMenuItem();
        WebDriverWait wait = new WebDriverWait(driver, 5); // seconds
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("section.content-header > h1:nth-child(1)"), "Manage Sub-Category"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedSubCatgeoryURL);
    }


    @Test(priority = 2)
    public void openAddSubCategoryPage() throws InterruptedException {
        SubCatgeoryPage subCatgeoryPage = new SubCatgeoryPage(driver);
        clickMenuItem();
        subCatgeoryPage.getAddSubCatgeoryBtn().click();
        WebDriverWait wait = new WebDriverWait(driver, 5); // seconds
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("section.content-header > h1:nth-child(1)"), "Add Sub-Category"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedAddSubCatgeoryURL);
    }

    @Test(priority = 3)
    public void createSubCategoryTest() throws InterruptedException {
        clickMenuItem();
        shareSubCategoryCreation(driver);
        //Send the category name to the catgeory name field
        System.out.println("The new sub category is: " + newCategoryName);
        WebDriverWait wait = new WebDriverWait(driver, 20); // seconds
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#categotryTable")));
        //Table in HTML is a collection of <tr> and <td> elements for rows and cells here the table can be located as a WebElement using its id
        WebElement subCategoryTable = driver.findElement(By.cssSelector("#categotryTable"));
        WebElement nextBtn = driver.findElement(By.cssSelector(".paginate_button.next a"));
        while (!subCategoryTable.getText().contains(newCategoryName) && nextBtn.isEnabled()) {
            nextBtn.click();
            subCategoryTable = driver.findElement(By.cssSelector("#categotryTable"));
            nextBtn = driver.findElement(By.cssSelector(".paginate_button.next a"));
        }
        Assertions.assertThat(subCategoryTable.getText()).contains(newCategoryName);
    }


    @Test(priority = 4)
    public void checkCategoryDefaultStatusIsDisabled() throws InterruptedException {
        clickMenuItem();
        shareSubCategoryCreation(driver);
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

    //Navigate to the edit subcategory page then check if the content is displayed
    @Test(priority = 5)
    public void verifyNavigationToEditCategoryPageTest() throws InterruptedException {
        SubCatgeoryPage subCatgeoryPage = new SubCatgeoryPage(driver);
        clickMenuItem();
        Thread.sleep(5000);
        subCatgeoryPage.getEditSubcatgeoryIcon().click();
        WebDriverWait wait = new WebDriverWait(driver, 20); // seconds
        //Wait until get the location of the edit category header and header appears
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("section.content-header > h1:nth-child(1)"), "Edit Sub-Category"));
    }

    @Test(priority = 7)
    public void editCategoryTest() throws InterruptedException {
        SubCatgeoryPage subCatgeoryPage = new SubCatgeoryPage(driver);
        clickMenuItem();
        subCatgeoryPage.getEditSubcatgeoryIcon().click();
        subCatgeoryPage.getCategoryNameInput().clear();
        subCatgeoryPage.setCategoryNameInput(newEditedSubCategoryName);
        subCatgeoryPage.getSubmitBtn().click();
        System.out.println("Edit category name is:" + newEditedSubCategoryName);
        WebDriverWait wait = new WebDriverWait(driver, 20); // seconds
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#categotryTable")));
        WebElement categoryTable = driver.findElement(By.cssSelector("#categotryTable"));
        WebElement nextBtn = driver.findElement(By.cssSelector(".paginate_button.next a"));
        while (!categoryTable.getText().contains(newEditedSubCategoryName) && nextBtn.isEnabled()) {
            nextBtn.click();
            categoryTable = driver.findElement(By.cssSelector("#categotryTable"));
            nextBtn = driver.findElement(By.cssSelector(".paginate_button.next a"));
        }
        Assertions.assertThat(categoryTable.getText()).contains(newEditedSubCategoryName);
    }

    @Test(priority = 8)
    public void deleteCategoryTest() throws InterruptedException {
        SubCatgeoryPage subCatgeoryPage = new SubCatgeoryPage(driver);
        clickMenuItem();
        subCatgeoryPage.getDeleteSubCatgeoryIcon().click();
        driver.switchTo().alert().accept();
        // WebDriverWait wait = new WebDriverWait(driver, 20); // seconds
        // wait.until(ExpectedConditions.invisibilityOfElementWithText(By.cssSelector("#categotryTable")));
    }


}
