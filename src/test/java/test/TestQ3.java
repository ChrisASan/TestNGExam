package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.TestQuesPage;
import util.BrowserFactory;

public class TestQ3 {
	
	WebDriver driver;
	TestQuesPage testQuesPage;
	
//	Test 3: Validate the month drop down has all 
//	the months (jan, feb, mar ...) in the Due Date dropdown section.
	
	@BeforeTest	
	public void runBefore() {
		driver = BrowserFactory.init();
		testQuesPage = PageFactory.initElements(driver, TestQuesPage.class);
		TestQuesPage.waitTime();		
}
	
	@Test(priority=1)
	public void validateMonthDropDownHasAllMonths() {
//		testQuesPage.monthDropDown("Jan");
		testQuesPage.monthDropDown();
	}
	
	@AfterTest
	public void runAfter() {
		BrowserFactory.tearDown();	
	}

}
