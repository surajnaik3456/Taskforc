package Hooks;

import TestBase.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;


public class Hooks {
	TestBase base;

	public Hooks()
	{
		base = new TestBase();
	}
	
	@Before
	public void browserSetup()
	{
		base.BrowserLaunch();
		System.out.println("I'm inside browsersetup");
	}

	@After
	public void tearDown()
	{
		System.out.println("Browser closed");
		base.QuitBrowser();
	}
}
