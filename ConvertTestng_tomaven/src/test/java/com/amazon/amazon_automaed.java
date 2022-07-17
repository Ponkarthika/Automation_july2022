package com.amazon;

import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class amazon_automaed {

	WebDriver driver;
	
	@BeforeMethod
	public void Setup() {
	System.setProperty("webdriver.chrome.driver", "//Users//ponkarthika//Downloads//chromedriver");
	//to get ride of "your system is being controlled by test software msg
	ChromeOptions options= new ChromeOptions();
	options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
	
	
    driver = new ChromeDriver(options);
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
	}
	
	
	
		
	
	@Test
	
	public void login() throws InterruptedException {
		driver.get("https://www.amazon.in/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"nav-signin-tooltip\"]/a/span")).click();
		Thread.sleep(1000);
		WebElement element0=driver.findElement(By.xpath("//*[@id='ap_email']"));
		element0.sendKeys("8825549219");
		WebElement element1=driver.findElement(By.xpath("//input[@id='continue']"));
		element1.click();
		Thread.sleep(3000);
		
		//password screen
		/*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='ap_password']")));
		*/
		driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys("Happy@123");
		driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
		Thread.sleep(2000);
		
		//loggedin screen
		driver.findElement(By.xpath("//a[@id='nav-hamburger-menu']")).click();
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2000)"," ");
		Thread.sleep(5000);
		//Click on Women's fashion	
		WebElement element2=driver.findElement(By.xpath("//*[@id='hmenu-content']/ul[1]/li[18]/a"));
		element2.click();
		Thread.sleep(2000);
		
		//Click on Western wear
		WebElement element3=driver.findElement(By.xpath("//*[@id='hmenu-content']/ul[11]/li[4]/a"));
		element3.click();
		Thread.sleep(2000);
		
		//Click on Dresses & jumpsuits
		WebElement element4=driver.findElement(By.xpath("//*[@id='s-refinements']/div[2]/ul/li[5]"));
		element4.click();
		
		//click on the dress 
		WebElement element5=driver.findElement(By.xpath("//*[@id='search']//img[1]"));
		element5.click();
		Thread.sleep(2000);
		ArrayList <String> tabs=new ArrayList <String>(driver.getWindowHandles());
		
		driver.switchTo().window(tabs.get(1));
		
		//verify the add to cart is avaialable
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='add-to-cart-button']")));
		Thread.sleep(5000);
		boolean element6 =driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).isDisplayed();
		Assert.assertEquals(element6,true);
		
		
		//Click on ad to cart
		WebElement element7=driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
		element7.click();
		Thread.sleep(2000);
		
		//Proceed to buy
		WebElement element8= driver.findElement(By.name("proceedToRetailCheckout"));
		element8.click();
		Thread.sleep(4000);
		
		//Selecet the country drop down
		WebElement element91= driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-countryCode\"]/span/span"));
		element91.click();
		
		/*Select element9= new Select(driver.findElement(By.xpath("//*[@id=address-ui-widgets-countryCode-dropdown-nativeId]")));
		element9.selectByVisibleText("Iraq");
		Thread.sleep(2000);
		
		WebElement element92= driver.findElement(By.xpath("///*[@id='1_dropdown_combobox']/li[105]/a"));
		element92.click();
		*/
		
		//to navigate back
		driver.navigate().back();
		Thread.sleep(2000);
		
		//hoverover & click logout
		Actions action= new Actions(driver);
		WebElement element10=driver.findElement(By.xpath("//*[@id='nav-link-accountList']"));
		action.moveToElement(element10).build().perform();
		
		//Logout
		driver.findElement(By.xpath("//*[@id='nav-item-signout']/span")).click();
	}
		
		@AfterMethod
		public void Closebrowser() {
		driver.close();
		}
		
		
	
		
		

		
		
	
	
	


}




