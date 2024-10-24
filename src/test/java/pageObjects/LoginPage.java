package pageObjects;

import org.openqa.selenium.WebDriver;

import driverSetup.TestContextSetup;

public class LoginPage {


	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		System.out.println("Inside LoginPage constructor");
		this.driver = driver;

	}

}
