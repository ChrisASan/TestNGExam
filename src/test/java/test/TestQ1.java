package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.TestQuesPage;
import util.BrowserFactory;

public class TestQ1 {
	
	WebDriver driver;
	TestQuesPage testQuesPage;
	
//	Test 1: Validate a user is able to add a category 
//	and once the category is added it should display.
	@BeforeTest	
	public void runBefore() {
		driver = BrowserFactory.init();
		TestQuesPage.waitTime();
}
	
	@Test
	public void validateCategoryAddAndDisplay() {
		testQuesPage = PageFactory.initElements(driver, TestQuesPage.class);
		testQuesPage.addACategory("cate1");
		testQuesPage.validateCategoryWasAdded("cate1");
	}
	
	
	
	@AfterTest
	public void runAfter() {
		BrowserFactory.tearDown();	
	}

}
