package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.LoginPage;
import TestBase.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends TestBase

{
	LoginPage login;
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));

	@Given("user is on login page")
	public void userIsOnLoginPage()
	{

		driver.get("https://qa.taskforc.com");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("img")));
	}

	@When("^user enters valid (.*) and (.*)$")
	public void user_enters_valid_email_and_password(String email, String password) {
		login =new LoginPage(driver);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("img")));
		login.enterEmailId(email);
		login.enterPassword(password);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='login-button']")));
	}

	@And("click on log in button")
	public void clickOnLoginButton()  {
		login =new LoginPage(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='login-button']")));
		login.clickLogin();

	}

	@Then("user is navigated to homepage")
	public void userIsNavigatedToHomepage() {
		login =new LoginPage(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("img")));
		login.checkHomepage();
	}

	@When("^user enters invalid (.*) and valid (.*)$")
	public void invalidEmailIdAndValidPassword(String emailid, String password ) {
		login =new LoginPage(driver);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("img")));
		login.enterEmailId(emailid);
		login.enterPassword(password);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='login-button']")));
	}

	@Then("the user should see an error message indicating Email is invalid")
	public void emailIsInvalidError() {
		login =new LoginPage(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='invalid-feedback d-flex']")));
		login.invalidEmail();
	}

	@When("user enters valid (.*) and invalid (.*)")
	public void validEmailIdInvalidPassword(String emailid, String password )  {
		login =new LoginPage(driver);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("img")));
		login.enterEmailId(emailid);
		login.enterPassword(password);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='login-button']")));
	}

	@Then("the user should see an error message indicating Password complexity requirement")
	public void passwordComplexityRequirement() {
		login =new LoginPage(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='invalid-feedback d-flex']")));
		login.invalidPassword();
	}

	@When("the user leaves both username and password fields empty")
	public void usernameAndPasswordFieldEmpty()  {
		login =new LoginPage(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='login-button']")));
		System.out.println("Both field empty");
	}

	@Then("the user should see an error message indicating required fields")
	public void errorMessageIndicatingRequiredFields() {
		login =new LoginPage(driver);
		login.invalidEmail();
		login.invalidPassword();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='invalid-feedback d-flex']")));
		System.out.println("error occured");
	}

	@Given("the user is logged in")
	public void userIsLoggedIn()  {
		login =new LoginPage(driver);
		login.homePage();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Welcome ']")));
	}

	@When("the user clicks on the logout button")
	public void clicksLogoutButton() {
		login =new LoginPage(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]")));
		login.logout();
	}

	@Then("the user should be logged out and redirected to the login page")
	public void redirectedToLoginPage() {
		login =new LoginPage(driver);
		login.loginPg();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[@class='title']")));
	}
}
