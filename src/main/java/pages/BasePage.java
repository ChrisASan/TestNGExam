package pages;

import org.openqa.selenium.WebDriver;

public class BasePage {
	
	WebDriver driver;
	
	public void dashboardPage(WebDriver driver) {
		this.driver = driver;
	}
	

	public static void waitTime() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}
	
	
}
