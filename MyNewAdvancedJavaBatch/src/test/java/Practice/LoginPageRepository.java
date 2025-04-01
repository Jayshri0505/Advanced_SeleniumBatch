package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ObjectRepository.DashboardPage;
import ObjectRepository.LoginPage;

public class LoginPageRepository {
public static void main(String[] args) throws InterruptedException, IOException {
	FileInputStream fs=new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\MyNewAdvancedJavaBatch\\src\\test\\resources\\commondata.properties");
	Properties prop=new Properties();
	prop.load(fs);
	
	String BROWSER = prop.getProperty("browser");
	String URL = prop.getProperty("url");
	String UNAME= prop.getProperty("uname");
	String PWD = prop.getProperty("pwd");
	
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
	driver.get(URL);
	LoginPage lp=new LoginPage(driver);
	lp.login(UNAME, PWD);
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
		DashboardPage lg=new DashboardPage(driver);
		lg.logout();
		Thread.sleep(3000);
		driver.quit();
	}
}





