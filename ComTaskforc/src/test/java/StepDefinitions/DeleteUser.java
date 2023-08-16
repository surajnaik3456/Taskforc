package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.HomePage;
import Pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteUser {
	WebDriver driver = null;
	LoginPage login;
	HomePage home;
	
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
		driver.close();
		driver.quit();
		System.out.println("Browser closed");
	}
	
	@And("user clicks on ellipsis menu for the {String} user")
	public void clickOnEllipsisMenu(String email) throws InterruptedException
	{
	    home = new HomePage(driver);
	    home.clickEllipsisMenu(email);
	    Thread.sleep(2000);
	    home.ellipsisMenu();
	    Thread.sleep(2000);
	}

	@Then("the dropdown shows up")
	public void dropdownShowsUp() throws InterruptedException {
		home = new HomePage(driver);
		home.ellipsisMenu();
	    Thread.sleep(2000);
	}

	@And("click on delete option")
	public void clickDeleteOption() throws InterruptedException {
		home = new HomePage(driver);
		home.clickDelete();
		Thread.sleep(2000);
	}

	@Then("Delete user screen showsup with Cancel and Delete button")
	public void deleteUserScreen() throws InterruptedException {
		home = new HomePage(driver);
		Thread.sleep(2000);
		home.deleteUserScreen();
	    
	}

	@And("user clicks on Delete button")
	public void clickDeleteButton() throws InterruptedException {
		home = new HomePage(driver);
		Thread.sleep(2000);
        home.deleteButtonClick();
	}

	@Then("user is deleted from the user management table")
	public void userDeleted() throws InterruptedException {
		home = new HomePage(driver);
		Thread.sleep(2000);
		home.checkUserDeleted();
	}
}
