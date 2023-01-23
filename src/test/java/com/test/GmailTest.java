package com.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class GmailTest {
	WebDriver driver;

	/*
	 * @Test public void GoToGmailURL() throws InterruptedException {
	 * WebDriverManager.chromedriver().setup(); //this will setup chromebrowser.
	 * driver = new ChromeDriver(); //this.driver=driver;
	 * driver.manage().window().maximize(); driver.get("https://www.gmail.com/");
	 * //Thread.sleep(2000)
	 * 
	 * 
	 * 
	 * }
	 */
	@BeforeMethod
	public void setupBrowser() throws InterruptedException {
		WebDriverManager.chromedriver().setup(); // this will setup chromebrowser.
		driver = new ChromeDriver();
		// this.driver=driver;
		driver.manage().window().maximize();
		driver.get("https://www.gmail.com/");
		Thread.sleep(5000);
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

	@Test(dataProvider = "getLoginData", dataProviderClass = ExcelDataSupplier.class)
	public void LoginDetails(String email, String password) throws InterruptedException {

			/*	if(email.contains("testingproject074")) {*/
				WebElement emailTextbox = driver.findElement(By.xpath("//input[contains(@name,\"identifier\")]"));
				
				emailTextbox.sendKeys(email);
				driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button")).click(); 
				
				String actulUrl ="https://accounts.google.com/v3/signin/identifier?"; 
				boolean expectedUrl= driver.getCurrentUrl().contains(actulUrl);
				System.out.println(expectedUrl);
				Assert.assertTrue(expectedUrl);
				
				Thread.sleep(5000);
				WebElement passwordTextbox =driver.findElement(By.xpath("//input[contains(@name,\"Passwd\")]"));
				passwordTextbox.sendKeys(password);
				driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button")).click();
				
				
		
				
				
				/*
				 * else { Thread.sleep(4000);
				 * 
				 * 
				 * String actulUrl ="https://mail.google.com/mail/u/0/#inbox"; String
				 * expectedUrl= driver.getCurrentUrl();
				 * Assert.assertEquals(actulUrl,expectedUrl); }
				 */


	}	

	//System.out.println("sucessfully login");

	//*[@id="identifierNext"]/div/button

	//dataprovider is container of data that feeds to testmethod. 
	//dataprovider feed as parameterized data in to testmethod. 
	/*
	 * @DataProvider(name = "loginTestData") public void loginData() {
	 * 
	 * }
	 */

}
