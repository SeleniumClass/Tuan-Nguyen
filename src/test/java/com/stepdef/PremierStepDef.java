package com.stepdef;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ClubsExcelData.ExcelColumn;
import com.pagefactory.Pagefactory_Premier_League;
import com.util.Highlighter2;
import com.util.Screenshot2;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PremierStepDef {
	 
	static WebDriver driver;
	static Pagefactory_Premier_League pg;
	static JavascriptExecutor js;
	static ArrayList<String> clubNames = new ArrayList<String>();
	static ArrayList<String> ColumnValue= new ArrayList<String>();
	static String excelPath="./TestData/WebTable Test Data.xlsx";

@BeforeTest
	@Given("^Users are able to open the Chrome browser$")
	public void users_are_able_to_open_the_Chrome_browser() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C://Users//TUANNGUYEN//eclipse-workspace//seleniumAutomation//Driver//chromedriver.exe");
		driver = new ChromeDriver(); 
		js = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	   
	}
@BeforeMethod
	@Given("^Locate URL: https://www\\.premierleague\\.com/tables and press on Enter button$")
	public void locate_URL_https_www_premierleague_com_tables_and_press_on_Enter_button() throws Throwable {
		driver.get("https://www.premierleague.com/tables");
		pg = PageFactory.initElements(driver, Pagefactory_Premier_League.class);
	   
	}

	@When("^Users enter the table page$")
	public void users_enter_the_table_page() throws Throwable {
	    pg.getcookie().click();
	    Thread.sleep(3000);
	   
	}

	@Then("^Users are able to see the club names highlighted in red boxes$")
	public void users_are_able_to_see_the_club_names_highlighted_in_red_boxes() throws Throwable {
		for(WebElement a: pg.getclub()) {
			Highlighter2.getDrawRedColor(driver, a);
		}
		
		for(WebElement a: pg.getclub()) {
			js.executeScript("arguments[0].scrollIntoView();",a);
			Thread.sleep(500);
		}
		
	js.executeScript("window.scrollBy(0, -1000)", "");
	}
@Test(priority =0)
	@Then("^Observe the total number of clubs$")
	public void observe_the_total_number_of_clubs() throws Throwable {
		int num = pg.getclub().size();
		System.out.println(num);
	   
	}
@Test(priority =1)
	@Then("^Observe all the club names$")
	public void observe_all_the_club_names() throws Throwable {
	 for(WebElement club: pg.getclub()) {
		 clubNames.add(club.getText().toString());
	 }
	 System.out.println(clubNames);
	}
@AfterMethod
	@When("^Users highlight the club Chelsea$")
	public void users_highlight_the_club_Chelsea() throws Throwable {
		//act.dragAndDrop(pg.getdrag(), pg.getdrop()).build().perform();
		js.executeScript("function selectElementContents(el) {var range = document.createRange();range.selectNodeContents(el); var sel = window.getSelection(); sel.removeAllRanges(); sel.addRange(range);} var el = document.querySelector('#mainContent > div > div.mainTableTab.active > div.allTablesContainer > div > div > div > table > tbody > tr:nth-child(11) > td.team > a > span.long');selectElementContents(el);");
	   Thread.sleep(2000);
	}
@Test(priority =2)
	@Then("^Users are able to see Chelsea highlighted in a blue box$")
	public void users_are_able_to_see_Chelsea_highlighted_in_a_blue_box() throws Throwable {
	
		for(WebElement a: pg.getclub()) {
			if(a.getText().equalsIgnoreCase("Chelsea")) {
				System.out.println("Chelsea is there");
				Highlighter2.getDrawBlueColor(driver,a);
			
		}
		}
//		for(String club: clubNames) {
//			if(club.equalsIgnoreCase("Chelsea")) {
//				System.out.println("Test passed: Club Name Found =" + club);
//				Highlighter2.getDrawBlueColor(driver, club);
//				break;
//			}
//		}
		
	   
	}
@Test(priority =3)
	@Then("^See Chelsea position is '6' highlighted in a blue box$")
	public void see_Chelsea_position_is_highlighted_in_a_blue_box() throws Throwable {
		for(WebElement b: pg.getposition()) {
			if( pg.getposition().indexOf(b) + 1 == 6) {
				System.out.println(pg.getposition().indexOf(b) + 1 == 6);
				System.out.println("Chelsea poistion is " + (pg.getposition().indexOf(b)+1));
				Highlighter2.getDrawBlueColor(driver, b);
			}
			}
	}
@BeforeMethod	
	@When("^Users import excel sheet of the clubs names$")
	public void users_import_excel_sheet_of_the_clubs_names() throws Throwable {
		ColumnValue=ExcelColumn.columnValue(excelPath, 0);
		System.out.println("Value:"+ColumnValue);
	}
@Test(priority=4)
	@Then("^Users are able to validate all clubs names from web table with excel clubs names$")
	public void users_are_able_to_validate_all_clubs_names_from_web_table_with_excel_clubs_names() throws Throwable {
		
		for(int i=0; i< ColumnValue.size(); i++) {
			if(clubNames.contains(ColumnValue.get(i))) {
				System.out.println("Exist: "+ ColumnValue.get(i));
			} else {
				System.out.println("Not Exist: " + ColumnValue.get(i));
			}
		}
	}
@AfterMethod
	@Then("^Take a screenshot of the page$")
	public void take_a_screenshot_of_the_page() throws Throwable {
		Screenshot2.captureScreenShot(driver, "Chelsea page");   
	   
	}
@AfterTest
	@Then("^Close the browser$")
	public void close_the_browser() throws Throwable {
	    driver.quit();
	   
	}

}
