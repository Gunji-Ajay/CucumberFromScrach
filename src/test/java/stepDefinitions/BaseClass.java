package stepDefinitions;

import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.Logger;
import pageObjects.AddCustomer;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class BaseClass {
	public WebDriver driver;
	public LoginPage lp;
	public AddCustomer addCust;
	public SearchCustomerPage searchCustomerPage;
	public Logger logger;
	public Properties configProp;
	public static String randomestring() {
		String generatedString1=RandomStringUtils.randomAlphabetic(5);
		return (generatedString1);
		
	}

}	


