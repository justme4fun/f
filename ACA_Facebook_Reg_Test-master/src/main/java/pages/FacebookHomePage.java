package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import basePage.PageObject;

public class FacebookHomePage extends PageObject {
	public final String URL = "https://web.facebook.com/";

	public FacebookHomePage(WebDriver driver) {
		super(driver);
		// Go to the Facebook page
		driver.get(URL);
	}

	@FindBy(xpath = "//input[@name='firstname']")
	WebElement firstnameElement;

	@FindBy(xpath = "//input[@name='lastname']")
	WebElement lastnameElement;

	@FindBy(xpath = "//input[@name='reg_email__']")
	WebElement regEmailElement;

	@FindBy(xpath = "//input[@name='reg_email_confirmation__']")
	WebElement regEmailConfirmationElement;

	@FindBy(xpath = "//input[@name='reg_passwd__']")
	WebElement regPasswordElement;

	@FindBy(xpath = "//select[@name='birthday_month']")
	Select birthdayMonthElement;

	@FindBy(xpath = "//select[@name='day']")
	Select dayElement;

	@FindBy(xpath = "//select[@name='year']")
	Select yearElement;

	@FindBy(xpath = "//button[@name='websubmit']")
	WebElement submitBtnElement;

	public FacebookEmailConfirmPage register(String firstname, String lastname, String email, String email2, String password,
			String month, String day, String year, boolean isMale) {
		// Input first name
		setInput(firstnameElement, firstname);

		// Input last name
		setInput(lastnameElement, lastname);

		// Input email
		setInput(regEmailElement, email);
		setInput(regEmailConfirmationElement, email2);
		
		// Input password
		setInput(regPasswordElement, password);
		

		// Set date drop down values
		setSelect(birthdayMonthElement, month);
		setSelect(dayElement, day);
		setSelect(yearElement, year);
		
		// Set gender
		int sex;
		if(isMale) {
			sex = 2;
		} else {
			sex = 1;
		}
		driver.findElement(By.xpath("//input[@name='sex' and @value='" + sex + "']")).click();

		// Submit registration form
		submitBtnElement.click();

		return new FacebookEmailConfirmPage(driver);
	}
	
	private void setInput(WebElement element, String value) {
		if(element != null && element.isDisplayed()) {
			element.click();
			element.sendKeys(value);
		}
	}
	
	private void setSelect(Select select, String value) {
		if(select != null) {
			select.selectByVisibleText(value);
		}
	}
}
