package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchSteps {
	
    WebDriver driver;
    WebDriverWait wait;
    @Before 
	public void setUp() throws Exception {
		//Setup instances
		WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofMillis(2000));
	  
	}
    @SuppressWarnings("deprecation")
	@Given("^User is on Google Home Page$")
    public void userIsOnGooglePage() throws Throwable {
    	
    	//FIREFOX
//    	WebDriverManager.firefoxdriver().setup();
//        driver = new FirefoxDriver();
//        wait = new WebDriverWait(driver, Duration.ofMillis(2000));
        driver.get("https://www.google.com");
    	
        //CHROME
//    	WebDriverManager.chromedriver().setup();
//        ChromeOptions options = new ChromeOptions();
//    	options.addArguments("--remote-allow-origins=*");
//    	WebDriver driver = new ChromeDriver(options);
//        wait = new WebDriverWait(driver, 2);
//        //Open the browser
//        driver.get("https://www.google.com");
    }
    
    @When("^User types in Cheese and hits ENTER$")
    public void userTypesInCheeseAndHitsENTER() throws Throwable {
        driver.findElement(By.name("q")).sendKeys("Cheese", Keys.RETURN);
    }

    @Then("^Show how many search results were shown$")
    public void showHowManySearchResultsWereShown() throws Throwable {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("result-stats")));
        String resultStats = driver.findElement(By.id("result-stats")).getText();
        System.out.println("Number of results found: " + resultStats);
    }
    
    @After 
	public void quitDriver() throws Exception {
		//Setup instances
    	try
		{
		driver.quit();
		}
		catch(Exception e)
		{
			driver.close();
		}
	  
	}
}
