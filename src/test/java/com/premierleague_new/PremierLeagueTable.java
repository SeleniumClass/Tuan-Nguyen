package com.premierleague_new;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.util.Highlighter2;

import com.pagefactory.Pagefactory_Premier_League;

public class PremierLeagueTable {
	@Test
	public static void main(String[] args) throws Throwable  {
		
	
	System.setProperty("webdriver.chrome.driver", "C://Users//TUANNGUYEN//eclipse-workspace//seleniumAutomation//Driver//chromedriver.exe");
	WebDriver driver = new ChromeDriver(); 
	JavascriptExecutor js = (JavascriptExecutor) driver;
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("https://www.premierleague.com/tables");
	driver.manage().window().maximize();
	Pagefactory_Premier_League abc = PageFactory.initElements(driver, Pagefactory_Premier_League.class);
	
	//handle cookies notice
	//WebElement cookie = driver.findElement(By.xpath("//*[@class = \"btn-primary cookies-notice-accept\"]"));
	abc.getcookie().click();
	Thread.sleep(3000);
	
	//grab all club names club count 
	for(int i = 0; i< abc.getclub().size(); i++) {
	Highlighter2.getDrawRedColor(driver,abc.getclub().get(i));

	}
	for(int i = 0; i< abc.getclub().size(); i++) {
		js.executeScript("arguments[0].scrollIntoView();",abc.getclub().get(i));
		Thread.sleep(500);
	}
	
js.executeScript("window.scrollBy(0, -1000)", "");
	//print number of club
	int num = abc.getclub().size();
	System.out.println(num);
	//print all the club names
	for(int i =0; i < num; i++) {
	System.out.println(abc.getposition().get(i).getText() + ". "+ abc.getclub().get(i).getText());

		}
	
	//verifying Chelsea is present
	
	//Actions act = new Actions(driver);
	//WebElement drop = driver.findElement(By.xpath("(//*[contains(text(), 'Chelsea')])[3]"));
	//WebElement drag = driver.findElement(By.xpath("//*[@class ='badge-25 t8']"));
	//act.dragAndDrop(abc.getdrag(), abc.getdrop()).build().perform();
	
	js.executeScript("function selectElementContents(el) {var range = document.createRange();range.selectNodeContents(el); var sel = window.getSelection(); sel.removeAllRanges(); sel.addRange(range);} var el = document.querySelector('#mainContent > div > div.mainTableTab.active > div.allTablesContainer > div > div > div > table > tbody > tr:nth-child(11) > td.team > a > span.long');selectElementContents(el);");
	
	for(int i=0; i <num; i++) {
	if(abc.getclub().get(i).getText().equalsIgnoreCase("Chelsea")) {
		System.out.println("Chelsea is there");
		Highlighter2.getDrawBlueColor(driver,abc.getclub().get(i));
		
	}
	//verifying Chelsea position is 6
	if(abc.getposition().get(i).getText().equalsIgnoreCase("6")) {
		System.out.println("Chelsea's position is " + abc.getposition().get(i).getText());
		Highlighter2.getDrawBlueColor(driver,abc.getposition().get(i));
	}
	//Screenshot1.captureScreenShot(driver, ScreenShotName);
		
}
}

}
