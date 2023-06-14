package com.cydeo.tests.day03_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1_locators_getText {
    public static void main(String[] args) throws InterruptedException {

        // TC #1: NextBaseCRM, locators and getText() practice
        // 1- Open a chrome browser
        // WebDriverManager.chromedriver().setup();
        //WebDriver driver = new ChromeDriver();

        WebDriver driver = WebDriverFactory.getDriver("chrome"); // getting method from utilities
        driver.manage().window().maximize();

        // 2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");
        Thread.sleep(2000);

        // 3- Enter incorrect username: “incorrect”
        WebElement inputUsername = driver.findElement(By.className("login-inp")); // for different practice we use here different locators ==> "class" but we can use both same locator
        inputUsername.sendKeys("incorrect");


        // 4- Enter incorrect password: “incorrect”
        WebElement inputPassword = driver.findElement(By.name("USER_PASSWORD")); // for different practice we use here different locators ==> "name" but we can use both same locator
        inputPassword.sendKeys("incorrect");

        // 5- Click to login button.

        //  incorrectPassword.sendKeys(Keys.ENTER);

        WebElement loginButton = driver.findElement(By.className("login-btn"));
        loginButton.click();

        // 6- Verify error message text is as expected:
        // Expected: Incorrect login or password

        String expectedError = "Incorrect login or password";
        String actualError = driver.findElement(By.className("errortext")).getText();

        if (expectedError.equals(actualError)) {
            System.out.println("Error verification PASSED!");
        } else {
            System.out.println("Error verification FAILED!");
        }


        // PS: Inspect and decide which locator you should be using to locate web elements.


        // close the browser
        driver.close();
    }
}
