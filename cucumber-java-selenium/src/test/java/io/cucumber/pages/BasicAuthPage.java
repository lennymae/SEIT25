package io.cucumber.pages;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.By;

import io.cucumber.core.ConfigReader;
import io.cucumber.core.Hooks;

	public class BasicAuthPage{
		By loginSuccessMessage = By.xpath("//p[contains(text(),'Congratulations! You must have the proper credentials.')]");
		
		public void loginBasicAuth(String account) {

			String username = ConfigReader.getProperty(account + ".username");
			String password = ConfigReader.getProperty(account + ".password");
		    String url = "https://" + username + ":" + password
		            + "@"+ConfigReader.getProperty("base.url")+"/basic_auth";
		    Hooks.driver.get(url);
		}
		
		public void validateAuthenticationSuccess() {
			 assertTrue(Hooks.driver.findElement(loginSuccessMessage).isDisplayed(), "Login unsuccessful");
		}
		
		 public void verifyHeaderDisplayed(String headerText) {
		        By headerLocator = By.xpath("//*[contains(normalize-space(text()), '" + headerText + "')]");
		        assertTrue(Hooks.driver.findElement(headerLocator).isDisplayed(), "Header not displayed: " + headerText);
		    }
	}