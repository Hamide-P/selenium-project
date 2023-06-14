package com.cydeo.tests.day04_findElements_checkboxes_radio;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class T4_StaleElementReferenceException {

    public static void main(String[] args) {
        //TC #4: StaleElementReferenceException
        //Task 1- Open a Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //2- Go to: https://practice.cydeo.com/abtest
        driver.get("https://practice.cydeo.com/abtest");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //3- Locate “CYDEO” link, verify it is displayed.
        WebElement cydeoLink = driver.findElement(By.xpath("//a[.='CYDEO']"));
        System.out.println("Before refresh: cydeoLink.isDisplayed() = " + cydeoLink.isDisplayed());

        //4- Refresh the page.
        driver.navigate().refresh();
        System.out.println("Refreshing the page...");

        //5- Verify it is displayed, again.
        cydeoLink = driver.findElement(By.xpath("//a[.='CYDEO']")); // Relocate the web element by finding the "CYDEO" link again. This step recreates the connection and allows the driver to resume regular functionality.
        System.out.println("After refresh: cydeoLink.isDisplayed() = " + cydeoLink.isDisplayed());


        driver.quit();


        /*
         * "Stale element reference" refers to an error condition in Selenium.
         * This error occurs when a web element is referenced, but it has changed or been recreated.
         * Web pages can dynamically change, and web elements can be recreated or updated.
         * If changes happen while referencing an element, the reference becomes "stale" or invalid.
         * In such cases, a "StaleElementReferenceException" error is thrown.
         * This error occurs when the content or elements on a web page dynamically change.
         * For example, if a page is refreshed or elements are moved, the error can occur.
         * To resolve the issue, you need to re-locate the updated or recreated element.
         * Use the new reference to interact with the element.

         */


    }

}
