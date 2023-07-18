package ClearTrip.FlightBooking;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utility.SeleniumRepo;

public class BanToHyd {
	
	SeleniumRepo Selenium = SeleniumRepo.getInstance();
	 WebDriver driver = new ChromeDriver();
	 JavascriptExecutor js = (JavascriptExecutor)driver;
 
	
	public void NavigatetoUrl() throws IOException, InterruptedException
	{
		 
		driver.manage().window().maximize();
		driver.get("https://www.cleartrip.com");
	 
	}
	
	public void Destination(String From, String To) throws InterruptedException
	{
		//Thread.sleep(10000);
		Selenium.waitForPageLoaded();
		driver.findElement(By.xpath("//input[@placeholder='Where from?']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Where from?']")).sendKeys(From);
		if(From.equals("Bangalore"))
		{	
		driver.findElement(By.xpath("//p[contains(text(),'Bangalore, IN - Kempegowda International Airport (BLR)')]")).click();
		}
		else
		{
		  driver.findElement(By.xpath("//p[contains(text(),'Hyderabad, IN - Rajiv Gandhi International (HYD)')]")).click();
		}
		driver.findElement(By.xpath("//input[@placeholder='Where to?']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Where to?']")).sendKeys(To);
		Thread.sleep(1000);
		if(To.equals("Hyderabad"))
		{	
		driver.findElement(By.xpath("//p[contains(text(),'Hyderabad, IN - Rajiv Gandhi International (HYD)')]")).click();
		}
		else
		{
			driver.findElement(By.xpath("//p[contains(text(),'Bangalore, IN - Kempegowda International Airport (BLR)')]")).click();
		}
		 
			System.out.println("Destination is entered");
	}
	
	public void Selectdates(int bookingdates) throws InterruptedException
	{
		Selenium.waitForPageLoaded();
		driver.findElement(By.xpath("//div[@class='fs-4 fw-500 c-inherit flex flex-nowrap ml-4']")).click();
		Date date = new Date();
		int a = bookingdates;
		date.setDate(date.getDate()+ a);
		SimpleDateFormat df1 = new SimpleDateFormat("MMM dd yyyy");
		String formattedDate1 = df1.format(date);
		System.out.println(formattedDate1);
		Thread.sleep(1000);
		WebElement Traveldate = driver.findElement(By.xpath("//*[contains(@aria-label,'"+formattedDate1+"')]"));
		//Here i am using Javascriptexecuter to click on the calendar
		js.executeScript("arguments[0].click();", Traveldate);
		//driver.findElement(By.xpath("//*[contains(@aria-label,'"+formattedDate1+"')]")).click();
		System.out.println("Clicked on dates");
	}
	
	

	public void search_button()
	{
		driver.findElement(By.xpath("//span[contains(text(),'Search flights')]")).click();
	}
	
	public void Select_noof_passangers() throws InterruptedException
	{
		Selenium.waitForPageLoaded();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[contains(text(),'1 Traveller')]")).click();
		driver.findElement(By.xpath("(//*[@class='current-stroke c-blue c-pointer'])[1]")).click();
		driver.findElement(By.xpath("//*[contains(text(),'Update')]")).click();
	}
	
	public void Book() throws InterruptedException
	{
		Selenium.waitForPageLoaded();
		driver.findElement(By.xpath("(//button[contains(@class,'all button')])[2]")).click();
		Selenium.waitForPageLoaded();
		Set<String> handles = driver.getWindowHandles();
	    String currentHandle = driver.getWindowHandle();
	    for (String handle : handles) {

	     if (!handle .equals(currentHandle))
	     {
	         driver.switchTo().window(handle);
	     }
	   }
	   // driver.navigate().refresh();
	    Selenium.waitForPageLoaded();
		driver.findElement(By.xpath("//*[@class=' c-pointer c-neutral-900']")).click();
		driver.findElement(By.xpath("(//*[@class='c-neutral-200'])[1]")).click();
		WebElement Continue = driver.findElement(By.xpath("//button[contains(text(),'Continue')]"));
		js.executeScript("arguments[0].click();", Continue);
		Thread.sleep(1000);
		WebElement Skip =driver.findElement(By.xpath("//button[contains(text(),'Skip this step')]"));
		js.executeScript("arguments[0].click();", Skip);
	}
	
	
	
	
}
