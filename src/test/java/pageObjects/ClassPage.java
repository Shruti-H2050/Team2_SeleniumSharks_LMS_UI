package pageObjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lombok.Data;
@Data
public class ClassPage extends BasePage{

	public ClassPage(WebDriver driver) {
		super(driver);
	}
	
	
	private String manage_Class_Pg="https://lms-frontend-hackathon-oct24-173fe394c071.herokuapp.com/session";
	//--------------------------- WebElement --------------------------------
	@FindBy(xpath = "//button[@routerlink='/session']")
	private WebElement Class_Dashboard_Button;
	
	@FindBy(xpath = "//button[@id='logout']")
	private WebElement logoutBtn;
	
	@FindBy(xpath = "//p-sorticon[@field='batchName']/i")
	private WebElement sortBatchNames;
	
	@FindBy(xpath = "//thead[@class='p-datatable-thead']/tr/th[2]")
	private WebElement batchNameHeader;
	
	@FindBy(xpath = "//thead[@class='p-datatable-thead']/tr/th[3]")
	private WebElement classTopicHeader;
	
	@FindBy(xpath = "//thead[@class='p-datatable-thead']/tr/th[4]")
	private WebElement classDescriptionHeader;
	
	@FindBy(xpath = "//thead[@class='p-datatable-thead']/tr/th[5]")
	private WebElement StatusHeader;
	
	@FindBy(xpath = "//thead[@class='p-datatable-thead']/tr/th[6]")
	private WebElement ClassDateHeader;
	
	@FindBy(xpath = "//thead[@class='p-datatable-thead']/tr/th[7]")
	private WebElement StaffNameHeader;
	
	@FindBy (xpath = "//tbody//tr//td[2]") 
	List<WebElement> batNames;

	@FindBy (xpath = "//tbody//tr//td[3]") 
	List<WebElement> cltopic;

	@FindBy (xpath = "//tbody//tr//td[4]") 
	List<WebElement> clDesc;
	
	@FindBy (xpath = "//tbody//tr//td[5]") 
	List<WebElement> status;

	@FindBy (xpath = "//tbody//tr//td[6]") 
	List<WebElement> clDate;

	@FindBy (xpath = "//tbody//tr//td[7]") 
	List<WebElement> staffN;
	
	//---------------------------- Methods -------------------------------
	
	public boolean sortBatchName()
	{
		return commonSortCheck(batchNameHeader,batNames);
	}

	public boolean sortClassTopic()
	{
		return commonSortCheck(classTopicHeader,cltopic);
	}

	public boolean sortClassDescription()
	{
		return commonSortCheck(classDescriptionHeader,clDesc);
	}
	
	public boolean sortStatus()
	{
		return commonSortCheck(StatusHeader,status);
	}
	
	public boolean sortClassDate()
	{
		return commonSortCheck(ClassDateHeader,clDate);
	}
	
	public boolean sortStaff()
	{
		return commonSortCheck(StaffNameHeader,staffN);
	}
	
	public Map<String,String> Navi_Modules() throws InterruptedException
	{
	
		int counter=0;
		int arrayindex=0;
		Map<String,String> values=new HashMap<String, String>();
		do
		{
			
			LoginPage.NoofBtnDashboard.get(counter).click();
			justClick();
			Thread.sleep(2000);
			String Url = driver.getCurrentUrl();
			System.out.println(Url);
			System.out.println("counter "+counter);
			values.put(LoginPage.NoofBtnDashboard.get(counter).getText(), Url);
			System.out.println("Array url:"+values);
			arrayindex++;
			counter++;
			
		}while(counter<LoginPage.NoofBtnDashboard.size());
		
		return values;
	}
	
}
