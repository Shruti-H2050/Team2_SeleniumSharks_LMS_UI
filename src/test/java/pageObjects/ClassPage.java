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
		
		@FindBy (xpath="//button[@icon='pi pi-pencil']")
		private WebElement editIcon;
		
		@FindBy (xpath="//p-dialog[@header='Class Details' and @ng-reflect-visible='true']")
		private WebElement editDialog;
		
		
		@FindBy (xpath="//input[@type='text' and 'disabled' and@placeholder='Select a Batch Name']")
		private WebElement BtchNameFieldDisabledforediting;
		//input[@id='classTopic' and 'disabled']

		@FindBy (xpath="//input[@id='classTopic' and 'disabled']")
		private WebElement classTopicFieldDisabledforediting;
		
		
		@FindBy (xpath="//input[@id='classDescription']")
		private WebElement classDescField;
		
		
		@FindBy (xpath="//input[@id='classComments']")
		private WebElement classCmntsField;
		
		@FindBy (xpath="//button[@label='Save']")
		private WebElement saveBtn;
		
		@FindBy (xpath="//*[contains(text(), 'Successful')]")
		private WebElement succMsg;
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
	public void clickeditIcon() {
		editIcon.click();
	}
	public void editDialog() {
		editDialog.isDisplayed();
	}
	public void pgmFieldDisabledforediting() {
		BtchNameFieldDisabledforediting.isDisplayed();
	}
	public void classTopicFieldDisabledforediting() {
		classTopicFieldDisabledforediting.isDisplayed();
	}
	public void classDescField() {
		classDescField.sendKeys("test");
	}
	public void classCmntsField() {
		classCmntsField.sendKeys("hello");
	}
	public void clickSave() {
		saveBtn.click();
	}
	public void succMsg() {
		succMsg.isDisplayed();
	}
}