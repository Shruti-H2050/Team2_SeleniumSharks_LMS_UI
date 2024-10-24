package pageObjects;

import org.openqa.selenium.WebDriver;

import driverSetup.TestContextSetup;

public class LoginPage {
//	WebDriver driver;
//	WebDriverWait wait;

	private WebDriver driver;

	// private TestContextSetup context;
	public LoginPage(WebDriver driver) {

		System.out.println("Inside LoginPage constructor");
//		this.context=context;
//		context.getDriver().get("url");
		this.driver = driver;
//		PageFactory.initElements(driver, this);
//		wait = new WebDriverWait(this.driver, Duration.ofSeconds(1));
	}

}
