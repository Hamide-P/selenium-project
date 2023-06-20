package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T2_Upload_Practice {


    @Test
    public void uploading_test() {


        // TC#1: Registration form confirmation
        //1. Open browser
        //2. Go to website: https://practice.cydeo.com/upload
        Driver.getDriver().get(ConfigurationReader.getProperty("upload.file")); // from config. properties

        //2. Find some small file from your computer, and get the path of it.
        String path = "/Users/hp/Desktop/file.txt"; // right click ==> press & hold alt + copy the path

        //3. Upload the file. Use sendKeys() method and pass the "path" as a String.
        // selenium can not perform test outside the browser ,so we can't click button of 'choose file'
        // so we are using sendKeys and use 'path'
        WebElement chooseFileButton = Driver.getDriver().findElement(By.xpath("//input[@id='file-upload']"));
        // WebElement chooseFileButton = Driver.getDriver().findElement(By.id("file-upload"));
        BrowserUtils.sleep(2);

        //This is the line that is passing the path of the file to website
        chooseFileButton.sendKeys(path);

        WebElement uploadButton = Driver.getDriver().findElement(By.id("file-submit"));

        uploadButton.click();


        //4. Assert:

        WebElement fileUploadedHeader = Driver.getDriver().findElement(By.tagName("h3"));
        Assert.assertTrue(fileUploadedHeader.isDisplayed(), "Header text is not displayed");
        //-File uploaded text is displayed on the page


    }
}

