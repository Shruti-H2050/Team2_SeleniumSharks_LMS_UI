package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProgramPage extends BasePage {

	public ProgramPage(WebDriver driver) {
		super(driver);
	}

//----------------------WebElements-------------------------------

	@FindBy(xpath = "//span[text()='Program']")
	private WebElement programBtn;// programbutton

	@FindBy(xpath = "//div[@class='ng-star-inserted']/button[2]")
	private WebElement batchBtn;

	@FindBy(xpath = "//button[normalize-space()='Add New Program']")
	private WebElement addNewProgramBtn;

	@FindBy(xpath = "//div[normalize-space()='Manage Program']")
	private WebElement manageProgramTitle;

	@FindBy(xpath = "//input[contains(@placeholder,'Search')]")
	private WebElement searchTextBox;

	@FindBy(xpath = "//button[@id='editProgram']")
	private WebElement editIcon;

	@FindBy(xpath = "//span[text()='Program Details']")
	private WebElement programDetailsTitle;

	// ----------------Methods------------------

	public void clickProgramBtn() {
		programBtn.click();
	}

	public void clickAddNewProgramBtn() {
		addNewProgramBtn.click();
	}

	public void clicksearchTextBox() {
		searchTextBox.click();
	}

	public boolean manageProgramTitleDisplay() {
		boolean display = manageProgramTitle.isDisplayed();
		return display;
	}

	public void ClickBatchBtn() {
		batchBtn.click();
	}

}
