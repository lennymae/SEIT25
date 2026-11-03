package io.cucumber.pages;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import io.cucumber.core.ConfigReader;
import io.cucumber.core.Hooks;
import io.cucumber.datatable.DataTable; 

	public class SortableDataTablesPage{
		By table1 = By.id("table1");
		
		public void validateTable(DataTable dataTable) {

		    List<Map<String, String>> expectedRecords = dataTable.asMaps();
		}
		
	}