package com.test;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTest {

	/*###################TestNG.XML####################
	 * Testng.xml contains cofiguration file  of tests in the class. like in which order test execute, how many times you want to execute
	 * it allow to cntrol flow of test case execution.
	 * Testng run test on alphabetic order by default. if test order execution is not provided in testng.xml file.
	 *
		*/
	@Test
	public void TestGoogle() throws InterruptedException {

		WebDriverManager.chromedriver().setup(); //this will setup chromebrowser.
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("Hardik Patel");
		Thread.sleep(5000);
		driver.quit();

	}
	@Test
	public void TestFacebook() throws InterruptedException {

		WebDriverManager.chromedriver().setup(); 
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.name("email")).sendKeys("Hardik Patel");
		Thread.sleep(5000);
		driver.quit();

	}


}
