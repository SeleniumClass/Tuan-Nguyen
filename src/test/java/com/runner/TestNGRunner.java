package com.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		plugin= {"pretty","html:target/cucumber", "json:target/cucumber.json"},
		
		
		features= {"src/main/resources/PremierLeague.feature"},
		glue= {"com.stepdef"},
				
		tags= {"@smoke"},
		
		monochrome=true,
				strict=true
				///dryRun=true
		)
public class TestNGRunner extends AbstractTestNGCucumberTests {

}
