package com.searchfunctionality.pageObjects;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SearchPage {

	WebDriver ldriver;
	
	public SearchPage(WebDriver rdriver){
		
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy(xpath="//button[@id='carMakeFilter']")
	WebElement brandDropdown;
	
	@FindBy(xpath="//body/div[@id='app']/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li/input[1]")
	List<WebElement> brandList;
	
	@FindBy(xpath="//body/div[@id='app']/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li/input")
	List<WebElement> makeList;
	
	@FindBy(xpath="//span[contains(text(),'Kilometer')]")
	WebElement kilometerDropdown;
	
	@FindBy(xpath="//body/div[@id='app']/div[1]/main[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]")
	WebElement resultsDiv;
	
	@FindBy(xpath="//body/div[@id='app']/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[3]/select[1]")
	WebElement maxKilometer;
	
	@FindBy(xpath="//body/div[@id='app']/div[1]/footer[1]/div[1]/div[1]/div[1]/img[1]")
	WebElement logo;
	
	@FindBy(xpath="//input[@value='Up!']")
	WebElement upButton;
	
	@FindBy(xpath="//body/div[@id='app']/div[1]/main[1]/div[1]/button[1]/*[1]")
	WebElement mainUpButton;

	public void clickBrandDropdown() {
		brandDropdown.click();
	}
	
	public void selectBrand() {
		
		for (WebElement we:brandList) {
			if(we.getAttribute("value").contains("Volkswagen")) {
				we.click();
			}
		}
	}		
	
	public void selectMake() { 
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(ldriver,10);
		wait.until(ExpectedConditions.visibilityOf(upButton));
		
		for(WebElement w:makeList) {
			if(w.getDomAttribute("value").contains("Golf")) {
				w.click();
			}
		}
	}
	
	
	public void selectKilometerRange() {
		
		kilometerDropdown.click();
		Select select = new Select(maxKilometer);
		select.selectByVisibleText("25.000 km");
		kilometerDropdown.click();
	}
	
	public void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) ldriver;
		js.executeScript("arguments[0].scrollIntoView();", logo);
		
	}
	
	public void moveToTop() {
		mainUpButton.click();
	}
	
}