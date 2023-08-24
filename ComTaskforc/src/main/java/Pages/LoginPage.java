package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	By email_id = By.id("email");
	By txt_password = By.id("password");
	By login_btn = By.xpath("//button[@class='login-button']");
	By txt_logo = By.tagName("img");
	By email_err_msg = By.xpath("//div[@class='invalid-feedback d-flex']");
	By pwd_err_msg = By.xpath("//body/div[@id='root']/div[1]/div[3]/div[1]/div[1]/form[1]/div[1]/div[2]/div[2]");
	By blank_email = By.xpath("//body/div[@id='root']/div[1]/div[3]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]");
	By blank_pwd = By.xpath("//body/div[@id='root']/div[1]/div[3]/div[1]/div[1]/form[1]/div[1]/div[2]/div[2]");
	By logout = By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/a[1]/div[1]/*[1]");
	By login_page = By.tagName("img");
	By welcome_page = By.xpath("//*[text()='Welcome back!']");

	public LoginPage(WebDriver driver)
	{
		this.driver =driver;
	}

	public void enterEmailId(String email)
	{
		driver.findElement(email_id).sendKeys(email);
	}
	public void enterPassword(String password)
	{
		driver.findElement(txt_password).sendKeys(password);
	}
	public void clickLogin()
	{
		driver.findElement(login_btn).click();
	} 
	public void checkHomepage()
	{
		driver.findElement(txt_logo).isEnabled();
	}
	public void invalidEmail()
	{
		driver.findElement(email_err_msg).isDisplayed();	
	}
	public void invalidPassword()
	{
		driver.findElement(pwd_err_msg).isDisplayed();
	}
	public void blankEmailField()
	{
		driver.findElement(blank_email).getText();
	}
	public void blankPassword()
	{
		driver.findElement(blank_pwd).getText();
	}
	public void logout()
	{
		driver.findElement(logout).click();
	}
	public void homePage()
	{
		driver.get("https://qa.taskforc.com");
		driver.findElement(email_id).sendKeys("may@yopmail.com");
		driver.findElement(txt_password).sendKeys("Abcd@123");
		driver.findElement(login_btn).click();
		driver.findElement(login_page).isDisplayed();
	}
	public void loginPg()
	{
		driver.findElement(login_page).isDisplayed();
	}
	public void welcomePg()
	{
		driver.findElement(welcome_page).isDisplayed();
	}
}