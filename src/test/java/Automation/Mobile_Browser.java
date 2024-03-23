package Automation;

import com.google.common.collect.ImmutableBiMap;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import io.appium.java_client.remote.MobileCapabilityType;       //dependency [appium 4.1.0]
import org.testng.annotations.Test;

import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Mobile_Browser {
    AndroidDriver driver;
    @BeforeMethod
    public void setup(){
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator-5554");
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        dc.setCapability(MobileCapabilityType.BROWSER_NAME,"chrome");
        dc.setCapability("chromeOptions", ImmutableBiMap.of("w3c",false));
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),dc);
        System.out.println("Started....");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void navigateToURLUsingChrome(){
        driver.findElement(By.id("com.android.chrome:id/terms_accept")).click();
        driver.findElement(By.id("com.android.chrome:id/negative_button")).click();
        driver.get("https://www.amazon.com");
    }
}
