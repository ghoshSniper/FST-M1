package mobile_Project;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Test2 {
    // Driver Declaration
    AndroidDriver driver;
    WebDriverWait wait;
     // Set up method
    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.keep");
        options.setAppActivity(".activities.BrowseActivity");
        options.noReset();

        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    

    // GOAL 2
    @Test
    public void notesTest() throws InterruptedException {
        
        //Adding notes
    	wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"New text note\"]")));
        driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"New text note\"]")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.google.android.keep:id/editable_title")));
        driver.findElement(AppiumBy.id("com.google.android.keep:id/editable_title")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.google.android.keep:id/editable_title")));
        driver.findElement(AppiumBy.id("com.google.android.keep:id/editable_title")).sendKeys("TEST NOTE TITLE");
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.google.android.keep:id/edit_note_text")));
        driver.findElement(AppiumBy.id("com.google.android.keep:id/edit_note_text")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.google.android.keep:id/edit_note_text")));
        driver.findElement(AppiumBy.id("com.google.android.keep:id/edit_note_text")).sendKeys("TEST NOTE DESCRIPTION");
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]")));
        driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]")).click();
    
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.google.android.keep:id/browse_note_interior_content")));
        String notePresent = driver.findElement(AppiumBy.id("com.google.android.keep:id/index_note_title")).getText();
        Assert.assertEquals(notePresent,"TEST NOTE TITLE" );
    }
    
}