package Automation;

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

public class Amazon_Automation {
    AndroidDriver driver;
    @BeforeMethod
    public void setup() throws MalformedURLException {
        DesiredCapabilities ds = new DesiredCapabilities();
        ds.setCapability("deviceName","emulator-5554");
        ds.setCapability("platformName","Android");
        ds.setCapability("platformVersion","9");
        ds.setCapability("appPackage","com.amazon.mShop.android.shopping");
        ds.setCapability("appActivity","com.amazon.mShop.home.HomeActivity");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), ds);
        System.out.println("Started . . . . .");
    }

    @Test
    public void skip_login() throws InterruptedException {
        Thread.sleep(10000);
        WebElement skip = driver.findElement(By.id("com.amazon.mShop.android.shopping:id/skip_sign_in_button"));
        skip.click();
        Thread.sleep(25000);
        WebElement search = driver.findElement(By.id("com.amazon.mShop.android.shopping:id/chrome_search_hint_view"));
        search.click();
        Thread.sleep(2000);
        WebElement search_data = driver.findElement(By.id("com.amazon.mShop.android.shopping:id/rs_search_src_text"));

        Actions action = new Actions(driver);
        action.sendKeys(search_data,"boat").perform();
        Thread.sleep(2000);
        action.sendKeys(search_data, Keys.ENTER).perform();

    }
}
