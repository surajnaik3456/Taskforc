package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Create {

	public static void main(String[] args) throws InterruptedException
	{
		// TODO Auto-generated method stub
		System.out.println("I'm inside browsersetup");
		WebDriverManager.chromedriver().setup(); 
		ChromeDriver driver = new ChromeDriver();
		/*driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));*/
		driver.manage().window().maximize();
		driver.get("https://qa.taskforc.com");
		Thread.sleep(2000);
		driver.findElement(By.id("email")).sendKeys("may@yopmail.com");
		driver.findElement(By.id("password")).sendKeys("Abcd@123");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='login-button']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/div[2]/a[2]/div[1]/*[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='add-button']")).click();
		Thread.sleep(2000);
		WebElement dropdown = driver.findElement(By.xpath("//body/div[3]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[2]"));
		Select select = new Select(dropdown);
		Thread.sleep(2000);
		select.selectByVisibleText("Test Two");
}
}
