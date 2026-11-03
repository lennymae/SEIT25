package io.cucumber.stepdefinition;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.cucumber.core.ConfigReader;
import io.cucumber.core.Hooks;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.pages.SortableDataTablesPage;
import io.cucumber.pages.*;
import java.util.*;


public class SortableDataTablesStep{


    @Then("table {int} should display below rows")
    public void verifyPageTableRowsMatchDatatable(int tableNumber, DataTable datatable) {
    	List<Map<String, String>> datatableRows = datatable.asMaps();
    	List<Map<String, String>> pageRows = new ArrayList<>();
    	List<WebElement> rows = Hooks.driver.findElements(By.xpath("//table[@id='table"+tableNumber+"']/tbody/tr"));
    	
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
    	System.out.println("PAGE ROWS"+pageRows);
    	assertEquals(datatableRows,pageRows);
    }


}