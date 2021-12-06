package com.searchfunctionality.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {

	public String baseUrl = "https://www.autohero.com/de/search/";
	public static WebDriver driver;
	ChromeOptions options = new ChromeOptions();
    
    
	@BeforeClass
	public void setup() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","//Users//vidhyasagar//eclipse-workspace//autoIT_SearchFunctionality_V1//Driver//chromedriver");
		driver = new ChromeDriver(options);
		Thread.sleep(1000);
		driver.manage().window().maximize();

		driver.get(baseUrl);
	    Thread.sleep(1000);
        By cookies_accept = By.xpath("/html/body/div[3]/div/form/div[2]/button[2]");
       
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(cookies_accept)).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(cookies_accept));
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
