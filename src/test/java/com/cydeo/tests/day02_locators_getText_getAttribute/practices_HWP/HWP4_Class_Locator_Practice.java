package com.cydeo.tests.day02_locators_getText_getAttribute.practices_HWP;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HWP4_Class_Locator_Practice {
    public static void main(String[] args) throws InterruptedException {


        // TC #4: Practice Cydeo – Class locator practice
        // 1- Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 2- Go to: https://practice.cydeo.com/inputs
        driver.get("https://practice.cydeo.com/inputs");
        Thread.sleep(2000);

        // 3- Click to “Home” link
        WebElement homeLink = driver.findElement(By.className("nav-link"));
        homeLink.click();

        // 4- Verify title is as expected:
        // Expected: Practice
        // PS: Locate “Home” link using “className” locator

        String expectedPracticeTitle = "Practice";
        String actualPracticeTitle = driver.getTitle();

        if (actualPracticeTitle.equals(expectedPracticeTitle)) {
            System.out.println("Title verification PASSED!");
        } else {
            System.out.println("Title verification FAILED!!!");
        }

        // close the browser
        driver.close();

    }
}
