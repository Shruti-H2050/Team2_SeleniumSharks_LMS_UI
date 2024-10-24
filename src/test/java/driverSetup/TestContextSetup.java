package driverSetup;

import org.openqa.selenium.WebDriver;

import lombok.Data;
import pageObjects.LoginPage;

@Data
public class TestContextSetup {
	
	private BaseClass baseClass;// pico
	private WebDriver driver;
	LoginPage loginPage;

	public TestContextSetup(BaseClass baseClass) {
		this.baseClass = baseClass;
		this.driver = baseClass.WebDriverManager();

	}

	public void launchUrl() {
		//driver.get("url);
		driver.get(baseClass.getUrl());
	}

	public void launchBrowser() {
//		driver.get(baseClass.getBrowser());
		baseClass.getBrowser();
	}

	public LoginPage getLoginPage() {
		if (loginPage == null) {
			loginPage = new LoginPage(driver);
		}
		return loginPage;
	}

}
