package com.kvm.sel;

import java.net.MalformedURLException;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;

public class NewTest {
	private WebDriver driver;
	//private static String driverPath = "C:\\Dev\\Selenium\\";
	int t1=0, t2=0, t3=0;

	@Test
	public void f() {
		//driver.get("https://www.google.co.in");
		double startTime1 = System.currentTimeMillis();
		driver.get("https://www.t-mobile.com");
		String title = driver.getTitle();
		if(new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body > header > nav > div.nav-right > div.nav-links > ul > li:nth-child(2) > a"))).isEnabled()==true)
		{
			t1=1;
		}
		double endTime1 = System.currentTimeMillis();
		double totalTime1 = (endTime1-startTime1)/1000;
		System.out.println("HomePageTransaction ("+ ((RemoteWebDriver) driver).getCapabilities().getBrowserName() + "-"  
				+ ((RemoteWebDriver) driver).getCapabilities().getVersion() 
				+ ") : " + totalTime1);
		
		//2
		double startTime01 = System.currentTimeMillis();
		//click on Phones				
		driver.findElement(By.cssSelector("body > header > nav > div.nav-right > div.nav-links > ul > li:nth-child(2) > a")).click();
		((JavascriptExecutor)driver).executeScript("scroll(0,1000)");
		if(new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"pdpLabels\"]/section/div[3]/div[2]/div[3]/browse-tile/div/a"))).isEnabled()==true)
		{
			t2=1;
		}
		
		double endTime01 = System.currentTimeMillis();
		double totalTime01 = (endTime01-startTime01)/1000;
		
		System.out.println("CellphonesPageTransaction ("+ ((RemoteWebDriver) driver).getCapabilities().getBrowserName() + "-"  
				+ ((RemoteWebDriver) driver).getCapabilities().getVersion() 
				+ ") : " + totalTime01);
		
/*		//3
		double startTime2 = System.currentTimeMillis();
		//click on iphone-X	
		driver.findElement(By.xpath("//*[@id=\"pdpLabels\"]/section/div[3]/div[2]/div[3]/browse-tile/div/div[2]/a/img")).click();
		// 5.6secs res if(new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"add-to-bag-btn\"]/div/div[1]/button"))).isEnabled())
		if(new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"promo-banner\"]/p"))).isEnabled())
		{
			t3=1;
		}
		double endTime2 = System.currentTimeMillis();
		double totalTime2 = (endTime2-startTime2)/1000;
	
		System.out.println("PhoneDetailsPageTransaction ("+ ((RemoteWebDriver) driver).getCapabilities().getBrowserName() + "-"  
				+ ((RemoteWebDriver) driver).getCapabilities().getVersion() 
				+ ") : " +totalTime2);*/
		
		AssertJUnit.assertTrue(title.contains("T-Mobile"));
	}

	@BeforeTest
	@Parameters({ "browser" })
	public void setUp(String browser) throws MalformedURLException {
		//System.setProperty("webdriver.chrome.driver", driverPath	+ "chromedriver.exe");
		// driver = new ChromeDriver();
		driver = Browser.getDriver(browser);
		//driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	@AfterTest
	public void afterTest() {
		//if (driver != null)
			driver.quit();
	}

}
