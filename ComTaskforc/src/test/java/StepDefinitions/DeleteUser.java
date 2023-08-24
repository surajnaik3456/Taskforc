package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.HomePage;
import Pages.LoginPage;
import TestBase.TestBase;
import io.cucumber.java.en.*;

public class DeleteUser extends TestBase {
	LoginPage login;
	HomePage home;
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	

	@And("user clicks on ellipsis menu for the {string} user")
	public void clickOnEllipsisMenu(String email) 
	{
	    home = new HomePage(driver);
	    home.clickEllipsisMenu(email);
	    home.ellipsisMenu();
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='dropdown-menu show']")));
	}

	@Then("the dropdown shows up")
	public void dropdownShowsUp()  {
		home = new HomePage(driver);
		home.ellipsisMenu();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='dropdown-menu show']")));
	}

	@And("click on delete option")
	public void clickDeleteOption()  {
		home = new HomePage(driver);
		WebElement clickDelete = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='dropdown-item'][3]")));
		clickDelete.click();
	}

	@Then("Delete user screen showsup with Cancel and Delete button")
	public void deleteUserScreen()  {
		home = new HomePage(driver);
		home.deleteUserScreen();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='delete-btn']")));
	    
	}

	@And("user clicks on Delete button")
	public void clickDeleteButton()  {
		home = new HomePage(driver);
		WebElement clickDeleteButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='delete-btn']")));
		clickDeleteButton.click(); 
	}

	@Then("user is deleted from the user management table")
	public void userDeleted() 
	{
		home = new HomePage(driver);
		 try {
	            WebElement deletedElement = driver.findElement(By.xpath("//*[contains(text(),'test02_13_08_2023@yopmail.com')]"));

	            if (deletedElement.isDisplayed()) {
	                System.out.println("User is not deleted");
	            } else {
	                System.out.println("User is deleted");
	            }
	        } catch(org.openqa.selenium.NoSuchElementException e) {
	            System.out.println("User is deleted");

	}
}
}
