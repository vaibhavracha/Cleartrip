package Utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumRepo {
	public  WebElement webelement;
	 
 
    
    public static SeleniumRepo instance = null;
	ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();

	public static SeleniumRepo getInstance() {
		if (instance == null) {
			instance = new SeleniumRepo();
		}
		return instance;
	}

	   @SuppressWarnings("deprecation")
	public final void setDriver(String browserName) throws Exception {

	       switch (browserName) {
	       case "chrome":
	    	 System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
	        	 webDriver.set(new ChromeDriver());
	             break;

	       case "firefox":
	           System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\Drivers\\geckodriver.exe");
	            webDriver.set(new FirefoxDriver());
	          
	           break;
	       }
	   }

	public WebDriver getDriver() {
		return webDriver.get();
	}
		
	public void waitForPageLoaded() {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};
		try {
			
			Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(getDriver(), 60);
			wait.until(expectation);
		} catch (Throwable error) {
			//Assert.fail("Timeout waiting for Page Load Request to complete.");
		}
	}
 
 
	 
 
	 
	
	 
}