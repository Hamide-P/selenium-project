package com.cydeo.tests.day02_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_CydeoVerifications {


    public static void main(String[] args) throws InterruptedException {


        //  TC #1: Cydeo practice tool verifications
        //  1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        Thread.sleep(3000);

        //  2. Go to https://practice.cydeo.com
        driver.navigate().to("https://practice.cydeo.com");
        // driver.get("https://practice.cydeo.com");

        //  3. Verify URL contains
        //  Expected: cydeo

        String expectedInURL = "cydeo";
        String actualURL = driver.getCurrentUrl(); // it returns the current URL as a String

        if (actualURL.contains(expectedInURL)) {
            System.out.println("URL verification PASSED!!!");
        } else {
            System.out.println("URL verification FAILED!!!");
        }


        //  4. Verify title:
        //  Expected: Practice

        String expectedTitle = "Practice";
        String actualTitle = driver.getCurrentUrl(); // it returns the current Title "Practice" as a String

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Title verification PASSED!!!");
        } else {
            System.out.println("Title verification FAILED!!!");
        }
/*
  if (driver.getTitle().equals("Practice")){
      System.out.println("Pass!");
  }   //shortest way to write codes like that but not so clear, so use the long way in order to understand later on!!
        */

        // close the browser
          driver.close();


    }
}
