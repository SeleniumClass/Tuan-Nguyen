package com.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Highlighter2 {
static JavascriptExecutor js;
	
	
	public static WebElement getDrawRedColor(WebDriver driver, WebElement Element ){
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='3px solid red'", Element);
		
		return Element;
		
}
	public static WebElement getDrawBlueColor(WebDriver driver, WebElement a ){
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='3px solid blue'", a);
		
		return a;
		

}

}
