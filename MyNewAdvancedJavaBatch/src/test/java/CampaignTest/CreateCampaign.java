package CampaignTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;

import org.testng.Reporter;
import org.testng.annotations.Test;

import Generic_Utility.JavaUtility;
import ObjectRepository.CampaignPage;
import ObjectRepository.DashboardPage;
import genericBaseClassUtility.BaseClass;
//@Listeners(ListenerImp.class)
public class CreateCampaign extends BaseClass{
	
	@Test
	public void createCampaignTest() throws EncryptedDocumentException, IOException, InterruptedException {
			FileInputStream fs=new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\MyNewAdvancedJavaBatch\\src\\test\\resources\\commondata.properties");
			Properties prop=new Properties();
			prop.load(fs);
			JavaUtility jUtil=new JavaUtility();
			jUtil.generateReqDate(30);
			int randomNum= jUtil.getRandomNum(7000);


		FileInputStream fis=new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\MyNewAdvancedJavaBatch\\src\\test\\resources\\Book1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String Campaign = wb.getSheet("DDT").getRow(1).getCell(2).getStringCellValue()+randomNum;
		 String targetsize = wb.getSheet("DDT").getRow(1).getCell(3).getStringCellValue();
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			Thread.sleep(2000);
		DashboardPage dp=new DashboardPage(driver);
		Thread.sleep(2000);
		
		CampaignPage cp=new CampaignPage(driver);
		cp.getCreateCampaignBtn().click();
		
		ObjectRepository.CreateCampaign ccp=new ObjectRepository.CreateCampaign(driver);
		ccp.CreateCampaignWithmandatoryFields(Campaign, targetsize);
		Thread.sleep(4000);
				String ConMsg = driver.findElement(By.xpath("//div[@role='alert']")).getText();
		if(ConMsg.contains(Campaign))
		{
			Reporter.log("Campaign "+Campaign+" added successfuly",true);
		}
		else
		{
			Reporter.log("not added",true);
		}
		Thread.sleep(4000);

		
	}
	@Test()
	public void createCampaignWithDate() throws EncryptedDocumentException, IOException, InterruptedException {
	FileInputStream fs=new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\MyNewAdvancedJavaBatch\\src\\test\\resources\\commondata.properties");
				Properties prop=new Properties();
				prop.load(fs);
					Random ran=new Random();
				int randomNum = ran.nextInt(7000);

FileInputStream fis=new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\MyNewAdvancedJavaBatch\\src\\test\\resources\\Book1.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			String Campaign = wb.getSheet("DDT").getRow(1).getCell(2).getStringCellValue()+randomNum;
			 String targetsize = wb.getSheet("DDT").getRow(1).getCell(3).getStringCellValue();
			
			 JavaUtility jUtil=new JavaUtility();
			String closedate = jUtil.generateReqDate(30);
		
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			Thread.sleep(2000);
		
			CampaignPage cp=new CampaignPage(driver);
			cp.getCreateCampaignBtn().click();
			
			ObjectRepository.CreateCampaign ccp=new ObjectRepository.CreateCampaign(driver);
			
			ccp.CreateCampaignAllFields(Campaign, targetsize, closedate);
			Thread.sleep(4000);
//confirmation msg
			String ConMsg = driver.findElement(By.xpath("//div[@role='alert']")).getText();
			if(ConMsg.contains(Campaign))
			{
				Reporter.log("Campaign"+Campaign+" added successfuly",true);
			}
			else
			{
				Reporter.log(" Campaign "+Campaign+"not added",true);
			}
			Thread.sleep(4000);


			}
	}



