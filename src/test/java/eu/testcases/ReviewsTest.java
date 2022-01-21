package eu.testcases;

import eu.pages.ReviewsPage;
import eu.zeewscript.SeleniumUtility.AbstractAcceptanceLoginBefore;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static eu.zeewscript.SeleniumUtility.PropertiesFile.getPropertyValue;

public class ReviewsTest extends AbstractAcceptanceLoginBefore {

    String expectedReviewsPageURL = getPropertyValue("expectedReviewsPageURL");

    public void clickMenuItem() {
        ReviewsPage reviewsPage = new ReviewsPage(driver);
        Actions actions = new Actions(driver);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", reviewsPage.getReportingMainMenu());
        actions.moveToElement(reviewsPage.getReportingMainMenu());
        reviewsPage.getReportingMainMenu().click();
        actions.perform();
        reviewsPage.getReviewsSubMenu().click();
        actions.perform();
    }

    @Test(priority = 1)
    public void verifyOpeningReviewsPage() {
        clickMenuItem();
        WebDriverWait wait = new WebDriverWait(driver, 5); // seconds
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("section.content-header > h1:nth-child(1)"), "Manage Reviews (Stores)"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedReviewsPageURL);
    }

}
