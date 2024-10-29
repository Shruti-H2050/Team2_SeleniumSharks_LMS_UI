package pageObjects;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import lombok.Data;

@Data
public class BasePage {

	WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// ----------------------WebElements-------------------------------
	
	@FindBy(xpath = "//div[contains(text(),'In total there are')]")
	private WebElement footerText; // common for all

	@FindBy(xpath = "//span[contains(text(),'Showing') and contains(text(),'of') and contains(text(),'entries')]")
	private WebElement paginationText; // common for all

	// -----------------------Methods----------------------------------
	
	public void justClick() {
		Actions myAction = new Actions(driver);
		myAction.keyDown(Keys.ESCAPE).keyUp(Keys.ESCAPE).perform();
	}

	public void waitForElementVisibility(WebElement element) {
		WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(2));
		myWait.until(ExpectedConditions.visibilityOf(element));
	}

	public void findBrokenLinks(List<WebElement> ListOfPageLinks) {
		List<WebElement> allLinks = ListOfPageLinks;
		boolean hasBrokenLinks = false; // Flag to track if there are broken links
		for (WebElement link : allLinks) {
			String url = link.getAttribute("href");
			if (url != null && !url.isEmpty()) {
				try {
					// Check if the link is broken
					HttpURLConnection connection = (HttpURLConnection) (new URL(url).openConnection());
					connection.setRequestMethod("HEAD");
					connection.connect();
					int responseCode = connection.getResponseCode();

					// If response code is not 200, consider it a broken link
					if (responseCode != 200) {
						System.out.println("Broken link: " + url + " - " + responseCode);
						hasBrokenLinks = true; // Set flag to true if a broken link is found
					}
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("Exception occurred while checking link: " + url);
					hasBrokenLinks = true; // Set flag to true if an exception occurs
				}
			} else {
				System.out.println("Link is either null or empty: " + link.getText());
			}
		}
		// Print a message if there are broken links
		if (hasBrokenLinks) {
			System.out.println("There are broken links on the page.");
		} else {
			System.out.println("All links are valid.");
		}
	}

	public boolean footerValidation(String moduleName) {
		boolean footer = false;
		waitForElementVisibility(footerText);
		if (footerText.isDisplayed() == true) {
			String footerMsg = footerText.getText();
			System.out.println("Footer text: " + footerMsg);

			String[] footerTextArray = footerMsg.split(" ");
			int totalPageNoInFooter = Integer.parseInt(footerTextArray[4]);
			System.out.println("Total number of " + moduleName + " in footer text: " + totalPageNoInFooter);

			String paginationMsg = paginationText.getText();
			System.out.println("Pagination text: " + paginationMsg);

			String[] paginationTextArray = paginationMsg.split(" ");
			int totalPageNoInPaginationText = Integer.parseInt(paginationTextArray[5]);
			System.out.println("Total number of " + moduleName + " in pagination text: " + totalPageNoInPaginationText);

			if (totalPageNoInFooter == totalPageNoInPaginationText) {
				footer = true;
			}
		}
		return footer;
	}

}
