package Practice;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import Generic_Utility.PropertiesFileUtility;

public class Utilisation_GenericUtility {
public static void main(String[] args) throws InterruptedException, IOException {
	PropertiesFileUtility propUtil=new PropertiesFileUtility();	
	String BROWSER = propUtil.readingDataFromPropertyFile("browser");
	String URL = propUtil.readingDataFromPropertyFile("url");
	String UNAME=propUtil.readingDataFromPropertyFile("uname");
	String PWD =propUtil.readingDataFromPropertyFile("pwd");
	System.out.println(BROWSER);
	System.out.println(URL);
	System.out.println(UNAME);
	System.out.println(PWD);

	String expectedURL="http://49.249.28.218:8098/dashboard";
	//launching browser
	WebDriver driver=null;
	if(BROWSER.equalsIgnoreCase("chrome"))
	{
		driver=new ChromeDriver();
	}
	else if(BROWSER.equalsIgnoreCase("firefox"))
	{
		driver=new FirefoxDriver();
	}
	else if(BROWSER.equalsIgnoreCase("edge"))
	{
		driver=new EdgeDriver();
	}
	else
	{
		driver=new ChromeDriver();
	}
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	//navigate to ninja CRM
	driver.get(URL);
	driver.findElement(By.id("username")).sendKeys(UNAME);
	driver.findElement(By.id("inputPassword")).sendKeys(PWD);
	//click on submit button
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	Thread.sleep(2000);
	//verification of dashboard

	String actualURL = driver.getCurrentUrl();
	if(actualURL.equals(expectedURL))
	{
		System.out.println("Validation is pass");
	}
	else
	{
		System.out.println("Validation is fail");
	}
	//Logout
	driver.findElement(By.xpath("//div[@class='user-icon']")).click();
	WebElement logoutBtn = driver.findElement(By.xpath("//div[text()='Logout ']"));
	Actions action =new Actions(driver);
	action.moveToElement(logoutBtn).click().perform();

	//driver.findElement(By.xpath("//div[@class='dropdown-item logout']")).click();
Thread.sleep(3000);
	driver.quit();
	
}
}


