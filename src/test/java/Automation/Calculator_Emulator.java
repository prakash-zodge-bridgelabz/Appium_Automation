package Automation;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Calculator_Emulator {
    public AndroidDriver driver;
    @BeforeMethod
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "emulator-5556");
        capabilities.setCapability("platformVersion", "9.0");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "com.android.calculator2");
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        System.out.println("Started . . . . .");
    }

    @Test
    public void calculator() throws InterruptedException {
        WebElement four = driver.findElement(By.id("com.android.calculator2:id/digit_4"));
        four.click();
        Thread.sleep(200);
        WebElement minus = driver.findElement(AppiumBy.accessibilityId("minus"));
        minus.click();
        Thread.sleep(200);
        WebElement seven = driver.findElement(By.id("com.android.calculator2:id/digit_7"));
        seven.click();
        Thread.sleep(200);
        WebElement equals = driver.findElement(AppiumBy.accessibilityId("equals"));
        equals.click();
        Thread.sleep(200);
    }
}
