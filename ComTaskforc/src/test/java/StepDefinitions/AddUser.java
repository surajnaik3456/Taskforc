package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    
	@Given("user is on homepage")
	public void user_is_on_home_page() 
	{
		
		driver.get("https://qa.taskforc.com");
		login =new LoginPage(driver);
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='login-main-row'][3]")));
		login.enterEmailId("may@yopmail.com");
		login.enterPassword("Abcd@123");
		login.clickLogin();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("img")));
	}
	@When("user clicks on user icon")
	public void clickUserIcon() 
	{
		home = new HomePage(driver);
		WebElement userIcon= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/div[2]/a[4]/div[1]/*[1]")));
		userIcon.click();
		System.out.println("user clicked on user icon");
	}
	@And("user clicks on Add user button")
	public void clickAddUser() 
	{
		home =new HomePage(driver);
		WebElement clickAddUser= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Add User']")));
		clickAddUser.click();
		System.out.println("user clicked on Add user button");
	}
	@Then("user gets Add user screen")
	public void addUserScreen() 
	{
		home =new HomePage(driver);
		WebElement addUserScreen = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class ='modal-header']")));
		addUserScreen.isDisplayed();
		System.out.println("Add User Screen displayed");
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
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='col-md'][1]")));
		home.emailEnt(email);
		home.pwdEnt(password);
		home.enterFirstName(firstname);
		home.enterLastName(lastname);
		home.projManagRole();
		home.activeStatus();	
		System.out.println("Form filled..");
	}
	@And ("user clicks on send invite button")
	public void clickInvite() 
	{
		home =new HomePage(driver);
		WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='apply-button']")));
		clickableElement.click();
	}
	@Then ("user gets added to Active user")
	public void userAdded() 
	{	
		driver.findElement(By.xpath("//*[text()='test02_13_08_2023@yopmail.com']")).isDisplayed();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='test02_13_08_2023@yopmail.com']")));
		System.out.println("User is added..");
	}
}
