package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

//--------------------WebElement-------------------------------

	@FindBy(xpath = "//input[@id='username']")
	private WebElement userNameTextBox;

	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordTextBox;

	@FindBy(xpath = "//button[@id='login']")
	private WebElement loginBtn;

//---------------------Methods------------------------------------
	
	public void Login(String username, String password) {
		userNameTextBox.sendKeys(username);
		passwordTextBox.sendKeys(password);
		loginBtn.click();
	}

}
