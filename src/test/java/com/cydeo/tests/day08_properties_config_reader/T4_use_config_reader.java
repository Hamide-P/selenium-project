package com.cydeo.tests.day08_properties_config_reader;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T4_use_config_reader {

    //TC #4: Google search

    //Use `configuration.properties` for the following:
    //1. The browser type
    //2. The URL
    //3. The search keyword
    //4. Make title verification dynamic. If search value changes, title assertion should not fail.
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        //1. Create new test and make setups

        // Instead of using the string "chrome", we use the hard-coded "browser" to enable easy changes in multiple places.
        // This retrieves the value of the "browser" property from the configuration file.
        String browserType = ConfigurationReader.getProperty("browser");
        driver = WebDriverFactory.getDriver(browserType);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2. Go to: https://google.com
        driver.get(ConfigurationReader.getProperty("googleURL")); // dynamic version
        //driver.get("https://google.com"); // old version
    }

    @Test
    public void google_search_test() {

        //cookie confirmation 'Accept All'
        BrowserUtils.sleep(2);
        driver.findElement(By.xpath("//button[@id='L2AGLb']")).click();


        BrowserUtils.sleep(3);
        //3- Write “apple” in search box
        //  WebElement searchBox = driver.findElement(By.xpath("input[name='q']"));
        WebElement searchInputBox = driver.findElement(By.cssSelector("textarea[name='q']"));


        //searchInputBox.sendKeys("apple" + Keys.ENTER); // -> hard coded version
        //-> dynamic version in config.properties file: key(searchValue)= value(apple)
        // We use getProperty() utility method from the ConfigurationReader Class to help us read any data from configuration.properties file
        searchInputBox.sendKeys(ConfigurationReader.getProperty("searchValue") + Keys.ENTER);


        //4- Verify title:
        //Expected: apple - Google Search

        String expectedTitle = ConfigurationReader.getProperty("searchValue") + " - Google Search";
        BrowserUtils.sleep(2);
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);

       /* // or other way we can call our verifyTitle() utility method
        BrowserUtils.sleep(2);
        BrowserUtils.verifyTitle(driver, ConfigurationReader.getProperty("searchValue") + " - Google Suche");*/

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();

    }

}


