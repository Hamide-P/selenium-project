package com.cydeo.tests.day06_alerts_iframes_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T4_Iframes {


    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        //1. Open browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //2. Go to website: https://practice.cydeo.com/iframe
        driver.get("https://practice.cydeo.com/iframe");
    }


    @AfterMethod

    public void tearDownMethod() {
        //   driver.quit();
    }


    @Test

    public void iframe_test() {

        //TC #4: Iframe practice
        //we have to switch to iframe to be able to locate the web elements in there.
        //option#1- switch "id" attribute value
        //driver.switchTo().frame("mce_0_ifr");

        //option#2- switch using "index" number
        // driver.switchTo().frame(0); // if it is 1/1 unique we can pass here index number '0'


        //option#3- switch using WebElement
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']")));
        WebElement paragraphText = driver.findElement(By.xpath("//p[.='Your content goes here.']")); // we are locating our Iframe but it gives NoSuchElementException: no such element: Unable to locate element: "//p[.='Your content goes here.']"
        // we can handle iFrames with switch() method.


        //4. Assert: “Your content goes here.” Text is displayed.

        Assert.assertTrue(paragraphText.isDisplayed());

        //5. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor”
        driver.switchTo().parentFrame();
        //  driver.switchTo().defaultContent(); // it is also doing the same thing as parentFrame
        WebElement h3 = driver.findElement(By.tagName("h3")); // h3 = header text
        Assert.assertTrue(h3.isDisplayed());
    }

}
