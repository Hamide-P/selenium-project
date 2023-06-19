package com.cydeo.tests.day08_properties_config_reader;

import com.cydeo.utilities.WebDriverFactory;
import com.cydeo.utilities.WebOrderUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T1_WebTable_Order_Verify {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        // TC #1: Web table practice
        //1. Create new test and make setups
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2. Go to: https://practice.cydeo.com/web-tables
        driver.get("https://practice.cydeo.com/web-tables");
    }

    @Test

    public void order_verify_name_test() {
        //2. VerifyBob’s name is listed as expected.
        //below locator is locating me the Bob Martin's cell as where it is currently stored.
        //table[@class='SampleTable']/tbody/tr[7]/td[2]

        //locate Bob's cell using its name as the text.
        String locator = "//table[@class='SampleTable']//td[.='Bob Martin']";
        // passing the locator as a String , then passing this string over bobsCells xPath
        WebElement bobsCell = driver.findElement(By.xpath(locator));

        System.out.println("bobsCell.getText() = " + bobsCell.getText()); // without getText it will print us only the locator text

        //Expected: “Bob Martin”
        String expectedName = "Bob Martin";
        String actualName = bobsCell.getText();

        Assert.assertEquals(actualName, expectedName, "Names are not matching!"); // Failure message will only print it out when it is failing.


        //3. VerifyBobMartin’s order date is as expected.
        //WebElement bobsOrderDate = driver.findElement(By.xpath("//table[@class='SampleTable']//td[.='Bob Martin']/../td[5]"));
        // firstly we locate the BoB Martin then according to the text we find the parent of it then from parent we locate the index number of date which is [5]

        WebElement bobsOrderDate = driver.findElement(By.xpath("//table[@class='SampleTable']//td[.='Bob Martin']/following-sibling::td[3]"));
        // 1. Find the <td> element with the text "Bob Martin"
        // 2. Move to its following sibling <td> element (the third sibling to the right)
        // This represents the order date associated with Bob Martin in the table


        //Expected: 12/31/2021
        String expectedDate = "12/31/2021";
        String actualDate = bobsOrderDate.getText(); // we should use getText

        Assert.assertEquals(actualDate, expectedDate);

    }


    @Test
    public void test2_use_order_verify_method() {

        //call the utility method we created
        String alexandraGray = WebOrderUtils.returnOrderDate(driver, "Alexandra Gray");
        System.out.println("alexandraGray = " + alexandraGray);

        String bartFisher = WebOrderUtils.returnOrderDate(driver, "Bart Fisher");
        System.out.println("bartFisher = " + bartFisher);


    }


    // Expected: “Bob Martin”
    // 3. Verify Bob Martin’s order date is as expected
    // Expected: 12/31/2021

    @Test
    public void test3() {

        WebOrderUtils.orderVerify(driver, "Bob Martin", "12/31/2021");

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();

    }

}
