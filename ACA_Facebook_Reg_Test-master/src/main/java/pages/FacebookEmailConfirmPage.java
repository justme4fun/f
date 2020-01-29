package pages;

import org.openqa.selenium.WebDriver;

import basePage.PageObject;

public class FacebookEmailConfirmPage extends PageObject {

	public FacebookEmailConfirmPage(WebDriver driver) {
		super(driver);
	}
	
	public boolean isConfirmPage() {
		String url = driver.getCurrentUrl();
		
		boolean result = url.contains("confirmemail");
		
		return result;
	}

}
