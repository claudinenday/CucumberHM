package steps;



import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pages.AddBankAndCashPage;
import pages.LoginPage;
import pages.TestBase;

public class LoginStepDefinition extends TestBase {
	
	LoginPage loginPage;
	AddBankAndCashPage bankandcash;
	

	
	@Before
	public void beforeRun() {
		initDriver();
		
		loginPage= PageFactory.initElements(driver, LoginPage.class);	
		bankandcash= PageFactory.initElements(driver, AddBankAndCashPage.class);
		
	}

	@Given("User is on the techfios login page")
	public void user_is_on_the_techfios_login_page() {
		driver.get("https://techfios.com/billing/?ng=admin/");

	}

	@When("User enters the {string} in the {string} field")
	public void user_enters_the_in_the_field(String logindata, String logindataField) {
	
		
		
		switch (logindataField) {
		
		case "username":
			
			loginPage.enterUserName(logindata);
		
			break;
			
		case "password":
			loginPage.enterPassword(logindata);
			
			break;
		}			

	}

	@When("User clicks on {string}")
	public void user_clicks_on(String clickOn) {
		
		
		switch (clickOn) {
		
		case "login":
			loginPage.clickSignInButton();
			break;
		case "bankCash":
		bankandcash.clickBankAndCash();
		break;
		
		case "newAccount":
		bankandcash.clickNewAccount();
		break;
		case "submit":
			bankandcash.clickSubmitButton();
			break;
		
		
		}
		
		

	}

	@Then("User should land on Dashboard page")
	public void user_should_land_on_Dashboard_page() {
		String expedtedDashboardHeader= "Dashboard";
		String ActualDashboardHeader= loginPage.getPageHeader();
		Assert.assertEquals("Dashborad page not found", expedtedDashboardHeader, ActualDashboardHeader);
		screenshot(driver);

	}

	@Then("User enters {string} in the {string} field in accounts page")
	public void user_enters_in_the_field_in_accounts_page(String customerData, String customerDataField) {

		switch (customerDataField) {
		
		case "accountTitle":
			bankandcash.insertAccountTitle(customerData);
			break;
		case "description":
			bankandcash.insertDescription(customerData);
			break;
		case "initialBalance":
			bankandcash.insertInitialBalance(customerData);
			break;
		case "accountNumber":
			bankandcash.insertAccauntNumber(customerData);
			break;
		case "contactPerson":
			bankandcash.insertContactPerson(customerData);
			break;
		case "Phone":
			bankandcash.insertPhoneNumber(customerData);
			break;
		case "internetBankingURL":
			bankandcash.insertInternetBankingUrl(customerData);
			break;
		
		
		}
		
	}

	@Then("User should be able to validate account created successfully")
	public void user_should_be_able_to_validate_account_created_successfully() {
		String expectedPagerHeader ="Manage Accounts";
		String ActualPageHeader= bankandcash.validationPage();				
		Assert.assertEquals("Account added successfully", expectedPagerHeader, ActualPageHeader);
		screenshot(driver);

	}
	

	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
