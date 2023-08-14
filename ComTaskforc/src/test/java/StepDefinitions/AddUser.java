package StepDefinitions;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.HomePage;
import Pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AddUser {
	WebDriver driver = null;
	LoginPage login;
	HomePage Home;
	
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
	@Given("User is on homepage")
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
	@When("User clicks on user icon")
	public void Click_user_icon() throws InterruptedException
	{
		Home = new HomePage(driver);
		Home.Usericon_click();
		Thread.sleep(2000);
	}
	@And("User clicks on Add user button")
	public void click_add_user() throws InterruptedException
	{
		Home =new HomePage(driver);
		Thread.sleep(2000);
		Home.ClickAdduser();
		Thread.sleep(2000);
	}
	@Then("User gets Add user screen")
	public void Add_user_screen() throws InterruptedException
	{
		Home =new HomePage(driver);
		Thread.sleep(2000);
		Home.AddUserScreen_displayed();
		System.out.println("Screen displayed");
	}
	@Then ("User gets user management screen")
	public void management_Screen()
	{
		Home =new HomePage(driver);
		System.out.println("user is on management screen");
	}
	@When ("User fills the form with (.*),(.*),(.*),(.*), Role and Status as active")
	public void fill_form(String email,String password,String firstname, String lastname) throws InterruptedException 
	{
		Home =new HomePage(driver);
		Thread.sleep(2000);
		Home.EmailEnt(email);
		Home.PwdEnt(password);
		Home.EnterFirstName(firstname);
		Home.EnterLastName(lastname);
		Thread.sleep(2000);
		Home.ProjManagRole();
		Thread.sleep(2000);
		Home.Activestatus();	
		Thread.sleep(2000);
	}
	@And ("User clicks on send invite button")
	public void Click_invite()
	{
		Home =new HomePage(driver);
		Home.Click_invite();
	}
	@Then ("User gets added to Active user")
	public void user_added()
	{
		System.out.println("User Added");
	}
}
