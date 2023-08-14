package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
	WebDriver driver;
	By AddUser = By.xpath("//body/div[@id='root']/div[1]/div[1]/div[2]/div[2]/div[1]/div[4]/button[1]");
	By FirstName = By.xpath("//input[@id='first_name']");
	By LastName = By.id("last_name");
	By EnterEmail = By.id("email");
	By EnterPassword = By.id("password");
	By Role = By.xpath("//*[text()='Select Role'][1]");
	By Status = By.xpath("//body/div[5]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]");
	By Adduserscreen = By.xpath("//div[@xpath=1]");
	By Adduserbtn = By.xpath("//body/div[@id='root']/div[1]/div[1]/div[2]/div[2]/div[1]/div[4]/button[1]");
    By Usericon = By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/div[2]/a[4]/div[1]/*[1]");
    By Sendinvite = By.xpath("//button[@class='apply-button']");

	public HomePage(WebDriver driver)
	{
		this.driver =driver;
	}
	public void ClickAdduser()
	{
		driver.findElement(AddUser).click();
	}
	public void AddUserScreen_displayed()
	{
		driver.findElement(Adduserscreen).isDisplayed();
	}
	
	public void EnterFirstName(String firstname)
	{
		driver.findElement(FirstName).sendKeys(firstname);
	}
	public void EnterLastName(String lastname)
	{
		driver.findElement(LastName).sendKeys(lastname);
	}
	public void EmailEnt(String email)
	{
	driver.findElement(EnterEmail).sendKeys(email);	
	}
	public void PwdEnt(String password)
	{
	driver.findElement(EnterPassword).sendKeys(password);
	}
	public void Usericon_click()
	{
	driver.findElement(Usericon).click();
	}
	public void Adduser_click()
	{
	driver.findElement(Adduserbtn).click();
	}
	public void ProjManagRole()
	{
		WebElement role = driver.findElement(By.xpath("//body/div[3]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]"));
		Select dropdown = new Select(role);
		dropdown.selectByVisibleText("Project Manager"+Keys.ENTER);
	}
	public void Activestatus()
	{
		WebElement status = driver.findElement(Status);
		Select dropdown = new Select(status);
		dropdown.selectByVisibleText("Active"+Keys.ENTER);
	}
	public void Click_invite()
	{
		driver.findElement(Sendinvite).click();
	}
	
}
