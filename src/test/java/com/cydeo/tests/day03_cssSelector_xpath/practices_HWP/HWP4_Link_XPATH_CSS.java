package com.cydeo.tests.day03_cssSelector_xpath.practices_HWP;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HWP4_Link_XPATH_CSS {

    public static void main(String[] args) {

        // HWP #4: Practice Cydeo – xpath locator practice
        // 1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        // 2- Go to: https://practice.cydeo.com/inputs
        driver.get("https://practice.cydeo.com/inputs");

        // 3- Click to “Home” link
        // PS: Locate “Home” link using “xpath” locator

        WebElement homeLink = driver.findElement(By.linkText("Home"));
        WebElement homeLink1 = driver.findElement(By.xpath("//a[@class='nav-link']"));
        WebElement homeLink2 = driver.findElement(By.xpath("//a[text()='Home']"));
        WebElement homeLink3 = driver.findElement(By.xpath("//a[.='Home']"));

        // PS: Locate “Home” link using “cssSelector” locator

        WebElement homeLink4 = driver.findElement(By.cssSelector("a.nav-link"));


        homeLink4.click();


        // 4- Verify title is as expected: Expected: Practice
        String expectedPracticeTitle = "Practice";
        String actualPracticeTitle = driver.getTitle();

        if (expectedPracticeTitle.contains(actualPracticeTitle)) {
            System.out.println("Practice title verification PASSED!");
        } else {
            System.out.println("Practice title verification FAILED!!!");
        }

        // close the browser
        // driver.close();
    }
}
