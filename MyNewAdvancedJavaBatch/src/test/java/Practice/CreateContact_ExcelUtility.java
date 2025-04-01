package Practice;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Random;
import java.util.Set;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Generic_Utility.ExcelFileUtility;
import Generic_Utility.PropertiesFileUtility;

public class CreateContact_ExcelUtility {
	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		PropertiesFileUtility propUtil=new PropertiesFileUtility();	
		String BROWSER = propUtil.readingDataFromPropertyFile("browser");
		String URL = propUtil.readingDataFromPropertyFile("url");
		String UNAME=propUtil.readingDataFromPropertyFile("uname");
		String PWD =propUtil.readingDataFromPropertyFile("pwd");
			
		System.out.println(BROWSER);
			System.out.println(URL);
			System.out.println(UNAME);
			System.out.println(PWD);
			System.out.println("==================================");
			Random ran=new Random();
			int randomNum = ran.nextInt(1000);

			ExcelFileUtility exutil=new ExcelFileUtility();
			
			
		String Campaign = exutil.readingDataFromPropertyFile("DDT", 1, 2)+randomNum;
		 String targetsize =exutil.readingDataFromPropertyFile("DDT", 1, 3);
		 String organisation= exutil.readingDataFromPropertyFile("Contact",1,2)+randomNum;
		 String title= exutil.readingDataFromPropertyFile("Contact",1,3);
		 String contactname= exutil.readingDataFromPropertyFile("Contact",1,4)+randomNum;
		 String mobile= exutil.readingDataFromPropertyFile("Contact",1,5);
		 java.util.Date dateobj=new java.util.Date();
		SimpleDateFormat sim=new SimpleDateFormat("dd-MM-YYYY");
		String todaysdate = sim.format(dateobj);
		System.out.println(todaysdate);
		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, 10);
		String closedate = sim.format(cal.getTime());
		System.out.println(closedate);
		System.out.println("==========================================");

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
		Thread.sleep(4000);
		//String ConMsg = driver.findElement(By.xpath("//div[@role='alert']")).getText();
		WebElement contactlink = driver.findElement(By.linkText("Contacts"));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(contactlink));
		contactlink.click();
		Thread.sleep(5000);
		WebElement CreateContactbtn = driver.findElement(By.xpath("//span[text()='Create Contact']"));
		wait.until(ExpectedConditions.visibilityOf(CreateContactbtn));
		CreateContactbtn.click();
		driver.findElement(By.name("organizationName")).sendKeys(organisation);
		driver.findElement(By.name("title")).sendKeys(title);
		driver.findElement(By.name("contactName")).sendKeys(contactname);
		driver.findElement(By.name("mobile")).sendKeys(mobile);
		driver.findElement(By.xpath("//button[@type='button' and contains(@style,'white-space')]")).click();
		String parentid = driver.getWindowHandle();
		Set<String> allwindows = driver.getWindowHandles();
		for(String windows:allwindows)
		{
			driver.switchTo().window(windows);
		}
		WebElement selectTypeDD = driver.findElement(By.id("Search-Criteria"));
		Select select1=new Select(selectTypeDD);
		select1.selectByValue("campaignName");
		driver.findElement(By.id("Search-input")).sendKeys(Campaign);
		driver.findElement(By.xpath("//button[@class='select-btn']")).click();
		driver.switchTo().window(parentid);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text='Create Contact']")).click();

		Thread.sleep(4000);
		driver.findElement(By.xpath("//[name()='svg' and @role=\"img\"]")).click();

		
		driver.findElement(By.xpath("//div[@class='user-icon']")).click();
		WebElement logoutbtn = driver.findElement(By.xpath("//div[@class='dropdown-item logout']"));
		Actions action=new Actions(driver);
		action.moveToElement(logoutbtn).click().perform();
		driver.quit();
		}
}


