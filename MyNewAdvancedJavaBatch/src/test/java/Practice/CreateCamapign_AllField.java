package Practice;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateCamapign_AllField {
public static void main(String[] args) throws InterruptedException, IOException {
	FileInputStream fs=new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\MyNewAdvancedJavaBatch\\src\\test\\resources\\commondata.properties");
	Properties prop=new Properties();
	prop.load(fs);
	String BROWSER = prop.getProperty("browser");
	String URL = prop.getProperty("url");
	String UNAME= prop.getProperty("uname");
	String PWD = prop.getProperty("pwd");
	
	java.util.Date dateobj=new java.util.Date();
	SimpleDateFormat sim=new SimpleDateFormat("dd-MM-YYYY");
	String todaysdate = sim.format(dateobj);
	System.out.println(todaysdate);
	Calendar cal = sim.getCalendar();
	cal.add(Calendar.DAY_OF_MONTH, 10);
	String closedate = sim.format(cal.getTime());
	System.out.println(closedate);

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
		driver.findElement(By.linkText("Campaigns")).click();
		driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
		driver.findElement(By.name("campaignName")).sendKeys("banner11112");
		driver.findElement(By.name("targetSize")).clear();
		driver.findElement(By.name("targetSize")).sendKeys("100");
		driver.findElement(By.name("expectedCloseDate")).sendKeys("05/02/24");
		driver.findElement(By.name("targetAudience")).sendKeys("IT Sector");
		
		driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();
		Thread.sleep(2000);
		String ConMsg = driver.findElement(By.xpath("//div[@role='alert']")).getText();
		if(ConMsg.contains("banner11112"))
		{
			System.out.println("Campaign successfuly");
		}
		else
		{
			System.out.println("not added");
		}
		Thread.sleep(4000);
		//Logout
		driver.findElement(By.xpath("//div[@class='user-icon']")).click();
		WebElement logoutBtn = driver.findElement(By.xpath("//div[text()='Logout ']"));
		Actions action =new Actions(driver);
		action.moveToElement(logoutBtn).click().perform();

		Thread.sleep(3000);
		driver.quit();
		
	}
	}


