package eu.testcases;

import eu.pages.CuisinePage;
import eu.zeewscript.SeleniumUtility.AbstractAcceptanceLoginBefore;
import eu.zeewscript.SeleniumUtility.VideoRecorder;
import org.apache.commons.lang3.RandomStringUtils;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static eu.zeewscript.SeleniumUtility.PropertiesFile.getPropertyValue;

public class CuisinesTest extends AbstractAcceptanceLoginBefore {

    String randomPart = RandomStringUtils.randomAlphabetic(3).toLowerCase();
    String newCuisineName = String.format(getPropertyValue("cuisineName") + randomPart);
    String newEditedCuisineName = String.format(getPropertyValue("editCuisineName") + randomPart);
    String expectedCuisineListURL = getPropertyValue("expectedCuisineListURL");
    String expectedAddCuisineFormURL = getPropertyValue("expectedAddCuisineFormURL");


    public void shareCuisineCreation() {
        CuisinePage cuisinePageObject = new CuisinePage(driver);
        cuisinePageObject.getAddNewCuisineBtn().click();
        randomPart = RandomStringUtils.randomAlphabetic(3).toLowerCase();
        newCuisineName = String.format(getPropertyValue("cuisineName") + randomPart);
        cuisinePageObject.setCuisineNameInput(newCuisineName);
        cuisinePageObject.getSubmitBtn().click();
    }

    @Test(priority = 1, groups= {"Opening Pages"})
    //verify the cuisine opens correctly doesn't open any error page
    public void openCuisinesPage() throws InterruptedException {
        CuisinePage cuisinePageObj = new CuisinePage(driver);
        cuisinePageObj.clickMenuItem();
        WebDriverWait wait = new WebDriverWait(driver, 5); // seconds
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("section.content-header > h1:nth-child(1)"), "Manage Cuisine"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedCuisineListURL);
    }

    @Test(priority = 2, groups= {"Opening Pages"})
    public void openAddCuisineForm() throws InterruptedException {
        CuisinePage cuisinePageObj = new CuisinePage(driver);
        cuisinePageObj.clickMenuItem();
        cuisinePageObj.getAddNewCuisineBtn().click();
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, 5); // seconds
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("section.content-header > h1:nth-child(1)"), "Add Cuisine"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedAddCuisineFormURL);
    }

    @Test(priority = 3)
    public void addNewCuisineTest() throws Exception {
        VideoRecorder.startRecord("editCuisineTest");
        CuisinePage cuisinePageObj = new CuisinePage(driver);
        cuisinePageObj.clickMenuItem();
        shareCuisineCreation();
        WebDriverWait wait = new WebDriverWait(driver, 20); // seconds
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#cuisineTable")));
        //Table in HTML is a collection of <tr> and <td> elements for rows and cells here the table can be located as a WebElement using its css
        WebElement cuisineTable = driver.findElement(By.cssSelector("#cuisineTable"));
        WebElement nextBtn = driver.findElement(By.cssSelector(".paginate_button.next a"));
        while (!cuisineTable.getText().contains(newCuisineName) && nextBtn.isEnabled()) {
            nextBtn.click();
            cuisineTable = driver.findElement(By.cssSelector("#cuisineTable"));
            nextBtn = driver.findElement(By.cssSelector(".paginate_button.next a"));
        }
        Assertions.assertThat(cuisineTable.getText()).contains(newCuisineName);
        Thread.sleep(6000);
        VideoRecorder.stopRecord();
    }

    @Test(priority = 4)
    public void checkCuisineDefaultStatusIsDisabled() throws InterruptedException {
        CuisinePage cuisinePageObj = new CuisinePage(driver);
        cuisinePageObj.clickMenuItem();
        shareCuisineCreation();
        WebDriverWait wait = new WebDriverWait(driver, 20); // seconds
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#cuisineTable")));
        WebElement nextBtn = driver.findElement(By.cssSelector(".paginate_button.next a"));
        WebElement cuisineTable = driver.findElement(By.cssSelector("#cuisineTable"));
        while (nextBtn.isEnabled()) {
            cuisineTable = driver.findElement(By.cssSelector("#cuisineTable"));
            if (cuisineTable.getText().contains(newCuisineName)) {
                // select td (table data cell) where new category name located
                WebElement tableCellWithNewCuisineName = cuisineTable.findElement(By.xpath("//td[text()='" + newCuisineName + "']"));
                // Select the whole table row done by select parent of previous element
                WebElement tableRowWhereNewCuisineLocated = tableCellWithNewCuisineName.findElement(By.xpath("./.."));
                // Now by using table row select td starts which has an id starts with 'status_', then select button tag then select i tag which represents the button icon
                // we then check if the i tag's class contain the word close that means the button shows x
                Assertions.assertThat(
                        tableRowWhereNewCuisineLocated
                                .findElement(By.cssSelector("td[id^='status_'] button i")).getAttribute("class"))
                        .contains("close");
                return;
            }
            nextBtn = driver.findElement(By.cssSelector(".paginate_button.next a"));
            nextBtn.click();
            nextBtn = driver.findElement(By.cssSelector(".paginate_button.next a"));

        }
        Assertions.fail("New Cuisine never found in table");
    }

    @Test(priority = 5)
    public void enableCuisineDefaultValueTest() throws Exception {
        VideoRecorder.startRecord("editCuisineTest");
        CuisinePage cuisinePageObj = new CuisinePage(driver);
        cuisinePageObj.clickMenuItem();
        shareCuisineCreation();
        WebDriverWait wait = new WebDriverWait(driver, 20); // seconds
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#cuisineTable")));
        WebElement nextBtn = driver.findElement(By.cssSelector(".paginate_button.next a"));
        WebElement cuisineTable = driver.findElement(By.cssSelector("#cuisineTable"));
        while (nextBtn.isEnabled()) {
            cuisineTable = driver.findElement(By.cssSelector("#cuisineTable"));
            if (cuisineTable.getText().contains(newCuisineName)) {
                WebElement tableCellWithNewCuisineName = driver.findElement(By.xpath("//td[text()='" + newCuisineName + "']"));
                WebElement tableRowWhereNewCuisineLocated = tableCellWithNewCuisineName.findElement(By.xpath("./.."));
                tableRowWhereNewCuisineLocated.findElement(By.cssSelector("td[id^='status_'] button")).click();
                wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(
                        tableRowWhereNewCuisineLocated,
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
        Assertions.fail("New Cuisine never found in table");
        VideoRecorder.stopRecord();
    }

    @Test(priority = 6)
    public void verifyNavigationToEditCuisinePageTest() {
        CuisinePage cuisinePageObj = new CuisinePage(driver);
        cuisinePageObj.clickMenuItem();
        cuisinePageObj.getEditCuisineIcon().click();
        WebDriverWait wait = new WebDriverWait(driver, 20); // seconds
        //Wait until get the location of the edit category header and header appears
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("section.content-header > h1:nth-child(1)"), "Edit Cuisine"));
    }

    @Test(priority = 7)
    public void editCuisineTest() throws Exception {
        CuisinePage cuisinePageObj = new CuisinePage(driver);
        cuisinePageObj.clickMenuItem();
        cuisinePageObj.getEditCuisineIcon().click();
        cuisinePageObj.getEditCuisineNameInput().clear();
        cuisinePageObj.setEditCuisineNameInput(newEditedCuisineName);
        cuisinePageObj.getSubmitBtn().click();
        System.out.println("Edit cuisine name is:" + newEditedCuisineName);
        WebDriverWait wait = new WebDriverWait(driver, 20); // seconds
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#cuisineTable")));
        WebElement cuisineTable = driver.findElement(By.cssSelector("#cuisineTable"));
        WebElement nextBtn = driver.findElement(By.cssSelector(".paginate_button.next a"));
        while (!cuisineTable.getText().contains(newEditedCuisineName) && nextBtn.isEnabled()) {
            nextBtn.click();
            cuisineTable = driver.findElement(By.cssSelector("#cuisineTable"));
            nextBtn = driver.findElement(By.cssSelector(".paginate_button.next a"));
        }
        Assertions.assertThat(cuisineTable.getText()).contains(newEditedCuisineName);
    }

    @Test(priority = 8)
    public void deleteCuisineTest() throws Exception {
        VideoRecorder.startRecord("deleteCuisineTest");
        CuisinePage cuisinePageObj = new CuisinePage(driver);
        cuisinePageObj.clickMenuItem();
        cuisinePageObj.getDeleteCuisineIcon().click();
        driver.switchTo().alert().accept();
        VideoRecorder.stopRecord();
    }
}








