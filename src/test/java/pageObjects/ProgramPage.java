package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lombok.Data;

@Data
public class ProgramPage extends BasePage {

	public ProgramPage(WebDriver driver) {
		super(driver);
	}

//----------------------WebElements-------------------------------

	@FindBy(xpath = "//span[text()='Program']")
	private WebElement programBtn;

	@FindBy(xpath = "//button[normalize-space()='Add New Program']")
	private WebElement addNewProgramBtn;

	@FindBy(xpath = "//div[normalize-space()='Manage Program']")
	private WebElement manageProgramTitle;

	@FindBy(xpath = "//input[contains(@placeholder,'Search')]")
	private WebElement searchTextBox;

	@FindBy(xpath = "(//span[@class='p-button-icon pi pi-pencil'])[1]")
	private WebElement editIcon1;

	@FindBy(xpath = "//span[text()='Program Details']")
	private WebElement programDetailsTitle;

	@FindBy(xpath = "//mat-toolbar[@class='mat-toolbar mat-primary mat-toolbar-single-row ng-star-inserted']/span[1]")
	private WebElement manageProgramPageLmsTitle;

	@FindBy(xpath = "//button[@id='logout']")
	private WebElement logoutBtn;

	@FindBy(xpath = "//div[@class='ng-star-inserted']/button/span[1]")
	private List<WebElement> moduleBtnList;

	@FindBy(xpath = "//link")
	private List<WebElement> programPageLinks;

	@FindBy(xpath = "//div[@class='p-field ng-star-inserted']/label[@for='programName']")
	private WebElement programDetailsPopupName;

	@FindBy(xpath = "//div[@class='p-field ng-star-inserted']/label[@for='programDescription']")
	private WebElement programDetailsPopupDescription;

	@FindBy(xpath = "//div[@class='radio ng-star-inserted']/div/lable")
	private WebElement programDetailsPopupStatus;

	@FindBy(xpath = "//button[@label='Cancel']")
	private WebElement programDetailsCancelButton;

	@FindBy(xpath = "//button[@class='p-button-danger p-button p-component p-button-icon-only']")
	private WebElement programPageDisabledDeleteBtn;

	@FindBy(xpath = "//th[@psortablecolumn='programName']")
	private WebElement dataTableProgramName;

	@FindBy(xpath = "//th[@psortablecolumn='programDescription']")
	private WebElement dataTableProgramDescription;

	@FindBy(xpath = "//th[@psortablecolumn='programStatus']")
	private WebElement dataTableProgramStatus;

	@FindBy(xpath = "//th[text()=' Edit / Delete ']")
	private WebElement dataTableEditDelete;

	@FindBy(xpath = "//thead[@class='p-datatable-thead']//input")
	private WebElement ppDataTableheaderCheckBox;

	@FindBy(xpath = "//div[@class='p-hidden-accessible']")
	private List<WebElement> ppAllRowCheckBox;

	@FindBy(xpath = "//p-sorticon[@field='programName']")
	private WebElement programNameSortIcon;

	@FindBy(xpath = "//p-sorticon[@field='description']")
	private WebElement programDescriptionSortIcon;

	@FindBy(xpath = "//p-sorticon[@field='status']")
	private WebElement programStatusSortIcon;

	@FindBy(xpath = "//button[@id='editProgram']")
	private List<WebElement> dataTableAllRowEditIcon;

	@FindBy(xpath = "//button[@id='deleteProgram']")
	private List<WebElement> dataTableAllRowDeleteIcon;

	@FindBy(xpath = "//span[@class='p-paginator-icon pi pi-angle-double-left']")
	private WebElement ppPaginationBeginningPageArrow;

	@FindBy(xpath = "//span[@class='p-paginator-icon pi pi-angle-double-right']")
	private WebElement ppPaginationEndingPageArrow;

	@FindBy(xpath = "//span[@class='p-paginator-icon pi pi-angle-left']")
	private WebElement ppPaginationPreviousPageArrow;

	@FindBy(xpath = "//span[@class='p-paginator-icon pi pi-angle-right']")
	private WebElement ppPaginationNextPageArrow;

	@FindBy(xpath = "//div[@class='p-paginator-bottom p-paginator p-component ng-star-inserted']")
	private WebElement paginationBar;

	@FindBy(xpath = "//label[@for='programName']/span")
	private WebElement programDetailsNameRedStar;

	@FindBy(xpath = "//span[text()='Save']")
	private WebElement programDetailsSaveBtn;

	@FindBy(xpath = "//small[text()='Program name is required.']")
	private WebElement redProgramDetailsNameFieldText;

	@FindBy(xpath = "//small[text()='Description is required.']")
	private WebElement redProgramDetailsDescriptionFieldText;

	@FindBy(xpath = "//small[text()='Status is required.']")
	private WebElement redProgramDetailsStatusFieldText;

	@FindBy(xpath = "//input[@id='programName']")
	private WebElement programdetailsNameBox;

	@FindBy(xpath = "//input[@id='programDescription']")
	private WebElement programdetailsDescriptionBox;

	@FindBy(xpath = "//p-radiobutton[@ng-reflect-input-id='Active']") // "//div[contains(text(),'Active')]//div[@class='p-radiobutton-box']")
	private WebElement activeRadioButton;

	@FindBy(xpath = "//p-radiobutton[@ng-reflect-input-id='Inactive']") // "//div[contains(text(),'Inactive')]//div[@class='p-radiobutton-box']")
	private WebElement InactiveRadioButton;

	@FindBy(xpath = "//div[text()='Successful']")
	private WebElement programPageMessage;

	// ---------------------Methods-------------------------------

	public void clicksearchTextBox() {
		searchTextBox.click();
	}

	public void clickCancel() {
		programDetailsCancelButton.click();
	}

	public List<String> getListOfModuleBtnTexts() {
		List<String> moduleTexts = new ArrayList<>();
		for (WebElement moduleBtn : moduleBtnList) {
			moduleTexts.add(moduleBtn.getText().trim());
		}
		return moduleTexts;
	}

	public boolean programDetailsPopupDisplay() {
		boolean programDetailsPopup = false;

		boolean programDetailsPopupNameDisplay = programDetailsPopupName.isDisplayed();
		boolean programDetailsPopupDescriptionDisplay = programDetailsPopupDescription.isDisplayed();
		boolean programDetailsPopupStatusDisplay = programDetailsPopupStatus.isDisplayed();

		if (programDetailsPopupNameDisplay && programDetailsPopupDescriptionDisplay
				&& programDetailsPopupStatusDisplay) {
			programDetailsPopup = true;
		}

		return programDetailsPopup;
	}

	public boolean ppdataTableHeaderDisplay() {
		boolean dataTableHeader = false;

		boolean dataTableProgramNameDisplay = dataTableProgramName.isDisplayed();
		boolean dataTableProgramDescriptionDisplay = dataTableProgramDescription.isDisplayed();
		boolean dataTableProgramStatusDisplay = dataTableProgramStatus.isDisplayed();
		boolean dataTableEditDeleteDisplay = dataTableEditDelete.isDisplayed();

		if (dataTableProgramNameDisplay && dataTableProgramDescriptionDisplay && dataTableProgramStatusDisplay
				&& dataTableEditDeleteDisplay == true) {
			dataTableHeader = true;
		}

		return dataTableHeader;
	}

	public boolean ppRowCheckBoxUnchecked() {
		boolean eachRowCheckBoxUncheck = false;
		for (WebElement eachCheckbox : ppAllRowCheckBox) {
			if (!eachCheckbox.isSelected() == true) {
				eachRowCheckBoxUncheck = true;
			}
		}
		return eachRowCheckBoxUncheck;
	}

	public boolean ppSortIconDispay() {
		boolean sortIconInHeader = false;

		boolean programNameSortIconDisplay = programNameSortIcon.isDisplayed();
		boolean programDescriptionSortIconDisplay = programDescriptionSortIcon.isDisplayed();
		boolean programStatusSortIconDisplay = programStatusSortIcon.isDisplayed();

		if (programNameSortIconDisplay && programDescriptionSortIconDisplay && programStatusSortIconDisplay == true) {
			sortIconInHeader = true;
		}

		return sortIconInHeader;
	}

	public boolean dataTableEditDeleteIconDisplay() {
		boolean eachRowEditDeleteIcon = false;
		for (int i = 0; i < dataTableAllRowEditIcon.size(); i++) {
			WebElement eachEditIcon = dataTableAllRowEditIcon.get(i);
			WebElement eachDeleteIcon = dataTableAllRowDeleteIcon.get(i);
			if (eachEditIcon.isDisplayed() && eachDeleteIcon.isDisplayed() == true) {
				eachRowEditDeleteIcon = true;
			}
		}
		return eachRowEditDeleteIcon;
	}

	public boolean programDetailsRedFieldTextDisplay() {
		boolean fieldText = false;
		boolean nameFeildTextDisplay = redProgramDetailsNameFieldText.isDisplayed();
		boolean descriptionFeildTextDisplay = redProgramDetailsDescriptionFieldText.isDisplayed();
		boolean statusFeildTextDisplay = redProgramDetailsStatusFieldText.isDisplayed();

		if (nameFeildTextDisplay && descriptionFeildTextDisplay && statusFeildTextDisplay == true) {
			fieldText = true;
		}
		return fieldText;
	}

}