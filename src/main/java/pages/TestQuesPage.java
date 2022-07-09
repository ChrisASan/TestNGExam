package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class TestQuesPage extends BasePage {

	WebDriver driver;

//	WebElement list

	@FindBy(how = How.CSS, using = "input[name='categorydata']")
	WebElement CATEGORY_INPUT_BOX_ELEMENT;
	@FindBy(how = How.CSS, using = "input[value='Add category']")
	WebElement CATEGORY_SUBMIT_BUTTON_ELEMENT;
	@FindBy(how = How.CSS, using = "select[name='due_month']")
	WebElement MONTH_DROPDOWN_ELEMENT;
	@FindBy(how = How.LINK_TEXT, using = "cate1")
	WebElement CATEGORY_CREATED_ELEMENT;
	@FindBy(how = How.LINK_TEXT, using = "Nevermind")
	WebElement NEVERMIND_ELEMENT;
	@FindBy(how = How.LINK_TEXT, using = "Yes")
	WebElement YES_ELEMENT;

//	Methods 	

	public void addACategory(String category) {
		CATEGORY_INPUT_BOX_ELEMENT.sendKeys(category);
		CATEGORY_SUBMIT_BUTTON_ELEMENT.click();
	}
	

	public void validateCategoryWasAdded(String category) {
		if (CATEGORY_CREATED_ELEMENT.isDisplayed()) {
			System.out.println("The category was added");
		}
		else {
			System.out.println("The category was NOT added");
		}
	}
	
	public void categoryIsDupicate(String category) {
		if (NEVERMIND_ELEMENT.isDisplayed()) {
			System.out.println("The category you want to add already exists:" + category);
			NEVERMIND_ELEMENT.click();
			CATEGORY_INPUT_BOX_ELEMENT.clear();			
		}
		else {
			System.out.println("The category was added");
		}		
	}
	
	public void categoryIsDeleted() {
		if (CATEGORY_CREATED_ELEMENT.isDisplayed()) {
			CATEGORY_CREATED_ELEMENT.click();
			YES_ELEMENT.click();
		}
		else {
			System.out.println("Category element exist");
		}
		
	}
	
// --------------------------------------------------------------------------
	
	public void monthDropDown(String Month) {
		Select sel = new Select(MONTH_DROPDOWN_ELEMENT);
//		sel.selectByVisibleText(Month);
		sel.getOptions();
		for (WebElement element: sel.getOptions()) {
			System.out.println(element.getText());
			
		}
		
	}
	
	public void monthDropDown() {
		List<String> actualValue = new ArrayList<String>();
		Select sel = new Select(MONTH_DROPDOWN_ELEMENT);
		for (WebElement element: sel.getOptions()) {
			actualValue.add(element.getText());		
		}
		List<Object> expectedValues = new ArrayList<>();
		expectedValues.add("None");	
		expectedValues.add("Jan");	
		expectedValues.add("Feb");	
		expectedValues.add("Mar");	
		expectedValues.add("Apr");	
		expectedValues.add("May");	
		expectedValues.add("Jun");	
		expectedValues.add("Jul");	
		expectedValues.add("Aug");	
		expectedValues.add("Sep");	
		expectedValues.add("Oct");	
		expectedValues.add("Nov");	
		expectedValues.add("Dec");	
		
		for (int i = 0; i < actualValue.size(); i++) {
			
//			System.out.println("Actual " + actualValue.get(i) + " And Expected " + expectedValues.get(i));
			Assert.assertTrue(actualValue.get(i).equals(expectedValues.get(i)));
		}
		
		
		
	}

}
