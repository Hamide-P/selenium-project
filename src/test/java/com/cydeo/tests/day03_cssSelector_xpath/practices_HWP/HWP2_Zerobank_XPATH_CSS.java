package com.cydeo.tests.day03_cssSelector_xpath.practices_HWP;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HWP2_Zerobank_XPATH_CSS {

    public static void main(String[] args) {


        // HWP #2: Zero Bank header verification
        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();


        //2. Go to http://zero.webappsecurity.com/login.html
        driver.get("http://zero.webappsecurity.com/login.html ");


        // 3. Verify header text

        // xpath solution #1
        WebElement headerText1 = driver.findElement(By.xpath("//div[@class='page-header']"));

        // xpath solution #2
        WebElement headerText2 = driver.findElement(By.xpath("//h3"));


        // cssSelector solution #3
        WebElement headerText3 = driver.findElement(By.cssSelector("div[class='page-header']"));

        // cssSelector solution #4
        // --- > tag[attribute='value']
        WebElement headerText4 = driver.findElement(By.cssSelector("h3"));


        // Expected: “Log in to ZeroBank”

        String expectedHeaderText = "Log in to ZeroBank";
        String actualHeaderText = headerText2.getText();

        if (expectedHeaderText.equals(actualHeaderText)) {
            System.out.println("Header text verification PASSED!");
        } else {
            System.out.println("Header text verification FAILED!");
        }

        // close the browser
        // driver.close();
    }
}
