package io.cucumber.pages;

import java.util.List;

import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.cucumber.core.ConfigReader;
import io.cucumber.core.Hooks;
import io.cucumber.datatable.DataTable; 
import io.cucumber.pages.*;
import java.util.*;

	public class SortableDataTablesPage{
		
		public List<Map<String, String>> getPageDataTableValues(int tableNumber) {
	    	List<WebElement> rows = Hooks.driver.findElements(By.xpath("//table[@id='table"+tableNumber+"']/tbody/tr"));
	    	List<Map<String, String>> pageRows = new ArrayList<>();
	    	for(WebElement n:rows) {
	    		Map<String, String> rowData = new HashMap<>();
	    		List<WebElement> cells = n.findElements(By.tagName("td"));
	    		rowData.put("Last Name",cells.get(0).getText());
	    		rowData.put("First Name",cells.get(1).getText());
	    		rowData.put("Email",cells.get(2).getText());
	    		rowData.put("Due",cells.get(3).getText());
	    		rowData.put("Web Site",cells.get(4).getText());
	    		pageRows.add(rowData);
	    	}
	    	return pageRows;
		}
		
	}