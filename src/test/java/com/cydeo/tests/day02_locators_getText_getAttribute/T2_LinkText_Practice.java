package com.cydeo.tests.day02_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T2_LinkText_Practice {

    public static void main(String[] args) throws InterruptedException {
        //  TC #2: Back and forth navigation
        //  1- Open a Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //  2- Go to: https://practice.cydeo.com
        driver.get("https://practice.cydeo.com");


        //  3- Click to A/B Testing from top of the list.
        WebElement abTestLink = driver.findElement(By.linkText("A/B Testing")); // copy-paste from inspect side always!!
        // we used here first object ==> find element method and provide our locator with the text  of the web element we are trying to locate
        // then we create a variable inorder to make it reusable
        abTestLink.click(); // then we can call it and add click()


        //  4- Verify title is:
        // Expected: No A/B Test
        Thread.sleep(2000);
        String expectedTitle = "No A/B Test";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Title verification PASSED!!!");
        } else {
            System.out.println("Title verification FAILED!!!");
        }


        //   5- Go back to home page by using the .back();

        driver.navigate().back();

        //    6- Verify title equals:

        Thread.sleep(2000);
        expectedTitle = "Practice"; // overriding from above
        actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Title verification PASSED!!!");
        } else {
            System.out.println("Title verification FAILED!!!");
        }


        //    Expected: Practice

        // close the browser
        driver.close();


    }
}
