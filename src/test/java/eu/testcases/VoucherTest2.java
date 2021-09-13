package eu.testcases;

import eu.zeewscript.SeleniumUtility.AbstractAcceptanceLoginBefore;
import org.assertj.core.util.DateUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class VoucherTest2 extends AbstractAcceptanceLoginBefore {

    //Get The Current Day
    public static String getCurrentDay() {
        //Create a Calendar Object
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        //Get Current Day as a number
        int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println("Today Int: " + todayInt + "\n");
        //Integer to String Conversion
        String todayStr = Integer.toString(todayInt);
        System.out.println("Today Str: " + todayStr + "\n");
        return todayStr;
    }
    //Get The Current Day plus days. You can change this method based on your needs.
    public static String getCurrentDayPlus(int days) {
        LocalDate currentDate = LocalDate.now();
        int dayOfWeekPlus = currentDate.getDayOfWeek().plus(days).getValue();
        return Integer.toString(dayOfWeekPlus);
    }
    //Click to given day
    public static void clickGivenDay(List<WebElement> elementList, String day) {
        //DatePicker is a table. Thus we can navigate to each cell
        //and if a cell matches with the current date then we will click it.
        /**Functional JAVA version of this method.*/
        elementList.stream()
                .filter(element -> element.getText().contains(day))
                .findFirst()
                .ifPresent(WebElement::click);

//    @Test
//    public void dateTimePicker(){
//
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//        driver.get("http://demo.guru99.com/test/");
//
//        //Find the date time picker control
//        WebElement dateBox = driver.findElement(By.xpath("//form//input[@name='bdaytime']"));
//
//        //Fill date as mm/dd/yyyy as 09/25/2013
//        dateBox.sendKeys("09252013");
//
//        //Press tab to shift focus to time field
//        dateBox.sendKeys(Keys.TAB);
//
//        //Fill time as 02:45 PM
//        dateBox.sendKeys("0245PM");
//
//    }
    }
}