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
	public void user_is_on_login_page()
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
	public void click_on_log_in_button() throws InterruptedException {
		login =new LoginPage(driver);
		login.clickLogin();
		Thread.sleep(2000);
	}

	@Then("user is navigated to homepage")
	public void user_is_navigated_to_homepage() {
		login =new LoginPage(driver);
		login.checkHomepage();
	}

	@When("^user enters invalid (.*) and valid (.*)$")
	public void user_enters_invalid_email_id_and_valid_password(String EmailId, String password ) throws InterruptedException {
		login =new LoginPage(driver);
		Thread.sleep(2000); 
		login.enterEmailId(EmailId);
		login.enterPassword(password);
		Thread.sleep(2000);
	}

	@Then("the user should see an error message indicating Email is invalid")
	public void the_user_should_see_an_error_message_indicating_email_is_invalid() {
		login =new LoginPage(driver);
		login.invalidEmail();
	}

	@When("user enters valid (.*) and invalid (.*)")
	public void user_enters_valid_email_id_and_invalid_password(String EmailId, String password ) throws InterruptedException {
		login =new LoginPage(driver);
		Thread.sleep(2000); 
		login.enterEmailId(EmailId);
		login.enterPassword(password);
		Thread.sleep(2000);
	}

	@Then("the user should see an error message indicating Password complexity requirement")
	public void the_user_should_see_an_error_message_indicating_password_complexity_requirement() throws InterruptedException {
		login =new LoginPage(driver);
		Thread.sleep(2000);
		login.invalidPassword();
	}

	@When("the user leaves both username and password fields empty")
	public void the_user_leaves_both_username_and_password_fields_empty() throws InterruptedException {
		login =new LoginPage(driver);
		Thread.sleep(2000);
		System.out.println("Both field empty");
	}

	@Then("the user should see an error message indicating required fields")
	public void the_user_should_see_an_error_message_indicating_required_fields() throws InterruptedException {
		login =new LoginPage(driver);
		Thread.sleep(2000);
		login.invalidEmail();
		login.invalidPassword();
	}

	@Given("the user is logged in")
	public void the_user_is_logged_in() throws InterruptedException {
		login =new LoginPage(driver);
		login.homePage();
		Thread.sleep(2000);
	}

	@When("the user clicks on the logout button")
	public void the_user_clicks_on_the_logout_button() {
		login =new LoginPage(driver);
		login.logout();
	}

	@Then("the user should be logged out and redirected to the login page")
	public void the_user_should_be_logged_out_and_redirected_to_the_login_page() throws InterruptedException {
		login =new LoginPage(driver);
		Thread.sleep(2000);
		login.loginPg();
	}
	//	@Then("Verify that {string} system role should be able to choose")
	//    public void verifyThatSystemRoleShouldBeAbleToChoose(String systemRole) {
	//        AddNewSystemDialog addNewSystemDialog = new AddNewSystemDialog(getDriver());
	//        Assert.assertTrue(addNewSystemDialog.selectSystemRole(systemRole));
	//    }
}
