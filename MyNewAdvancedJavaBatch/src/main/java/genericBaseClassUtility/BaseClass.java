package genericBaseClassUtility;

import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import Generic_Utility.DatabaseUtility;
import Generic_Utility.PropertiesFileUtility;
import ObjectRepository.DashboardPage;
import ObjectRepository.LoginPage;

public class BaseClass {
	public WebDriver driver=null;
	public static WebDriver sdriver=null;
	DatabaseUtility dbUtil= new DatabaseUtility();
	PropertiesFileUtility pro=new PropertiesFileUtility();
	@BeforeSuite
	public void beforeSuit()
	{
		System.out.println("Established database connection");
		dbUtil.getDBConection("jdbc:mysql://localhost:3306/Ninja_E18","root", "AnuVasu0617@");
	}
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("Pre Configuration set up");
		System.out.println("===================================");
	}
	
	@BeforeClass
	
	public void beforeClass() throws IOException
	{
		System.out.println("Launch the browser");
		String BROWSER=pro.readingDataFromPropertyFile("browser");
		ChromeOptions Coption=new ChromeOptions();
		FirefoxOptions Foption=new FirefoxOptions();
		EdgeOptions Eoption=new EdgeOptions();
		Coption.addArguments("--headless");
		Foption.addArguments("--headless");
		Eoption.addArguments("--headless");
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
		sdriver=driver;
	}
	@BeforeMethod
	public void beforeMethod() throws IOException
	{
		System.out.println("Login");
		System.out.println("===================================================");
		String URL=pro.readingDataFromPropertyFile("url");
		String UN=pro.readingDataFromPropertyFile("uname");
		String PWD=pro.readingDataFromPropertyFile("pwd");
		driver.get(URL);
		LoginPage lp=new LoginPage(driver);
		lp.login(UN, PWD);
		
	}
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("Logout");
		System.out.println("==========================");
		DashboardPage dp=new DashboardPage(driver);
		dp.logout();
	}
	@AfterClass
	public void afterclass()
	{
		System.out.println("Close the Browser");
		System.out.println("============================");
		driver.quit();
	}
	@AfterTest
	public void afterTest()
	{
		System.out.println("Post configuration set up");
	}
	@AfterSuite
	public void aftersuit()
	{
		System.out.println("Close the db Connection");
		System.out.println("===================================");
		dbUtil.closeDBConnection();
	}

}
