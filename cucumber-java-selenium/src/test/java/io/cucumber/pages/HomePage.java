package io.cucumber.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.*;
import io.cucumber.core.Hooks;
import io.cucumber.utils.DataManipulation;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import static org.junit.jupiter.api.Assertions.assertTrue;
import io.cucumber.core.ConfigReader;

	public class HomePage{
		By TheInternetHomePageHeader = By.xpath("//h1[contains(text(),'Welcome to the-internet')]");
		By BasicAuthLink = By.partialLinkText("Basic Auth");

		By SortableDataTablesLink = By.partialLinkText("Sortable Data Tables");
		By exampleLink = By.xpath("//li");
		List<String> sourceFileLinks = new ArrayList<String>();
		List<String> webLinksText = new ArrayList<String>();
		XSSFWorkbook wb = DataManipulation.getWorkbook(ConfigReader.getProperty("theinternetlinklistpath"));
		
		public void clickExampleLink(String linkText) {
			By ExampleLink = By.partialLinkText(linkText);
			Hooks.driver.findElement(ExampleLink).click();
		}
		public void clickSortableDataTablesLink() {
			Hooks.driver.findElement(SortableDataTablesLink).click();
		}
		
		public void validateHomePageHeader() {
			Hooks.driver.findElement(TheInternetHomePageHeader).isDisplayed();
		}

		public void getListOfLinksFromSourceFile(){
			int rowCount = DataManipulation.getRowCount(wb,0);
			for(int row = 0 ;row<rowCount ; row++) {
				sourceFileLinks.add(DataManipulation.getData(wb, 0, row, 0));
			}
		}

		public void getListOfLinksFromHomePage(){
			List<WebElement> webLinks = Hooks.driver.findElements(exampleLink);
			for (WebElement element : webLinks) {
			    if (!element.getText().trim().isEmpty()) {
			    	webLinksText.add(element.getText().trim());
			    }
			}
		}
		
		public void validateLinksListMatching() {
			System.out.println(sourceFileLinks);
			System.out.println(webLinksText);
		    assertTrue(sourceFileLinks.size() == webLinksText.size()
		               && sourceFileLinks.containsAll(webLinksText)
		               && webLinksText.containsAll(sourceFileLinks),
		               "Links on webpage does not match source file"
		        );
		}
	}