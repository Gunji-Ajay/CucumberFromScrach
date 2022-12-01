package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomer {
	public WebDriver driver;

	public AddCustomer(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);


	}   
	By lnkCustomers_menu=By.xpath("//a[@href='#']/p[contains(text(),'Customers')]");
	By lnkCustomers_menuitem=By.xpath("//a[@href='/Admin/Customer/List']");

	By btnAddnew=By.xpath("//a[@class='btn btn-primary']");

	By txtEmail=By.xpath("//input[@id='Email']");
	By txtPassword=By.xpath("//input[@id='Password']");

	By txtcustomerRoles=By.xpath("//*[@id=\"customer-info\"]/div[2]/div[10]/div[2]/div/div[1]/div/div");

	By lstItemAdministrators=By.xpath("//li[contains(text(),'Administrators')]");
	By lstItemRegistered=By.xpath("//li[contains(text(),'Registered')]");
	By lstItemGuests=By.xpath("//li[contains(text(),'Guests')]");
	By lstItemVendors=By.xpath("//li[contains(text(),'Vendors')]");

	By drpmgOfVendor=By.id("VendorId");
	By rdMaleGender=By.id("Gender_Male");
	By rdFeMaleGender=By.id("Gender_Female");

	By txtFirstName=By.id("FirstName");
	By txtLastName=By.id("LastName");

	By txtDob=By.id("DateOfBirth");

	By txtComapnyName=By.id("Company");

	By txtAdminContent=By.id("AdminComment");

	By btnSave=By.name("save");

	// Actions Methods

	public String getPageTitle() {
		return driver.getTitle();
	}
	public void clickOnCustomerMenu() {
		driver.findElement(lnkCustomers_menu).click();
	}

	public void clickOnCustomerMenuItem() {
		driver.findElement(lnkCustomers_menuitem).click();
	}

	public void clickOnAddNew() {
		driver.findElement(btnAddnew).click();
	}

	public void setEmail(String email) {
		driver.findElement(txtEmail).sendKeys(email);
	}

	public void setPassword(String password) {
		driver.findElement(txtPassword).sendKeys(password);

	}

	public void setCustomerRoles(String role){
		if(!role.equals("Vendors")) {
			driver.findElement(By.xpath("//*[@id='SelectedCustomerRoleIds_taglist']/li/span[2]")).click();
		}
		driver.findElement(txtcustomerRoles).click();
		//elect drp=new Select(driver.findElement(By.id("SelectedCustomerRoleIds")));
		
		WebElement listItem;
		if(role.equals("Administrators")) {
			listItem=driver.findElement(lstItemAdministrators);

		}
		else if(role.equals("Guests")) {
	
			listItem=driver.findElement(lstItemGuests);
		}
		else if(role.equals("Registered")) {
			listItem=driver.findElement(lstItemRegistered);
		}
		else if (role.equals("Vendors")) {
			listItem=driver.findElement(lstItemVendors);
		}
		else {
			listItem=driver.findElement(lstItemGuests);
		}

		listItem.click();
		//Select s = new Select(driver.findElement(txtcustomerRoles));
		//s.selectByVisibleText("Guests");;
		//    JavascriptExecutor js=(JavascriptExecutor)driver;
		//    js.executeScript("arguments[0].click()", listItem);
	}
	public void setManagerOfVendor(String value) {
		Select drp=new Select(driver.findElement(drpmgOfVendor));
		drp.selectByVisibleText(value);
	}
	public void setGender(String gender) {
		if(gender.equals("Male")) {
			driver.findElement(rdMaleGender).click();
		}
		else if(gender.equals("Female")) {
			driver.findElement(rdFeMaleGender).click();
		}
		else {
			driver.findElement(rdMaleGender).click(); //default
		}
	}

	public void setFirstName(String fname) {
		driver.findElement(txtFirstName).sendKeys(fname);
	}

	public void setLastName(String lname) {
		driver.findElement(txtLastName).sendKeys(lname);
	}
	public void setDob(String dob) {
		driver.findElement(txtDob).sendKeys(dob);
	}
	public void setCompanyName(String company) {
		driver.findElement(txtComapnyName).sendKeys(company);
	}
	public void setAdminContent(String content) {
		driver.findElement(txtAdminContent).sendKeys(content);
	}
	public void clickOnSave() {
		driver.findElement(btnSave);
	}



}

