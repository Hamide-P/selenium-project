package com.cydeo.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {


    // TASK: NEW METHOD CREATION
    // Method name : getDriver
    // Static method
    // Accepts String arg: browserType
    //   - This arg will determine what type of browser is opened
    //   - if "chrome" passed --> it will open Chrome browser
    //   - if "firefox" passed --> it will open firefox browser
    // RETURN TYPE: "WebDriver"


    public static WebDriver getDriver(String browserType) { // return type is webdriver

        if (browserType.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver(); // instead of creating as usual way we use return new chrome driver
        } else if (browserType.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        } else {
            System.out.println("Given string doesn't represent any browser.");
            System.out.println("Either that browser does not exist or not currently supported.");
            System.out.println("driver = null");
            return null;
        }
    }


}