package Automation;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.AbstractDriverOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Calculator_Using_Vysor {
    public AndroidDriver driver;
    @BeforeMethod
    public void setup() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("deviceName","iQOO Z6 5G");
        dc.setCapability("udid","13804645630005J");
        dc.setCapability("appPackage","com.vivo.calculator");
        dc.setCapability("appActivity","com.vivo.calculator.Calculator");
        dc.setCapability("platformVersion","13");
        dc.setCapability("platformName","Android");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),dc);
        System.out.println("Started....");
    }
    @Test
    public void calculator(){
        WebElement two = driver.findElement(By.id("com.vivo.calculator:id/digit_2"));
        two.click();

        WebElement multiply = driver.findElement(AppiumBy.accessibilityId("Multiply"));
        multiply.click();

        WebElement five = driver.findElement(By.id("com.vivo.calculator:id/digit_5"));
        five.click();

        WebElement equal = driver.findElement(AppiumBy.accessibilityId("="));
        equal.click();
    }
}
