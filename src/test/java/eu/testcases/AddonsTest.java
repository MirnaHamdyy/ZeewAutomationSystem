package eu.testcases;

import eu.pages.Addons;

import eu.zeewscript.SeleniumUtility.AbstractAcceptanceLoginBefore;
import eu.zeewscript.SeleniumUtility.VideoRecorder;
import org.apache.commons.lang3.RandomStringUtils;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import static eu.zeewscript.SeleniumUtility.PropertiesFile.getPropertyValue;

public class AddonsTest extends AbstractAcceptanceLoginBefore {

    String randomPart = RandomStringUtils.randomAlphabetic(3).toLowerCase();
    String newMainAddonName = String.format(getPropertyValue("mainAddonName") + randomPart);
    String newSubAddonName = String.format(getPropertyValue("subAddonName") + randomPart);
    String editSubAddonName = String.format(getPropertyValue("editSubAddonName") + randomPart);
    String expectedAddonsPageURL = getPropertyValue("expectedAddonsListURL");
    String expectedAddAddonsFormURL = getPropertyValue("expectedAddAddonsFormURL");


    @Test(priority = 1, groups= {"Opening Pages"})
    public void VerifyOpeningAddonsListPage() throws InterruptedException {
        Addons addonsObj = new Addons(driver);
        //static url
        addonsObj.clickMenuItem();
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, 5); // seconds
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("section.content-header > h1:nth-child(1)"), "Manage Addon"));

        Assert.assertEquals(driver.getCurrentUrl(), expectedAddonsPageURL);
    }

    @Test(priority = 2, groups= {"Opening Pages"})
    public void VerifyOpeningAddAddonsForm() throws InterruptedException {
        Addons addonsObj = new Addons(driver);
        //static url
        addonsObj.clickMenuItem();
        addonsObj.getAddNewAddonsBtn().click();
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, 5); // seconds
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("section.content-header > h1:nth-child(1)"), "Add Addon"));

        Assert.assertEquals(driver.getCurrentUrl(), expectedAddAddonsFormURL);
    }

        @Test(priority = 3)
        public void addNewAddonsTest () throws Exception {
            VideoRecorder.startRecord("addNewAddonsTest");
            Addons addonsObj = new Addons(driver);
            addonsObj.clickMenuItem();
            WebDriverWait wait = new WebDriverWait(driver, 20); // seconds
            addonsObj.getAddNewAddonsBtn().click();
            //Send the category name to the catgeory name field
            Select categoryDropDown = new Select(addonsObj.getSelectCategoryDropDown());
            categoryDropDown.selectByIndex(categoryDropDown.getOptions().size() - 1);
            addonsObj.setMainAddonNameInput(newMainAddonName);
            addonsObj.setMainMinimumCount(getPropertyValue("minimumCount"));
            addonsObj.setMainMaximumCountInput(getPropertyValue("maximumCount"));
            addonsObj.setSubAddonNameInput(newSubAddonName);
            addonsObj.setSubAddonPriceInput(getPropertyValue("subAddonPrice"));
            addonsObj.getAddSubAddonBtn().click();
            addonsObj.setSecondSubAddonNameInput(getPropertyValue("secondSubAddon"));
            addonsObj.setSecondSubAddonsPriceInput(getPropertyValue("secondSubAddonPrice"));
            addonsObj.getSubmitNewAddonsBtn().click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#addonTable")));
            //Table in HTML is a collection of <tr> and <td> elements for rows and cells here the table can be located as a WebElement using its css
            WebElement addonTable = driver.findElement(By.cssSelector("#addonTable"));
            WebElement nextBtn = driver.findElement(By.cssSelector(".paginate_button.next a"));
            while (!addonTable.getText().contains(newMainAddonName) && nextBtn.isEnabled()) {
                nextBtn.click();
                addonTable = driver.findElement(By.cssSelector("#addonTable"));
                nextBtn = driver.findElement(By.cssSelector(".paginate_button.next a"));
            }
            Assertions.assertThat(addonTable.getText()).contains(newMainAddonName);
            VideoRecorder.stopRecord();
        }

        @Test(priority = 4)
        public void verifyNavigationToEditAddonPageTest () {
            Addons addonsObj = new Addons(driver);
            addonsObj.clickMenuItem();
            addonsObj.getEditAddonIcon().click();
            WebDriverWait wait = new WebDriverWait(driver, 20); // seconds
            //Wait until get the location of the edit category header and header appears
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("section.content-header > h1:nth-child(1)"), "Edit Addon"));
        }

        @Test(priority = 5)
        public void editAddonTest () throws Exception {
            VideoRecorder.startRecord("editAddonTest");
            Addons addonsObj = new Addons(driver);
            WebDriverWait wait = new WebDriverWait(driver, 20); // seconds
            addonsObj.clickMenuItem();
            addonsObj.getEditAddonIcon().click();
            addonsObj.getEditSubAddonName().clear();
            addonsObj.setEditSubAddonName(editSubAddonName);
            addonsObj.getEditedSubmitBtn().click();
            System.out.println("Edited addons name is:" + editSubAddonName);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#addonTable")));
            WebElement addonTable = driver.findElement(By.cssSelector("#addonTable"));
            WebElement nextBtn = driver.findElement(By.cssSelector(".paginate_button.next a"));
            while (!addonTable.getText().contains(editSubAddonName) && nextBtn.isEnabled()) {
                nextBtn.click();
                addonTable = driver.findElement(By.cssSelector("#addonTable"));
                nextBtn = driver.findElement(By.cssSelector(".paginate_button.next a"));
            }
            Assertions.assertThat(addonTable.getText()).contains(editSubAddonName);
            VideoRecorder.stopRecord();
        }

        @Test(priority = 6)
        public void deleteAddonTest () throws Exception {
            VideoRecorder.startRecord("deleteAddonTest");
            Addons addonsObj = new Addons(driver);
            addonsObj.clickMenuItem();
            addonsObj.getDeleteAddonIcon().click();
            driver.switchTo().alert().accept();
            VideoRecorder.stopRecord();
        }

//        @AfterClass
//        public void teardown () {
//            if (driver != null) {
//                driver.quit();
//            }

    //    }
    }

