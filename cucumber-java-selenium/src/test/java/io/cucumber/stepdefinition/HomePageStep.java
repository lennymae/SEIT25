
package io.cucumber.stepdefinition;

import io.cucumber.core.ConfigReader;
import io.cucumber.core.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.pages.BasicAuthPage;
import io.cucumber.pages.HomePage;

public class HomePageStep {

	private HomePage homePage = new HomePage(); 
	
    @Given("the browser navigates to the base URL")
    public void navigateToBaseUrl() {
        Hooks.driver.get("https://"+ConfigReader.getProperty("base.url"));
    }

    @When("the {string} link is opened")
    public void openLink(String linkText) {
        homePage.clickExampleLink(linkText);
    }
    
    @Then("source list should match the links on the page")
    public void verifyLinksMatching() {
        homePage.getListOfLinksFromSourceFile();
        homePage.getListOfLinksFromHomePage();
        homePage.validateLinksListMatching();
    }
}
