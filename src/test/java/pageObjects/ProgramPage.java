package pageObjects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProgramPage extends BasePage {

	public ProgramPage(WebDriver driver) {
		super(driver);
	}

	public String programModuleUrl="https://lms-frontend-hackathon-oct24-173fe394c071.herokuapp.com/program";
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

	@FindBy(xpath = "//p-sorticon[@field='programName']/i")
	public WebElement sortProgramName;

	@FindBy(xpath = "//thead[@class='p-datatable-thead']/tr/th[2]")
	public WebElement programNameHeader;

	@FindBy(xpath = "//thead[@class='p-datatable-thead']/tr/th[3]")
	public WebElement programDesHeader;

	@FindBy(xpath = "//thead[@class='p-datatable-thead']/tr/th[4]")
	public WebElement programStatusHeader;

	@FindBy (xpath = "//tbody//tr//td[2]") 
	List<WebElement> progNames;

	@FindBy (xpath = "//tbody//tr//td[3]") 
	List<WebElement> prodDesc;

	@FindBy (xpath = "//tbody//tr//td[4]") 
	List<WebElement> progStatus;

	//aria-sort="ascending"
	// ----------------Methods------------------

	public void clickProgramBtn() {
		programBtn.click();
		justClick();
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

	public boolean sortProgramName()
	{
		return commonSortCheck(programNameHeader,progNames);
	}

	public boolean sortProgramDesc()
	{
		return commonSortCheck(programDesHeader,prodDesc);
	}

	public boolean sortProgramStatus()
	{
		return commonSortCheck(programStatusHeader,progStatus);
	}

//	public boolean commonSortCheck(WebElement header, List<WebElement> eles)
//	{
//		justClick();
//		ArrayList<String> values=new ArrayList<String>();
//		ArrayList<String> expectedSortValues=new ArrayList<String>();
//
//		for(WebElement ele:eles)
//		{
//			values.add(ele.getText());
//			expectedSortValues.add(ele.getText());
//		}
//
//		if(header.getAttribute("aria-sort").equals("ascending"))
//		{
//			//exo value
//			Collections.sort(expectedSortValues, String.CASE_INSENSITIVE_ORDER);
//		}
//		else
//		{
//			//exo value
//			Collections.sort(expectedSortValues, String.CASE_INSENSITIVE_ORDER.reversed());
//		}
//
//		System.out.println("Values -> "+StringUtils.join(values));
//		System.out.println("expectedSortValues -> "+StringUtils.join(expectedSortValues));
//
//		for(int i=0;i<values.size();i++)
//		{
//			if(!values.get(i).equals(expectedSortValues.get(i)))
//			{
//				return false;
//			}
//		}
//
//		return true;
//	}
}
