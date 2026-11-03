package io.cucumber.core;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Hooks {
	public static WebDriver driver;
    public static ChromeOptions options = new ChromeOptions();
	    @Before
	    public static void setupDriver() {
	        WebDriverManager.chromedriver().setup();

	  	  //Comment when running in local
		  ChromeOptions options = new ChromeOptions();
		  options.addArguments("--headless=new");
		  options.addArguments("--no-sandbox");
		  options.addArguments("--disable-dev-shm-usage");
		  options.addArguments("--window-size=1920,1080");
		  options.addArguments("--remote-allow-origins=*");
	    }

	    @Before
	    public static void createDriver() {
	        driver = new ChromeDriver(options);
	    }
	    @After
		public static void quitDriver() {
		    if (driver != null) {
		        driver.quit();
		        driver = null;
		    }
		}
}

