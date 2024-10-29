package pageObjects;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.languagetool.JLanguageTool;
import org.languagetool.language.BritishEnglish;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	public void waitForElementVisibility(WebElement element) {
		WebDriverWait myWait = new WebDriverWait(driver,Duration.ofSeconds(10));
		myWait.until(ExpectedConditions.visibilityOf(element));
	}
	
	//--------------------  Find Broken Link -------------------------------
	public Boolean findBrokenLinks(List<WebElement> ListOfPageLinks) {
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
			return true;
		} else {
			System.out.println("All links are valid.");
			return false;
		}
	}

	//-------------------- Check Spelling for Login and DashBoard -------------------------------
	public void checkSpelling() throws Exception
	{
		Thread.sleep(500);
        String currentPageUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentPageUrl);
        
        WebElement bodyElement = driver.findElement(By.tagName("body"));
        String pageText = bodyElement.getText();
        System.out.println("Page Text: \n" + pageText);
        JLanguageTool langTool = new JLanguageTool(new BritishEnglish()); 
        try {
        List<org.languagetool.rules.RuleMatch> matches = langTool.check(pageText); 
        
        if (matches.isEmpty()) {
            System.out.println("No spelling mistakes found.");
        } else {
            System.out.println("Spelling mistakes found:");
            for (org.languagetool.rules.RuleMatch match : matches) 
            {
            	System.out.println("Spelling mistakes found:"+match);
            	System.out.println("Context: " + match.getShortMessage());
                System.out.println("Potential typo at line " + match.getLine() + ", column " + match.getColumn());
                System.out.println("Suggested corrections: " + org.apache.commons.lang3.StringUtils.join(match.getSuggestedReplacements()));
            }
        }
		
       }
        catch(IOException e) 
        {
        	e.printStackTrace();
        }	
	}
}
