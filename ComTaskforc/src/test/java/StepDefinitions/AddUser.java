package StepDefinitions;

import org.openqa.selenium.By;
import Pages.HomePage;
import Pages.LoginPage;
import TestBase.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class AddUser extends TestBase {
	LoginPage login;
	HomePage home;

	@Given("user is on homepage")
	public void user_is_on_home_page() throws InterruptedException
	{
		
		driver.get("https://qa.taskforc.com");
		login =new LoginPage(driver);
		Thread.sleep(2000);
		login.enterEmailId("may@yopmail.com");
		login.enterPassword("Abcd@123");
		login.clickLogin();
		Thread.sleep(2000);
	}
	@When("user clicks on user icon")
	public void clickUserIcon() throws InterruptedException
	{
		home = new HomePage(driver);
		home.userIconClick();
		Thread.sleep(2000);
	}
	@And("user clicks on Add user button")
	public void clickAddUser() throws InterruptedException
	{
		home =new HomePage(driver);
		Thread.sleep(2000);
		home.clickAddUser();
		Thread.sleep(2000);
	}
	@Then("user gets Add user screen")
	public void addUserScreen() throws InterruptedException
	{
		home =new HomePage(driver);
		Thread.sleep(2000);
		home.addUserScreenDisplayed();
		System.out.println("Screen displayed");
	}
	@Then ("user gets user management screen")
	public void managementScreen()
	{
		home =new HomePage(driver);
		System.out.println("user is on management screen");
	}
	@When ("user fills the form with {string},{string},{string},{string}, Role and Status")
	public void fillForm(String email,String password,String firstname, String lastname) throws InterruptedException 
	{
		home =new HomePage(driver);
		Thread.sleep(2000);
		home.emailEnt(email);
		home.pwdEnt(password);
		home.enterFirstName(firstname);
		home.enterFirstName(lastname);
		Thread.sleep(2000);
		home.projManagRole();
		Thread.sleep(2000);
		home.activeStatus();	
		Thread.sleep(2000);
	}
	@And ("user clicks on send invite button")
	public void clickInvite() throws InterruptedException
	{
		home =new HomePage(driver);
		home.clickInvite();
		Thread.sleep(2000);
	}
	@Then ("user gets added to Active user")
	public void userAdded() throws InterruptedException
	{
		Thread.sleep(2000);	
		driver.findElement(By.xpath("//*[text()='User Management']")).isDisplayed();
	}
}
