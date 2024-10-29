package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClassPage extends BasePage{

	public ClassPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//span[text()='Class']")
	private WebElement classBtn;
	
	@FindBy(xpath = "//div[normalize-space()='Manage Class']")
	private WebElement manageClassTitle;
	
	@FindBy(xpath = "//td//span[@class='p-button-icon pi pi-trash']")
	private WebElement deleteIcons;
	
	 @FindBy(xpath =("//*[contains(text(),'Confirm')]"))
		private WebElement deleteAlertPopUpHeadingCheck;
		 
	 @FindBy(xpath = "//td//span[@class=\"p-button-icon pi pi-trash\"]")
		private WebElement tddeleteIcon;
	 
	 @FindBy(xpath ="//button[@type='button' and @ng-reflect-label='Yes']" )
		private WebElement deleteYesBtn;
	 
		@FindBy (xpath="//div[text()='Successful']")
		private WebElement deleteSuccessMessage;
		
		@FindBy(xpath ="//button[@type=\"button\" and @ng-reflect-label=\"No\"]" )
		private WebElement deleteNoBtn;
		
		@FindBy (xpath="//span[@class='pi pi-times ng-tns-c204-117']")
		private WebElement deletealertcross;
		
		@FindBy (xpath="//input[@id='filterGlobal']")
		private WebElement searchbox;
		
		
		@FindBy (xpath="//div[@role='checkbox' and @class='p-checkbox-box']")
		private WebElement checkboxSelected;
		
		
		@FindBy (xpath="//div[@class='box']//span[@class='p-button-icon pi pi-trash' and @aria-hidden='true']")
		private WebElement headerdeleteIcon;
		
		@FindBy (xpath="//button[@class='p-button-danger p-button p-component p-button-icon-only']")
		private WebElement deleteButton;

	public void clickClassBtn() {
		classBtn.click();
	}
	public boolean manageClassTitleDisplay() {
		return isElementDisplayed(manageClassTitle);
	}
	private boolean isElementDisplayed(WebElement element) {
		try {
			return element.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public void clickdeleteIcons() {
		deleteIcons.click();
	}
	public void confirmDialog() {
		deleteAlertPopUpHeadingCheck.isDisplayed();
	}
	public void clicktddeleteIcon() {
		tddeleteIcon.click();
	}
	public void clickDeletYesBtn() {
		deleteYesBtn.click();
	}
	public void deleteSuccessMessage() {
		deleteSuccessMessage.isDisplayed();
	}
	public void clickDeletNoBtn() {
		deleteNoBtn.click();
	}
	public void deletealertcross() {
		deletealertcross.click();
	}
	public boolean searchbox() {
		
		searchbox.sendKeys("team7");
		if(searchbox.getText() == "team7")return true;
		return true;
	}
	public void checkboxSelected() {
		checkboxSelected.isSelected();
	}
	
	public void headerdeleteIcon() {
		headerdeleteIcon.isEnabled();
	}
	
	public void clickMultipleCheckBoxesOfProgramTable(int NoOfBoxesToSelect) {
		int i = NoOfBoxesToSelect;
		WebElement checkBox = driver.findElement(By.xpath("(//tbody[@class='p-datatable-tbody']//div[@role='checkbox'])["+i+"]"));
		JavascriptExecutor jsv = (JavascriptExecutor)driver;
		jsv.executeScript("arguments[0].click()",checkBox);
}
	public void clickTopLeftDeleteIcon() {
		deleteButton.click();
	}
}