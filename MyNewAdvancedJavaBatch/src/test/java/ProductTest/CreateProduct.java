package ProductTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ObjectRepository.DashboardPage;
import ObjectRepository.LoginPage;

public class CreateProduct {
	@Parameters("browser")

	@Test(groups= {"IntegrationTest"})
public void createProductTest() throws InterruptedException, IOException {
	FileInputStream fs=new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\MyNewAdvancedJavaBatch\\src\\test\\resources\\commondata.properties");
	Properties prop=new Properties();
	prop.load(fs);
	
	String BROWSER = prop.getProperty("browser");
	String URL = prop.getProperty("url");
	String UNAME= prop.getProperty("uname");
	String PWD = prop.getProperty("pwd");
	
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
	LoginPage lp=new LoginPage(driver);
	lp.login(UNAME, PWD);
	
	
	driver.findElement(By.linkText("Products")).click();
	driver.findElement(By.xpath("//span[text()='Add Product']")).click();
	driver.findElement(By.name("productName")).sendKeys("Cadbury12");
	WebElement dropdown1 = driver.findElement(By.name("productCategory"));
	Select select1=new Select(dropdown1);
	select1.selectByValue("Electronics");
	driver.findElement(By.name("quantity")).sendKeys("1");
	driver.findElement(By.name("price")).sendKeys("0.01");
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	
	WebElement dropdown2 = driver.findElement(By.name("vendorId"));
	Select select2=new Select(dropdown2);
	select2.selectByValue("VID_001");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//button[@type='submit']")).click();

	Thread.sleep(2000);
	String ConMsg = driver.findElement(By.xpath("//div[@role='alert']")).getText();
	if(ConMsg.contains("added Successfuly"))
	{
		Reporter.log("Product added Successfuly",true);
	}
	else
	{
		Reporter.log("not added",true);
	}
	//logout
	Thread.sleep(4000);
	DashboardPage lg=new DashboardPage(driver);
	lg.logout();
	Thread.sleep(3000);
	driver.quit();

	
	}
}



