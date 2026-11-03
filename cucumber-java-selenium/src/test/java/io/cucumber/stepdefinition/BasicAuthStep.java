package io.cucumber.stepdefinition;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.By;

import io.cucumber.core.ConfigReader;
import io.cucumber.core.Hooks;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.pages.BasicAuthPage;
import io.cucumber.pages.HomePage;

public class BasicAuthStep {

private BasicAuthPage basicAuthPage = new BasicAuthPage(); 
    @And("user {string} logged in")
    public void loginUser(String account) {
    	basicAuthPage.loginBasicAuth(account);
    }

    @And("header {string} should be displayed")
    public void verifyHeaderDisplayed(String headerText) {
    	basicAuthPage.verifyHeaderDisplayed(headerText);
    }
    
    @Then("confirmation message on successful authentication should be displayed")
    public void verifyLoginSuccessMessageDisplayed() {
    	basicAuthPage.validateAuthenticationSuccess();
    }

}