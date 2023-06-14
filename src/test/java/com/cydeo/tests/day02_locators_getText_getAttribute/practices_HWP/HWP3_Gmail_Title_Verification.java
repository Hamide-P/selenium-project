package com.cydeo.tests.day02_locators_getText_getAttribute.practices_HWP;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HWP3_Gmail_Title_Verification {
    public static void main(String[] args) throws InterruptedException {


        // TC #3: Back and forth navigation
        // 1- Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        // 2- Go to: https://google.com
        driver.get("https://google.com");
        Thread.sleep(2000);

        driver.findElement(By.id("L2AGLb")).click();

        // 3- Click to Gmail from top right.

        WebElement gmailLink = driver.findElement(By.linkText("Gmail"));

        gmailLink.click();

        // 4- Verify title contains:
        // Expected: Gmail

        String expectedGmailTitle = "Gmail";
        String actualGmailTitle = driver.getTitle();

        if (actualGmailTitle.contains(expectedGmailTitle)) { // we can't use equal because in inspect it gives a long title and it will not equal to expected title ==>  actualGmailTitle = Gmail: Private and secure....
            System.out.println("Gmail title verification PASSED!");
        } else {
            System.out.println("Gmail title verification PASSED!");
        }


        // 5- Go back to Google by using the .back();
        driver.navigate().back();

        // 6- Verify title equals:
        // Expected: Google

        String expectedGoogleTitle = "Google";
        String actualGoogleTitle = driver.getTitle();
        if (actualGmailTitle.equals(expectedGmailTitle)) {
            System.out.println("Google title verification PASSED!");
        } else {
            System.out.println("Google title verification PASSED!");
        }

        // close the browser
        driver.close();

    }
}
