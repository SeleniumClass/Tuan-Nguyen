package com.pagefactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Pagefactory_Premier_League {
	WebDriver driver;
	public Pagefactory_Premier_League(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(how = How.XPATH, using = "//*[@class =\"tableBodyContainer\"]/tr/td[3]/a/span[2]")
	//@CacheLookup using cache memory to run the annotation @ faster
	private List<WebElement> club;
	
	@FindBy(how = How.XPATH, using = "//*[@class =\"tableBodyContainer\"]/tr/td[2]/span[1]")
	//@CacheLookup using cache memory to run the annotation @ faster
	private List<WebElement> position;
	
	@FindBy(how = How.XPATH, using = "//*[@class = \"btn-primary cookies-notice-accept\"]")
	//@CacheLookup using cache memory to run the annotation @ faster
	private WebElement cookie;
	
	@FindBy(how = How.XPATH, using = "(//*[contains(text(),'Chelsea')])[3]")
	//@CacheLookup using cache memory to run the annotation @ faster
	private WebElement chelsea;

	public List<WebElement> getclub() {
		return club;
	}
	public List<WebElement> getposition() {
			return position;
	}
	public WebElement getcookie() {
		return cookie;

}
	public WebElement getchelsea() {
		return chelsea;
	}
}

