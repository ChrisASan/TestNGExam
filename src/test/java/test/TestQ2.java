package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.TestQuesPage;
import util.BrowserFactory;

public class TestQ2 {
	
	WebDriver driver;
	TestQuesPage testQuesPage;
	
//	Test 2: Validate a user is not able to add a duplicated category. 
//	If it does then the following message will display: 
//	"The category you want to add already exists: <duplicated category name>."
	
	@BeforeTest	
	public void runBefore() {
		driver = BrowserFactory.init();
		testQuesPage = PageFactory.initElements(driver, TestQuesPage.class);
		TestQuesPage.waitTime();		
}
	
	@Test(priority=1)
	public void validateCategoryAddAndDisplay() {		
		testQuesPage.addACategory("cate1");
		testQuesPage.validateCategoryWasAdded("cate1");
	}
	
	@Test(priority=2)
	public void validateUserCannotAddDuplicatesAndDisplayAMessage() {
		testQuesPage.addACategory("cate1");
		TestQuesPage.waitTime();
		testQuesPage.categoryIsDupicate("cate1");
		TestQuesPage.waitTime();
		testQuesPage.categoryIsDeleted();
	}	
	
	@AfterTest
	public void runAfter() {
		BrowserFactory.tearDown();	
	}

}
