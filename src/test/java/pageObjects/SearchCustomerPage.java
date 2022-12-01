package pageObjects;

import java.util.List;

import javax.swing.table.TableColumn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;

public class SearchCustomerPage {
	public WebDriver driver;
    WaitHelper waithelper;
	public SearchCustomerPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
	  this.driver=driver;
	  PageFactory.initElements(driver, this);
	  waithelper=new WaitHelper(driver);
	 
	}
	@FindBy(how=How.ID,using ="SearchEmail")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(how =How.ID,using = "SearchFirstName")
	@CacheLookup
	WebElement txtFirstName;
	
	@FindBy(how=How.ID,using ="SearchLastName")
    @CacheLookup
    WebElement txtLastName;
	
	@FindBy(how=How.ID,using = "search-customers")
	@CacheLookup 
	WebElement btnSearch;
	
	@FindBy(how=How.XPATH,using="//table[@role='grid']")
	@CacheLookup 
	WebElement tablesearchResults;
	
	@FindBy(how=How.XPATH,using = "//table[@id='customers-grid']")
	@CacheLookup
	WebElement table;
	
	@FindBy(how=How.XPATH,using = "//table[@id='customers-grid']/tbody/tr")
	@CacheLookup
	List<WebElement> tableRows;
	
	@FindBy(how=How.XPATH,using = "//table[@id='customers-grid']/tbody/tr/td")
	@CacheLookup
	List<WebElement> TableColumns;
	

	
	
	public void setEmail(String email) {
		waithelper.WaitForElement(txtEmail,30);
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}
	
	public void setFirstName(String fname) {
		waithelper.WaitForElement(txtFirstName,30);
		txtFirstName.clear();
		txtFirstName.sendKeys(fname);
	}


	public void setLastName(String lname) {
		waithelper.WaitForElement(txtLastName,30);
		txtLastName.clear();
		txtLastName.sendKeys(lname);
	}
     
	public void clickSearch() {
		btnSearch.click();
		waithelper.WaitForElement(btnSearch, 30);
	}
	
	public boolean searchCustomerByEmail(String email) {
		boolean flag=false;
		for(int i=1;i<=getNoOfRows();i++) {
			String emailId=driver.findElement(By.xpath("//*[@id=\"customers-grid\"]/tbody/tr["+i+"]/td[2]")).getText();
		     System.out.println(emailId);
		     if(emailId.equals(email)) {
		    	 flag=true;
		     }
		}
		
		return flag;
		
	}
	public boolean searchCustomerByName() {
		boolean flag=false;
		for(int i=1;i<=getNoOfRows();i++) {
			String name=driver.findElement(By.xpath("//*[@id=\"customers-grid\"]/tbody/tr["+i+"]/td[3]")).getText();
		    String names[]=name.split(" ");
			System.out.println(names);
		     if(names[0].equals("Brenda")&&names[1].equals("Lindgren")) {
		    	 flag=true;
		     }
		}
		
		return flag;
		
	}
	
	public int getNoOfRows() {
		return (tableRows.size());
	}
	public int getNoOfColumns() {
		return(TableColumns.size());
	}
	
}
