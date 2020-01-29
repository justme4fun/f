package util;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BasePage {
	protected WebDriver driver;

	@BeforeClass // Runs this method before the first test method in the current class is invoked
	public void setUp() {
		System.setProperty("webdriver.gecko.driver", "D:\\ProgramFiles\\geckodriver-v0.20.0-win64\\geckodriver.exe");
		
		// Create a new instance of the Firefox driver
		driver = new FirefoxDriver();
		
		// Put an Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception		 
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	
	/**
	 * 
	 * @param length
	 * 
	 * @return random email
	 */
	public String generateEmail(int length) {
		String allowedChars = "abcdefghijklmnopqrstuvwxyz" + // alphabets
				"1234567890" + // numbers
				"_-."; // special characters

		String temp = RandomStringUtils.random(length, allowedChars);

		String email = temp.substring(0, temp.length() - 8) + "@mail.ru";

		return email;
	}
	
	/**
	 * 
	 * @param length
	 * 
	 * @return random password
	 */
	public String generatePassword(int length) {
		String allowedChars = "abcdefghijklmnopqrstuvwxyz" + // alphabets
				"1234567890" + // numbers
				"_-.@#$%"; // special characters
		
		return RandomStringUtils.random(length, allowedChars);
	}

}
