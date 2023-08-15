package StepDefinitions;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSteps {
	WebDriver driver = null;
	LoginPage login;

	@Before
	public void browserSetup()
	{
		System.out.println("I'm inside browsersetup");
		WebDriverManager.chromedriver().setup(); 
		driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}

	@After
	public void tearDown()
	{
		System.out.println("Browser closed");
		driver.close();
		driver.quit();
	}


	@Given("user is on login page")
	public void userIsOnLoginPage()
	{

		driver.get("https://qa.taskforc.com");

	}

	@When("^user enters valid (.*) and (.*)$")
	public void user_enters_valid_email_and_password(String email, String password) throws InterruptedException {
		login =new LoginPage(driver);
		Thread.sleep(2000);
		login.enterEmailId(email);
		login.enterPassword(password);
		Thread.sleep(3000);
	}

	@And("click on log in button")
	public void clickOnLoginButton() throws InterruptedException {
		login =new LoginPage(driver);
		login.clickLogin();
		Thread.sleep(2000);
	}

	@Then("user is navigated to homepage")
	public void userIsNavigatedToHomepage() {
		login =new LoginPage(driver);
		login.checkHomepage();
	}

	@When("^user enters invalid (.*) and valid (.*)$")
	public void invalidEmailIdAndValidPassword(String emailid, String password ) throws InterruptedException {
		login =new LoginPage(driver);
		Thread.sleep(2000); 
		login.enterEmailId(emailid);
		login.enterPassword(password);
		Thread.sleep(2000);
	}

	@Then("the user should see an error message indicating Email is invalid")
	public void emailIsInvalidError() {
		login =new LoginPage(driver);
		login.invalidEmail();
	}

	@When("user enters valid (.*) and invalid (.*)")
	public void validEmailIdInvalidPassword(String emailid, String password ) throws InterruptedException {
		login =new LoginPage(driver);
		Thread.sleep(2000); 
		login.enterEmailId(emailid);
		login.enterPassword(password);
		Thread.sleep(2000);
	}

	@Then("the user should see an error message indicating Password complexity requirement")
	public void passwordComplexityRequirement() throws InterruptedException {
		login =new LoginPage(driver);
		Thread.sleep(2000);
		login.invalidPassword();
	}

	@When("the user leaves both username and password fields empty")
	public void usernameAndPasswordFieldEmpty() throws InterruptedException {
		login =new LoginPage(driver);
		Thread.sleep(2000);
		System.out.println("Both field empty");
	}

	@Then("the user should see an error message indicating required fields")
	public void errorMessageIndicatingRequiredFields() throws InterruptedException {
		login =new LoginPage(driver);
		Thread.sleep(2000);
		login.invalidEmail();
		login.invalidPassword();
	}

	@Given("the user is logged in")
	public void userIsLoggedIn() throws InterruptedException {
		login =new LoginPage(driver);
		login.homePage();
		Thread.sleep(2000);
	}

	@When("the user clicks on the logout button")
	public void clicksLogoutButton() {
		login =new LoginPage(driver);
		login.logout();
	}

	@Then("the user should be logged out and redirected to the login page")
	public void redirectedToLoginPage() throws InterruptedException {
		login =new LoginPage(driver);
		Thread.sleep(2000);
		login.loginPg();
	}
}
