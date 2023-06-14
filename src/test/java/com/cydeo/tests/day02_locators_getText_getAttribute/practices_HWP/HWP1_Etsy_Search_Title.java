package com.cydeo.tests.day02_locators_getText_getAttribute.practices_HWP;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HWP1_Etsy_Search_Title {
    public static void main(String[] args) throws InterruptedException {

        // HWP #1: Etsy Title Verification
        // 1. Open Chrome browser

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        // 2. Go to https://www.etsy.com
        driver.get("https://www.etsy.com");
        Thread.sleep(2000);


        WebElement cookies=driver.findElement(By.xpath("//*[@id=\"gdpr-single-choice-overlay\"]/div/div[2]/div[2]/button"));  // privacy settings
        Thread.sleep(2000);
        cookies.click();


        // 3. Search for “wooden spoon”

        WebElement etsySerchBox = driver.findElement(By.id("global-enhancements-search-query"));
        etsySerchBox.sendKeys("wooden spoon" + Keys.ENTER); // imitate if the user press like enter using keyboard


        // 4. Verify title:
        // Expected: “Wooden spoon - Etsy”


        String expectedInBeginningOfTitle = "Wooden spoon - Etsy";
        String actualTitle = driver.getTitle();

        // create a simple if condition to compare our actual and expected titles

        if (actualTitle.startsWith(expectedInBeginningOfTitle)) {
            System.out.println("Title verification PASSED!");
        } else {
            System.out.println("Title verification FAIL!!!");

        }

        // close the browser
        driver.close();

    }
}
