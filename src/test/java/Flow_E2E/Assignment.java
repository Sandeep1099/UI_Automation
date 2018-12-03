package Flow_E2E;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.base;

public class Assignment extends base{

	
	@BeforeTest

	public void initialize() throws IOException
	{
		
		 driver =initializeDriver();
			
		driver.get(prop.getProperty("url"));
	}
	
	
	@Test
	
	public void Excercise() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);   //implicit wait(global timeout) for the whole program in order to load the page properly
			
		//using Actions class for mouse hover
		Actions a= new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/header[1]/nav[1]/ul[1]/li[2]/a[1]"))).build().perform();
		
		driver.findElement(By.xpath("//a[contains(text(),'Accessories')]")).click();
		
		driver.findElement(By.xpath("//form[@name='product_40']//input[@value='Add To Cart']")).click();
		
		driver.findElement(By.xpath("//a[@title='Checkout']")).click();
		
		Assert.assertEquals(driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/article[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[2]/td[3]/form[1]/input[1]")).getAttribute("value"),"1");
				
		driver.findElement(By.xpath("//span[contains(text(),'Continue')]")).click();
		  				
		// provide mandatory billing fields
		
		driver.findElement(By.xpath("//input[@id='wpsc_checkout_form_9']")).sendKeys("sandeep1099@gmail.com");
		
		driver.findElement(By.xpath("//input[@id='wpsc_checkout_form_2']")).sendKeys("Sandeep");
		
		driver.findElement(By.xpath("//input[@id='wpsc_checkout_form_3']")).sendKeys("Kumar");
		
		driver.findElement(By.xpath("//textarea[@id='wpsc_checkout_form_4']")).sendKeys("106 Sandyshores dr");
		
		driver.findElement(By.xpath("//input[@id='wpsc_checkout_form_5']")).sendKeys("Brampton");
		
		//using select class for static dropdowns
		Select s=new Select(driver.findElement(By.xpath("//select[@id='wpsc_checkout_form_7']")));
		s.selectByVisibleText("Canada");
		
		driver.findElement(By.xpath("//input[@id='wpsc_checkout_form_6']")).sendKeys("ON");
		
		driver.findElement(By.xpath("//input[@id='wpsc_checkout_form_18']")).sendKeys("6478210065");
		
		driver.findElement(By.xpath("//input[@id='shippingSameBilling']")).click();
			
		driver.findElement(By.xpath("//input[@value='Purchase']")).click();
										
	   //explicit wait in order to load the page completely
		WebDriverWait wait=new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.titleContains("Transaction Results"));
		
		//In order to confirm that you have landed on transactions page		
		String expectedTitle="Transaction Results | ONLINE STORE";
		String actualTitle=driver.getTitle();
		Assert.assertEquals(actualTitle,expectedTitle);
		System.out.println(actualTitle);
		
		// In order to confirm that you have placed the Order in ‘Transaction Results’ page
		String expected_message="Thank you, your purchase is pending. You will be sent an email once the order clears.";
		String actual_message=driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/article[1]/div[1]/div[2]/p[1]")).getText();
		Assert.assertEquals(actual_message,expected_message);
		System.out.println(actual_message);
				
	}

	@AfterTest
	public void aftertest()
	{
		
		driver.close();
		driver=null;
		
	}

}
