package sel_Project;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Test4 {
	
	// Declare the WebDriver object
    WebDriver driver;
    
    @BeforeMethod
    public void beforeMethod() {
        // Set up the Firefox driver
        WebDriverManager.firefoxdriver().setup();
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        //Open browser
        driver.get("https://alchemy.hguy.co/lms");
    }

    @Test
    public void TestCase4() {
    	String secondTileTitle = driver.findElement(By.xpath("//div[@class='entry-content clear']//div[@class='ld-course-list-items row']/div[2]//h3")).getText();
        Assert.assertEquals(secondTileTitle, "Email Marketing Strategies");
   }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        //Close the browser
    	driver.quit();
    }

}
