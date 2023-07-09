package mobile_Project;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;
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

public class Test1 {
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
        options.setAppPackage("com.google.android.apps.tasks");
        options.setAppActivity(".ui.TaskListsActivity");
        options.noReset();

        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    

    // GOAL 1
    @Test
    public void notesTest() throws InterruptedException {
        
        //Adding tasks
    	wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"Create new task\"]")));
        driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"Create new task\"]")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")));
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")));
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys("Complete Activity with Google Tasks");
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")));
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();
        
      //Adding tasks
    	wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"Create new task\"]")));
        driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"Create new task\"]")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")));
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")));
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys("Complete Activity with Google Keep");
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")));
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();
        
      //Adding tasks
    	wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"Create new task\"]")));
        driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"Create new task\"]")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")));
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")));
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys("Complete the second Activity Google Keep");
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")));
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();
        
        Thread.sleep(5000);
        List<WebElement> list = driver.findElements(AppiumBy.xpath("//android.support.v7.widget.RecyclerView[@resource-id=\"com.google.android.apps.tasks:id/tasks_list\"]/android.widget.FrameLayout"));
        int s = list.size();
        Assert.assertEquals(s, 3);
        
    }
    
}