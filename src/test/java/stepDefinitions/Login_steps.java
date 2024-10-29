package stepDefinitions;

import org.testng.Assert;

import driverSetup.TestContextSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;

public class Login_steps {

	private TestContextSetup context;// pico
	private LoginPage loginPage;

	public Login_steps(TestContextSetup context) {
		this.context = context;
		this.loginPage = context.getLoginPage();
	}
	
}