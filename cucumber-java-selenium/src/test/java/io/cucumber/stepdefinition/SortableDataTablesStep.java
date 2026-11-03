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

	private SortableDataTablesPage sortableDataTablesPage = new SortableDataTablesPage(); 
    @Then("table {int} should display below rows")
    public void verifyPageTableRowsMatchDatatable(int tableNumber, DataTable datatable) {
    	List<Map<String, String>> pageRows = sortableDataTablesPage.getPageDataTableValues(tableNumber);
    	List<Map<String, String>> datatableRows = datatable.asMaps();
    	assertEquals(datatableRows,pageRows);
    }


}