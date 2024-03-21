package Automation;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Genymotion_Automation {
    AndroidDriver driver;
    @BeforeMethod
    public void setup() throws MalformedURLException {
        DesiredCapabilities ds = new DesiredCapabilities();
        ds.setCapability("deviceName","192.168.213.101:5555");
        ds.setCapability("platformName","Android");
        ds.setCapability("platformVersion","13");
        ds.setCapability("appPackage","com.google.android.calculator");
        ds.setCapability("appActivity","com.android.calculator2.Calculator");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), ds);
        System.out.println("Started . . . . .");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void addition() throws InterruptedException {
        WebElement eight = driver.findElement(AppiumBy.accessibilityId("8"));
        eight.click();

        WebElement mul = driver.findElement(AppiumBy.accessibilityId("multiply"));
        mul.click();

        WebElement nine = driver.findElement(AppiumBy.accessibilityId("9"));
        nine.click();

        WebElement equal = driver.findElement(AppiumBy.accessibilityId("equals"));
        equal.click();
    }
}
