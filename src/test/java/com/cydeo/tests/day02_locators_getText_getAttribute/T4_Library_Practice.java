package com.cydeo.tests.day02_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T4_Library_Practice {
    public static void main(String[] args) throws InterruptedException {


        // TC #4: Library verifications
        // 1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 2. Go to http://library2.cybertekschool.com/login.html
        driver.get("http://library2.cybertekschool.com/login.html");
        Thread.sleep(2000);

        // 3. Enter username: “incorrect@email.com”
        WebElement usernameInput = driver.findElement(By.className("form-control")); // first inspect then copy-paste
        usernameInput.sendKeys("incorrect@email.com"); // writing incorrect text but it should be the e-mail format


        // 4. Enter password: “incorrect password”
        WebElement passwordInput = driver.findElement(By.id("inputPassword"));
        passwordInput.sendKeys("anything"); // negative testing

        // 5. Verify: visually “Sorry, Wrong Email or Password”
        //displayed

        WebElement signInButton = driver.findElement(By.tagName("button")); // test case is verified
        signInButton.click(); // click the sign-in button

        //6. Verify: visually “Sorry, Wrong Email or Password” displayed
        //VERIFIED.

        // close the browser
        driver.close();

    }
}
