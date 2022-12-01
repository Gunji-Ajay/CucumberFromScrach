package stepDefinitions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import pageObjects.AddCustomer;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class Steps extends BaseClass{
	public WebDriver driver;
	@Before
	public void setup() throws IOException {
		logger=(Logger) LogManager.getLogger("Steps");
        PropertyConfigurator.configure("log4j.properties");	
		//Reading properties
		configProp=new Properties();
		FileInputStream configPropfile=new FileInputStream("config.properties");
		configProp.load(configPropfile);
		String browser=configProp.getProperty("webdriver");
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		
		logger.info("***** Launching browser *****");
	}
	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {
		  
	    lp=new LoginPage(driver);
	}

	@When("User open URL {string}")
	public void user_open_url(String url) {
	    logger.info("****** Providing login details ******");
		driver.get(url);
	   driver.manage().window().maximize();
	}

	@When("User enters Email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password) {
	    logger.info("******** Providing login details ********");
		lp.setUserName(email);
	    lp.setPassword(password);
	}

	@When("Click on login")
	public void click_on_login() throws InterruptedException {
		logger.info("****** started login *****");
		lp.clickLogin();
		
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String Title) throws InterruptedException {
	    if(driver.getPageSource().contains("Login was unsuccessful.")) {
	    	driver.close();
	    	logger.info("****** Login Passed");
	    	Assert.assertTrue(false);
	    }
	    else {
	    	logger.info("***** Login Failed ******");
	    	Assert.assertEquals(Title, driver.getTitle());
	    }
	    Thread.sleep(3000);
	}

	@When("User click on logout link")
	public void user_click_on_logout_link() throws InterruptedException {
	    logger.info("****** Clicked on logout Link");
		lp.clickLogOut();
	   Thread.sleep(3000);
	}

	@Then("close browser")
	public void close_browser() {
		logger.info("****** Closing browser");
		driver.quit();
	}
	
	// customer feature definitions
	
	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {
		addCust=new AddCustomer(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration", addCust.getPageTitle());
	    
	}
	
	
	@When("User click on customer Menu")
	public void user_click_on_customer_menu() throws InterruptedException {
	    
		addCust.clickOnCustomerMenu();
	}
	@When("click on customers Menu Item")
	public void click_on_customers_menu_item() throws InterruptedException {
	    addCust.clickOnCustomerMenuItem();
	    
	}
	@When("click on Add button")
	public void click_on_add_button() throws InterruptedException {
	
		addCust.clickOnAddNew();
	   
	}
	
	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() {
	    Assert.assertEquals("Add a new customer / nopCommerce administration", addCust.getPageTitle());	}
	
	@When("User enter customer info")
	public void user_enter_customer_info() throws InterruptedException {
	   String email=randomestring()+"@gmail.com";
	   addCust.setEmail(email);
	   addCust.setPassword("122");
	   addCust.setFirstName("ajay");
	   addCust.setLastName("kumar");
	   addCust.setDob("17/17/1999");
	   addCust.setGender("Male");
	   addCust.setCompanyName("nnnn");
	   addCust.setAdminContent("this is for testing");
	   addCust.setCustomerRoles("Vendors");
	   Thread.sleep(3000);
	   addCust.setManagerOfVendor("Vendor 2");
	   
	}
	
	
	@When("click on save button")
	public void click_on_save_button() throws InterruptedException {
	   addCust.clickOnSave();
	   Thread.sleep(3000);
	}
	
	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String msg) {
	 
	Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The customer has been added successfully"));	
		
	}
	
	// Searching customer using email in the search table
   

@When("Enter customer Email")
public void enter_customer_email() {
	
	searchCustomerPage=new SearchCustomerPage(driver);
	searchCustomerPage.setEmail("brenda_lindgren@nopCommerce.com");
}
@When("Click on search button")
public void click_on_search_button() throws InterruptedException {
	searchCustomerPage.clickSearch();
	   Thread.sleep(3000);
}
@Then("User should found Email in the Search table")
public void user_should_found_email_in_the_search_table(){
	boolean status= searchCustomerPage.searchCustomerByEmail("brenda_lindgren@nopCommerce.com");
	System.out.println(status);
	Assert.assertEquals(true, status);

}

// steps for Searching Customer by using firstName and LastName

@When("Enter Customer FirstName")
public void enter_customer_first_name() {
    searchCustomerPage=new SearchCustomerPage(driver);
    searchCustomerPage.setFirstName("Brenda");
}
@When("Enter Customer LastName")
public void enter_customer_last_name() {
    searchCustomerPage.setLastName("Lindgren");
}

@Then("User shold found Name in the Search table")
public void user_shold_found_name_in_the_search_table() {
	boolean status= searchCustomerPage.searchCustomerByName();
    Assert.assertEquals(true, status);
}



}
