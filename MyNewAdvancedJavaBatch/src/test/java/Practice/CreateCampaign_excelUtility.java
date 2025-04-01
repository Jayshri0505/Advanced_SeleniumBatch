package Practice;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import Generic_Utility.ExcelFileUtility;
import Generic_Utility.JavaUtility;

public class CreateCampaign_excelUtility {
	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
			FileInputStream fs=new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\MyNewAdvancedJavaBatch\\src\\test\\resources\\commondata.properties");
			Properties prop=new Properties();
			prop.load(fs);
			String BROWSER = prop.getProperty("browser");
			String URL = prop.getProperty("url");
			String UNAME= prop.getProperty("uname");
			String PWD = prop.getProperty("pwd");
			System.out.println(BROWSER);
			System.out.println(URL);
			System.out.println(UNAME);
			System.out.println(PWD);
			System.out.println("==================================");
			JavaUtility jUtil= new JavaUtility();
			int randomNum = jUtil.getRandomNum(2000);
			
			ExcelFileUtility exutil=new ExcelFileUtility();

		String Campaign =exutil.readingDataFromPropertyFile("DDT",1,2)+randomNum;
		 String targetsize = exutil.readingDataFromPropertyFile("DDT",1,3);
		System.out.println(Campaign);
		System.out.println(targetsize);
		java.util.Date dateobj=new java.util.Date();
		SimpleDateFormat sim=new SimpleDateFormat("dd-MM-YYYY");
		String todaysdate = sim.format(dateobj);
		
		
		System.out.println(todaysdate);
				String closedate = jUtil.generateReqDate(30);
		System.out.println(closedate);
		System.out.println("==========================================");

		//String expectedURL="http://49.249.28.218:8098/dashboard";
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
		driver.findElement(By.name("campaignName")).sendKeys(Campaign);
		driver.findElement(By.name("targetSize")).clear();
		driver.findElement(By.name("targetSize")).sendKeys(targetsize);
		driver.findElement(By.name("expectedCloseDate")).sendKeys(closedate);
		driver.findElement(By.name("targetAudience")).sendKeys("IT Sector");
		driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();
		Thread.sleep(2000);
		String ConMsg = driver.findElement(By.xpath("//div[@role='alert']")).getText();
		if(ConMsg.contains(Campaign))
		{
			System.out.println("Campaign added successfuly");
		}
		else
		{
			System.out.println("not added");
		}
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[@class='user-icon']")).click();
		WebElement logoutbtn = driver.findElement(By.xpath("//div[@class='dropdown-item logout']"));
		Actions action=new Actions(driver);
		action.moveToElement(logoutbtn).click().perform();
		driver.quit();
		
	}


}

