package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	WebDriver driver;
	WebDriverWait wait;
	By add_user = By.xpath("//body/div[@id='root']/div[1]/div[1]/div[2]/div[2]/div[1]/div[4]/button[1]");
	By first_name = By.xpath("//input[@id='first_name']");
	By last_name = By.id("last_name");
	By enter_email = By.id("email");
	By enter_password = By.id("password");
	By role = By.xpath("/html/body/div[3]/div/div/div[2]/form/div/div[2]/div[1]/div[2]/div/div/div[1]/div[2]");
	By status = By.xpath("//body/div[5]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]");
	By add_user_screen = By.xpath("//div[@xpath=1]");
	By add_user_btn = By.xpath("//body/div[@id='root']/div[1]/div[1]/div[2]/div[2]/div[1]/div[4]/button[1]");
	By user_icon = By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/div[2]/a[4]/div[1]/*[1]");
	By send_invite = By.xpath("//button[@class='apply-button']");
	By click_ellipsis_menu = By.xpath("//*[text()='test_4_13_08_2023@yopmail.com']/following-sibling::*[2]//button[@id='dropdown-basic']");
	By menu_displayed = By.xpath("//div[@class='dropdown-menu show']");
	By click_delete_user = By.xpath("//a[@class='dropdown-item'][3]");
	By delete_user_screen = By.xpath("//div[@class='d-flex justify-content-center']");
	By delete_button_click = By.xpath("//button[@class='delete-btn']");
	By user_deleted_check = By.xpath("//*[text()='test_1_04_08_2023@yopmail.com']");

	public HomePage(WebDriver driver)
	{
		this.driver =driver;
	}
	public HomePage(WebDriverWait wait)
	{
		this.wait =wait;
	}
	
	public void clickAddUser()
	{
		driver.findElement(add_user).click();
	}
	public void addUserScreenDisplayed()
	{
		driver.findElement(add_user_screen).isDisplayed();
	}

	public void enterFirstName(String firstname)
	{
		driver.findElement(first_name).sendKeys(firstname);
	}
	public void enterLastName(String lastname)
	{
		driver.findElement(last_name).sendKeys(lastname);
	}
	public void emailEnt(String email)
	{
		driver.findElement(enter_email).sendKeys(email);	
	}
	public void pwdEnt(String password)
	{
		driver.findElement(enter_password).sendKeys(password);
	}
	public void userIconClick()
	{
		driver.findElement(user_icon).click();
	}
	public void addUserClick()
	{
		driver.findElement(add_user_btn).click();
	}

	public void projManagRole() throws InterruptedException
	{
		WebElement dropdown = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/form/div/div[2]/div[1]/div[2]/div/div/div[1]/div[2]"));
		dropdown.click();
		List<WebElement>option = driver.findElements(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]"));
		Thread.sleep(2000);
		for(WebElement obj: option)
		{
			obj.getText().equals("Project Manager");
			obj.click();

		}
	}
	public void activeStatus() throws InterruptedException
	{
		WebElement status = driver.findElement(By.xpath("//body/div[3]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]"));
		status.click();
		List<WebElement>active = driver.findElements(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]"));
		Thread.sleep(2000);
		for(WebElement st: active)
		{
			st.getText().equals("Active");
			st.click();

		}
	}
	public void clickInvite()
	{
		driver.findElement(send_invite).click();
	}
	public void clickEllipsisMenu(String email)
	{
		driver.findElement(By.xpath("//*[text()='"+email+"']/following-sibling::*[2]//button[@id='dropdown-basic']")).click();
	}
	public void ellipsisMenu()
	{
		driver.findElement(menu_displayed).isDisplayed();
	}
	public void clickDelete()
	{
		driver.findElement(click_delete_user).click();;
	}
	public void deleteUserScreen()
	{
		driver.findElement(delete_user_screen).isDisplayed();
	}
	public void deleteButtonClick()
	{
		driver.findElement(delete_button_click).click();
	}
	public void checkUserDeleted()
	{
		driver.findElement(user_deleted_check).isDisplayed();

	}
}
