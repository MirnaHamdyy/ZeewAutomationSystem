package eu.testcases;

import eu.pages.InvoicesPage;
import eu.pages.ReviewsPage;
import eu.zeewscript.SeleniumUtility.AbstractAcceptanceLoginBefore;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import static eu.zeewscript.SeleniumUtility.PropertiesFile.getPropertyValue;

public class ReviewsTest extends AbstractAcceptanceLoginBefore {

    String expectedReviewsPageURL=getPropertyValue("expectedReviewsPageURL");

    @Test(priority = 1)
    public void verifyOpeningReviewsPage() {

        ReviewsPage reviewsPage = new ReviewsPage(driver);
        reviewsPage.clickMenuItem();
        WebDriverWait wait = new WebDriverWait(driver, 5); // seconds
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("section.content-header > h1:nth-child(1)"), "Manage Reviews (Stores)"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedReviewsPageURL);
    }

}
