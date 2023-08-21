package StepDefinitions;

import Pages.HomePage;
import Pages.LoginPage;
import TestBase.TestBase;
import io.cucumber.java.en.*;

public class DeleteUser extends TestBase {
	LoginPage login;
	HomePage home;
	

	@And("user clicks on ellipsis menu for the {string} user")
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
		Thread.sleep(2000);

	}
}
