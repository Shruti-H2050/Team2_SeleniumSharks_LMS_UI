package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.LoggerLoad;


import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;



public class ClassPage extends BasePage {
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


	//**********WEBELEMENTS**********
	@FindBy(xpath = "//span[text()='Class']")
	private WebElement classBtn;

	@FindBy(xpath = "//button[normalize-space()='Add New Class']")
	private WebElement addNewClassBtn;

	@FindBy(xpath = "//div[normalize-space()='Manage Class']")
	private WebElement manageClassTitle;

	@FindBy(xpath = "//input[contains(@placeholder,'Search')]")
	private WebElement searchTextBox;

	@FindBy(xpath = "//span[normalize-space()='LMS - Learning Management System']")
	private WebElement lmsTitle;

	@FindBy(xpath = "//th[normalize-space()='Batch Name']")
	private WebElement batchNameHeader;

	@FindBy(xpath = "//th[normalize-space()='Class Topic']")
	private WebElement classTopicHeader;

	@FindBy(xpath = "//th[normalize-space()='Class Description']")
	private WebElement classDescriptionHeader;

	@FindBy(xpath = "//th[normalize-space()='Status']")
	private WebElement statusHeader;

	@FindBy(xpath = "//th[normalize-space()='Class Date']")
	private WebElement classDateHeader;

	@FindBy(xpath = "//th[normalize-space()='Staff Name']")
	private WebElement staffNameHeader;

	@FindBy(xpath = "//th[normalize-space()='Edit / Delete']")
	private WebElement editDeleteHeader;

	@FindBy(xpath = "//div[@class='p-datatable-footer ng-star-inserted']")
	private WebElement totalClassesText;

	@FindBy(xpath = "//div[@class='class-details-popup']")
	private WebElement classDetailsPopup;

	@FindBy(xpath = "//button[normalize-space()='SAVE']")
	private WebElement saveButton;

	@FindBy(xpath = "//button[normalize-space()='CANCEL']")
	private WebElement cancelButton;

	@FindBy(xpath = "//button[@class='close-popup']")
	private WebElement closeButton;

	@FindBy(xpath = "//span[@class ='p-paginator-icon pi pi-angle-right']")
	private WebElement paginationCntrls;

	@FindBy(xpath = "//span[@aria-hidden='true']")
	private WebElement deleteIcon;

	//**********************Methods******************

	public void clickClassBtn() {
		classBtn.click();
	}

	public boolean isLmsTitleDisplayed() {
		return isElementDisplayed(lmsTitle);
	}

	public void clickAddNewClassBtn() {
		addNewClassBtn.click();
	}

	public boolean manageClassTitleDisplay() {
		return isElementDisplayed(manageClassTitle);
	}

	public boolean isSearchTextBoxDisplayed() {
		return isElementDisplayed(searchTextBox);
	}

	public boolean areHeadersDisplayed() {
		return isElementDisplayed(batchNameHeader) &&
				isElementDisplayed(classTopicHeader) &&
				isElementDisplayed(classDescriptionHeader) &&
				isElementDisplayed(statusHeader) &&
				isElementDisplayed(classDateHeader) &&
				isElementDisplayed(staffNameHeader) &&
				isElementDisplayed(editDeleteHeader);
	}

	public void verifySortIcons() {
		List<WebElement> sortIcons = driver.findElements(By.xpath("//th[contains(@class, 'sortable')]//span[contains(@class, 'sort-icon')]"));
		for (WebElement icon : sortIcons) {
			Assert.assertTrue(icon.isDisplayed(), "Sort icon is not displayed for one of the fields");
		}
	}
	public void checkPagination() {
		paginationCntrls.isEnabled();
	}

	public void checkDeleteIcon() {
		deleteIcon.isDisplayed();
	}
	public String getTotalClassesText() {
		return totalClassesText.getText();
	}

	//*******************************ELEMENTS FOR CLASS DETAILS PAGE********************************

	@FindBy(xpath = "//span[contains(@class,'p-dialog-title')]")
	private WebElement title;

	@FindBy(id = "batchName")
	private WebElement batchNameField;

	@FindBy(xpath = "(//span[contains(@class,'p-dropdown-trigger-icon')]/..)[1]")
	private WebElement batchNameDropDownBtn;

	@FindBy(xpath = "//ul[@role='listbox']")
	private WebElement drodownMenuBody;

	@FindBy(xpath = "//ul[@role='listbox']//li")
	private List<WebElement> drodownMenus;

	@FindBy(id = "classTopic")
	private WebElement classTopicEditField;

	@FindBy(id = "classDescription")
	private WebElement classDescriptionField;

	@FindBy(id = "icon")
	private WebElement calendarTextField;

	@FindBy(xpath = "//button[@ng-reflect-icon='pi pi-calendar']")
	private WebElement selectDateCalenderBtn;

	@FindBy(css = "span.p-disabled")
	private List<WebElement> allDisabledDatesForCurrentMonth;

	@FindBy(tagName = "p-calendar")
	private WebElement elementStoringEnteredDate;

	@FindBy(id = "classNo")
	private WebElement noOfClassField;

	@FindBy(xpath = "//input[@placeholder='Select a Staff Name']")
	private WebElement staffNameField;

	@FindBy(xpath = "(//span[contains(@class,'p-dropdown-trigger-icon')]/..)[2]")
	private WebElement staffNameDropDownBtn;

	@FindBy(xpath = "//div[normalize-space()='Active']/p-radiobutton")
	private WebElement radioBtnActive;

	@FindBy(xpath = "//div[normalize-space()='Inactive']/p-radiobutton")
	private WebElement radioBtnInactive;

	@FindBy(xpath = "//label[text()='Comments']/following-sibling::input")
	private WebElement commentsEditField;

	@FindBy(xpath = "//label[text()='Notes']/following-sibling::input")
	private WebElement notesEditField;

	@FindBy(xpath = "//label[text()='Recording']/following-sibling::input")
	private WebElement recordingEditField;

	@FindBy(xpath = "//span[text()='Cancel']/..")
	private WebElement cancelBtn;

	@FindBy(xpath = "//span[text()='Save']/..")
	private WebElement saveBtn;

	@FindBy(xpath = "//button[contains(@class,'p-dialog-header-close')]")
	private WebElement crossBtn;

	//**********************Methods******************

	public Boolean isClassDetailsTitleExists() {
		return isElementDisplayed(title);
	}

	public Boolean isFieldEmpty(String fieldName) {
		switch (fieldName.toLowerCase().trim()) {
			case "batch name":
				return isFieldNullOrEmpty(batchNameField);
			case "class topic":
				return isFieldNullOrEmpty(classTopicEditField);
			case "class description":
				return isFieldNullOrEmpty(classDescriptionField);
			case "select class dates":
				return isFieldNullOrEmpty(calendarTextField);
			case "no of classes":
				return isFieldNullOrEmpty(noOfClassField);
			case "staff name":
				return staffNameField.getText().isEmpty();
			case "comments":
				return isFieldNullOrEmpty(commentsEditField);
			case "notes":
				return isFieldNullOrEmpty(notesEditField);
			case "recording":
				return isFieldNullOrEmpty(recordingEditField);
			default:
				throw new IllegalArgumentException("Incorrect field name: " + fieldName);
		}
	}

	public Boolean isRadioBtnSelected(String radioBtnName) {
		switch (radioBtnName.toLowerCase().trim()) {
			case "active":
				return radioBtnActive.isSelected();
			case "inactive":
				return radioBtnInactive.isSelected();
			default:
				throw new IllegalArgumentException("Incorrect radio button name: " + radioBtnName);
		}
	}

	public Boolean isButtonPresent(String buttonName) {
		switch (buttonName.toLowerCase().trim()) {
			case "cancel":
				return isElementDisplayed(cancelBtn);
			case "save":
				return isElementDisplayed(saveBtn);
			case "close":
				return isElementDisplayed(crossBtn);
			default:
				throw new IllegalArgumentException("Incorrect button name: " + buttonName);
		}
	}

	//fieldCount() method is used to get the count of fields present in the class details page
	public int getElementSize(By locator) {
		int size = 0;
		try {
			List<WebElement> elements = new WebDriverWait(driver, Duration.ofSeconds(40))
					.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
			size = elements.size();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return size;
	}

	// Update the fieldCount method to use the above getElementSize method:
	public int fieldCount() {
		return getElementSize(By.cssSelector("#batchName, #classTopic, #classDescription, #icon, #classNo, #staffId, #classComments, #classNotes, #classRecordingPath"));
	}



	//***************** Element Action Method ***************************

	public void enterTextInField(String fieldName, String text) {
		switch (fieldName.toLowerCase().trim()) {
			case "class topic":
				classTopicEditField.sendKeys(text);
				break;
			case "class description":
				classDescriptionField.sendKeys(text);
				break;
			case "comments":
				commentsEditField.sendKeys(text);
				break;
			case "notes":
				notesEditField.sendKeys(text);
				break;
			case "recording":
				recordingEditField.sendKeys(text);
				break;
			default:
				throw new IllegalArgumentException("Incorrect field name: " + fieldName);
		}
	}

	public void selectDropDownMenu(String fieldName, String text) {
		WebElement dropDownBtn = fieldName.equalsIgnoreCase("batch name") ? batchNameDropDownBtn : staffNameDropDownBtn;
		dropDownBtn.click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(drodownMenuBody));
		for (WebElement e : drodownMenus) {
			if (e.getAttribute("aria-label").equalsIgnoreCase(text)) {
				e.click();
				break;
			}
		}
	}

	public void selectRadioButton(String radioBtnName) {
		switch (radioBtnName.toLowerCase().trim()) {
			case "active":
				radioBtnActive.click();
				break;
			case "inactive":
				radioBtnInactive.click();
				break;
			default:
				throw new IllegalArgumentException("Incorrect radio button name: " + radioBtnName);
		}
	}

	public void openCalendar() {
		selectDateCalenderBtn.click();
	}

	private byte dynamicallyGetAnyDaysColumnNumber(String day) {
		byte colNumber = 1;
		List<WebElement> x = driver.findElements(By.xpath("//table[contains(@class,'p-datepicker-calendar')]//th/span"));
		for (WebElement e : x) {
			if (e.getText().equalsIgnoreCase(day)) {
				break;
			}
			colNumber++;
		}
		return colNumber;
	}

	public List<String> getAllWeekendDates() {
		List<String> weekendDates = new ArrayList<>();
		List<WebElement> sundayDatesList = driver.findElements(By.xpath("//table[contains(@class,'datepicker-calendar')]//tbody/tr/td[" + dynamicallyGetAnyDaysColumnNumber("Su") + "]/span"));
		List<WebElement> saturdayDatesList = driver.findElements(By.xpath("//table[contains(@class,'datepicker-calendar')]//tbody/tr/td[" + dynamicallyGetAnyDaysColumnNumber("Sa") + "]/span"));
		sundayDatesList.addAll(saturdayDatesList);
		for (WebElement e : sundayDatesList) {
			weekendDates.add(e.getText());
		}
		if (!weekendDates.isEmpty() && Integer.parseInt(weekendDates.get(0)) > 1) {
			weekendDates.remove(0);
		}
		return weekendDates;
	}

	public List<String> getAllDisabledDates() {
		List<String> dates = new ArrayList<>();
		for (WebElement e : allDisabledDatesForCurrentMonth) {
			dates.add(e.getText());
		}
		return dates;
	}

	public void selectCalendarDate(String date) {
		String formattedDate = (date.startsWith("0")) ? String.valueOf(date.charAt(1)) : date;

		if (Integer.parseInt(formattedDate) < Integer.parseInt(getTodaysDateOnly())) {
			System.out.println("Cannot select a past date for class start date");
			return;
		}

		if (getAllWeekendDates().contains(formattedDate)) {
			System.out.println("Cannot select a weekend date for class");
			return;
		}

		List<WebElement> days = driver.findElements(By.xpath("//span[text()='" + formattedDate + "']"));
		if (days.size() == 2) {
			days.get((Integer.parseInt(formattedDate) < 15) ? 0 : 1).click();
		} else if (days.size() == 1) {
			days.get(0).click();
		}
	}

	public void enterMultipleDates(List<String> multipleDates) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		List<String> sortedDates = multipleDates.stream()
				.map(date -> LocalDate.parse(date, formatter))
				.sorted()
				.map(date -> date.format(formatter))
				.collect(Collectors.toList());

		for (String date : sortedDates) {
			selectCalendarDate(date.split("/")[1]);
		}
	}

	public String getEnteredDateValueInEditBox() {
		waitForVisibility(elementStoringEnteredDate);
		return elementStoringEnteredDate.getAttribute("ng-reflect-model");
	}

	private static String getTodaysDate_MMDDYYY() {
		LocalDate today = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		return today.format(formatter);
	}

	private static String getTodaysDateOnly() {
		return getTodaysDate_MMDDYYY().split("/")[1];
	}


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


	private boolean isFieldNullOrEmpty(WebElement element) {
		return element.getAttribute("ng-reflect-model") == null || element.getAttribute("ng-reflect-model").isEmpty();
	}

	private void waitForVisibility(WebElement element) {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(element));
	}


	//******************PAGINATION METHODS******************

	//********** ARROW BUTTON WEBELEMENTS **********
	@FindBy(xpath = "//span[contains(@class,'double-left')]/..")
	private WebElement doubleLeftArrowBtn;

	@FindBy(xpath = "//span[contains(@class,'angle-left')]/..")
	private WebElement singleLeftArrowBtn;

	@FindBy(xpath = "//span[contains(@class,'angle-right')]/..")
	private WebElement singleRightArrowBtn;

	@FindBy(xpath = "//span[contains(@class,'double-right')]/..")
	private WebElement doubleRightArrowBtn;

	@FindBy(xpath = "//span[contains(@class,'double-left')]/..")
	private WebElement firstPage;

	@FindBy(xpath = "//span[contains(@class,'angle-left')]/..")
	private WebElement previousPage;

	@FindBy(xpath = "//span[contains(@class,'angle-right')]/..")
	private WebElement nextPage;

	@FindBy(xpath = "//span[contains(@class,'double-right')]/..")
	private WebElement lastPage;
	//********** REUSABLE METHOD FOR CLICKING ELEMENTS **********
	private void clickElement(WebElement element, String elementName) {
		try {
			element.click();
			LoggerLoad.info("Clicked on " + elementName + " successfully.");
		} catch (NoSuchElementException e) {
			LoggerLoad.error(elementName + " not found: " + e.getMessage());
		} catch (Exception e) {
			LoggerLoad.error("An error occurred while clicking on " + elementName + ": " + e.getMessage());
		}
	}

	//********** METHODS TO INTERACT WITH BUTTONS **********

	// Method to click the double-left arrow button
	public void clickDoubleLeftArrow() {
		clickElement(doubleLeftArrowBtn, "Double-Left Arrow Button");
	}

	// Method to click the single-left arrow button
	public void clickSingleLeftArrow() {
		clickElement(singleLeftArrowBtn, "Single-Left Arrow Button");
	}

	// Method to click the single-right arrow button
	public void clickSingleRightArrow() {
		clickElement(singleRightArrowBtn, "Single-Right Arrow Button");
	}

	// Method to click the double-right arrow button
	public void clickDoubleRightArrow() {
		clickElement(doubleRightArrowBtn, "Double-Right Arrow Button");
	}


	public void clickFirstPage() {
		clickElement(firstPage, "First Page Button");
	}

	public void clickPreviousPage() {
		clickElement(previousPage, "Previous Page Button");
	}

	public void clickNextPage() {
		clickElement(nextPage, "Next Page Button");
	}

	public void clickLastPage() {
		clickElement(lastPage, "Last Page Button");
	}
	public boolean isNextPageActive() {
		return nextPage.isEnabled();
	}

	public boolean isPreviousPageActive() {
		return previousPage.isEnabled();
	}
//**********************EDIT ICON*********************************************


	// Locate the edit icon using relative XPath
	@FindBy(xpath = "//span[@class='p-button-icon pi pi-pencil']")
	List<WebElement> editIconsList;

	// Locate the popup element by its ID
	@FindBy(xpath = "//div[contains(@role, 'dialog')]")
	WebElement popupClassDetails;

	// Locate the batch name field within the popup using its class attributes
	@FindBy(xpath = "//p-dropdown[@id='batchName' and @placeholder='Select a Batch Name']")
	WebElement batchNameDropdown;


	// Locate the class topic field within the popup using its class attributes
	@FindBy(xpath = "//div[@class='ng-tns-c168-7 p-dialog-mask p-component-overlay p-dialog-mask-scrollblocker ng-star-inserted']//input[@formcontrolname='classTopic']")
	WebElement classTopicField;

	//methods for edit icon
	public boolean areEditIconsDisplayed() {
		boolean allEditIconsDisplayed = true;

		for (WebElement editIcon : editIconsList) {
			if (!editIcon.isDisplayed()) {
				System.out.println("Edit icon is not Displayed: " + editIcon.getText());
				allEditIconsDisplayed = false;
			}else {
				editIcon.click();
			}
		}
		return allEditIconsDisplayed;
	}

	// Method to verify the popup is displayed

	public boolean isPopupDisplayed() {
		try {
			// Wait until the popup is visible
			new WebDriverWait(driver, Duration.ofSeconds(30))
					.until(ExpectedConditions.visibilityOf(popupClassDetails));

			// Check if the popup is displayed
			return popupClassDetails.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	// Method to verify the batch name field is disabled
	public void verifyBatchNameFieldDisabled() {
		Assert.assertFalse(batchNameField.isEnabled(), "The batch name field is not disabled");
	}

	// Method to verify the class topic field is disabled
	public void verifyClassTopicFieldDisabled() {
		Assert.assertFalse(classTopicField.isEnabled(), "The class topic field is not disabled");
	}

	//DELETE ICON
	@FindBy(xpath = "//thead//div[@role='checkbox']")
	WebElement headerCheckbox;


	@FindBy(xpath = "//span[contains(text(),'Yes')]")
	private WebElement yesButtonLoc;

	@FindBy(xpath = "//span[contains(text(),'No')]")
	private WebElement noButtonLoc;

	@FindBy(xpath = "//*[contains(@class,'p-dialog-header-close')]")
	private WebElement XButtonLoc;

	@FindBy(xpath = "//div[contains(@class,'p-toast-message-text')]")
	private WebElement successMessageLoc;

	
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
