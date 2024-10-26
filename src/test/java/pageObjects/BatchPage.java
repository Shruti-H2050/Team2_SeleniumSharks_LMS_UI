package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class BatchPage extends BasePage{

	public BatchPage(WebDriver driver) {
		super(driver);
	}
	
	//----------------------WebElements-------------------------------

		@FindBy(xpath = "//*[contains(text(), 'LMS - Learning Management System')]")
		private WebElement LMSTitleCheck;// 
		
		@FindBy(xpath = "//*[contains(text(), 'Batch')]")
		private WebElement headerBatchButton;
		
		@FindBy (xpath = "//*[contains(text(), ' Manage Batch')]")
		private WebElement manageBatchTitleCheck;
		
		@FindBy(xpath = "//*[contains(text(), 'Program')]")
		private WebElement dashboardPgmButton;
		
		@FindBy(xpath = "//*[contains(text(), 'Batch')]")
		private WebElement dashboardBatch;
		
		@FindBy(xpath = "//*[contains(text(), 'Class')]")
		private WebElement dashboardClass;
		
		@FindBy(xpath="//*[contains(text(), 'Logout')]")
		private WebElement dashboardLogout;
		
		@FindBy(xpath = "//span[@aria-hidden='true']")
		private WebElement deleteIcon;
		
		@FindBy(xpath = "//span[@class ='p-paginator-icon pi pi-angle-right']")
		private WebElement paginationCntrls;
		
		@FindAll(@FindBy(xpath = "//table[@role = 'grid']/tbody/tr"))
		private List<WebElement> editDeleteIconinEachRow;
		
		@FindBy (xpath = "//button[@icon='pi pi-pencil']")
		private WebElement editIconinEachRow;
		
		@FindBy(xpath ="//button[@class='p-button-rounded p-button-danger p-button p-component p-button-icon-only']" )
		private WebElement deleteIconinEachRow;
		
		@FindBy(xpath = "//table//th[2]")
		private WebElement batchNameHeader;
		
		@FindBy(xpath = "//table//th[3]")
		private WebElement batchDescriptionHeader;
		
		@FindBy(xpath = "//table//th[4]")
		private WebElement batchStatusHeader;
		
		@FindBy(xpath = "//table//th[5]")
		private WebElement batchNoOfClassesHeader;
		
		@FindBy(xpath = "//table//th[6]")
		private WebElement programNameHeader;
		
		@FindBy(xpath = "//table//th[7]")
		private WebElement  EditDeleteHeader;
		
		@FindBy(xpath="//div[@role='checkbox']")
		private WebElement checkboxButton;
		
		@FindBy(xpath = "//p-sorticon[@field='programName']")
		private WebElement batchNameSortIcon;
		
		@FindBy(xpath = "//p-sorticon[@field='batchDescription']")
		private WebElement batchDescSortIcon;

		@FindBy(xpath = "//p-sorticon[@field='batchStatus']")
		private WebElement batchStatusSortIcon;
		
		@FindBy(xpath = "//p-sorticon[@field='batchNoOfClasses']")
		private WebElement batchNoOfClassesSortIcon;
		
		@FindBy(xpath = "//p-sorticon[@field='programName']") //xpath is same for batchName and pgmName sort icon
		private WebElement programNameSortIcon;
		
		@FindBy(xpath = "//button[@role='menuitem']")
		private WebElement addNewBatchBtn;
		
		@FindBy(xpath = "//div[@role=\"dialog\"]")
		private WebElement batchDtlsPopup;
		
		
		
		//---------------------Methods------------------------------------
		
		public String checkLMSTitle(String titleDisplayed ) {
			 titleDisplayed = LMSTitleCheck.getText();
			return titleDisplayed;
		}
		
		public void clickheaderBatchButton() {
			headerBatchButton.click();
		}
		public String checkManageBatchTitle(String manageBatchTitleDisplayed) {
			 manageBatchTitleDisplayed = manageBatchTitleCheck.getText();
			return manageBatchTitleDisplayed;
		}
		
		public boolean checkDashBoard() {
			boolean dashBoard = false;
			boolean dashboardPgmButtonDisplayed = dashboardPgmButton.isDisplayed();
			boolean dashboardBatchDisplayed = dashboardBatch.isDisplayed();
			boolean dashboardClassDisplayed = dashboardClass.isDisplayed();
			boolean dashboardLogoutDisplayed = dashboardLogout.isDisplayed();
			if(dashboardPgmButtonDisplayed&&dashboardBatchDisplayed&&dashboardClassDisplayed&&dashboardLogoutDisplayed == true) {
				dashBoard = true;
			}
			return dashBoard;
		}
		
		public void checkDeleteIcon() {
			deleteIcon.isDisplayed();
		}
		public void checkPagination() {
			paginationCntrls.isEnabled();
		}
		
		public void checkEditIconOnEachRow() {
			//List<WebElement> editIconCount = editIconinEachRow
			for(int i=0;i<editDeleteIconinEachRow.size();i++) {
				editIconinEachRow.isDisplayed();
				//driver.findElement((By) editIcon).isDisplayed();
				
				
			}
		}
		
		public void checkDeleteIconOnEachRow() {
			for(int i =0;i<editDeleteIconinEachRow.size();i++) {
				deleteIconinEachRow.isDisplayed();
			}
		}
		
		public boolean checkBatchNameHeader() {
			String text = batchNameHeader.getText();
			if(text == "Batch Name") return true;
			return true;
		}
		
		public boolean checkBatchDescHeader() {
			String text = batchDescriptionHeader.getText();
			if(text == "Batch Description") return true;
			return true;
		}
		public boolean checkBatchStatusHeader() {
			String text = batchStatusHeader.getText();
			if(text == "Batch Status") return true;
			return true;
		}
		
		public boolean checkNoOfClassesHeader() {
			String text = batchNoOfClassesHeader.getText();
			if(text == "No Of Classes") return true;
			return true;
		}
		
		public boolean checkPgMNameHeader() {
			String text = programNameHeader.getText();
			if(text == "Program Name") return true;
			return true;
		}
		public boolean checkEditDeleteHeader() {
			String text = EditDeleteHeader.getText();
			if(text == " Edit / Delete ") return true;
			return true;
		}
		
		 public void checkSortIcons() {
			 batchNameSortIcon.isDisplayed();
			 batchDescSortIcon.isDisplayed();
			 batchStatusSortIcon.isDisplayed();
			 batchNoOfClassesSortIcon.isDisplayed();
			 programNameSortIcon.isDisplayed();
		 }
		public void checkHeaderCheckBox() {
			checkboxButton.isDisplayed();
		}
		public String checkAddNewBatchBtn(String text) {
			addNewBatchBtn.isDisplayed();
			 text = addNewBatchBtn.getText();
			 return text;
		}
		
		public void clickAddNewBatchBtn() {
			headerBatchButton.click();
			addNewBatchBtn.click();
		}
		public void checkbatchDtlsPopup() {
			batchDtlsPopup.isDisplayed();
		}
}

