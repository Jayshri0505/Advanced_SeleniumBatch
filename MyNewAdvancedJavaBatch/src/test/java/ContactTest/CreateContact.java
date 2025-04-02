package ContactTest;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Generic_Utility.WebDriverUtility;
import ObjectRepository.CampaignPage;
import ObjectRepository.ContactPage;
import ObjectRepository.CreateCampaign;
import ObjectRepository.CreateContactPage;
import ObjectRepository.DashboardPage;
import genericBaseClassUtility.BaseClass;

public class CreateContact extends BaseClass
    {

	@Test(groups= {"RegressionTest"})
	public void createContactWithCampaignTest() throws EncryptedDocumentException, IOException, InterruptedException {
			
			Random ran=new Random();
			int randomNum = ran.nextInt(7000);

		FileInputStream fis=new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\MyNewAdvancedJavaBatch\\src\\test\\resources\\Book1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String Campaign = wb.getSheet("DDT").getRow(1).getCell(2).getStringCellValue()+randomNum;
		 String targetsize = wb.getSheet("DDT").getRow(1).getCell(3).getStringCellValue();
		 String organisation= wb.getSheet("Contact").getRow(1).getCell(2).getStringCellValue()+randomNum;
		 String title= wb.getSheet("Contact").getRow(1).getCell(3).getStringCellValue();
		 String contactname= wb.getSheet("Contact").getRow(1).getCell(4).getStringCellValue()+randomNum;
		 String mobile= wb.getSheet("Contact").getRow(1).getCell(5).getStringCellValue();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		Thread.sleep(2000);
		DashboardPage dp=new DashboardPage(driver);
		dp.getCampaignLink().click();
		
		CampaignPage cp=new CampaignPage(driver);
		cp.getCreateCampaignBtn().click();
		
		CreateCampaign ccp=new CreateCampaign(driver);
		ccp.CreateCampaignWithmandatoryFields(Campaign, targetsize);
		Thread.sleep(4000);
		
		WebElement contactlink = dp.getContactsLink();
		WebDriverUtility wUtil=new WebDriverUtility();
		wUtil.waitForElementToBeClickable(driver, contactlink, 20);
		contactlink.click();
		Thread.sleep(5000);
		
		ContactPage ccp1=new ContactPage(driver);
		WebElement CreateContactbtn = ccp1.getCreateContactBtn();
		wUtil.waitForElementToBeClickable(driver, CreateContactbtn, 20);
		CreateContactbtn.click();
		CreateContactPage cct=new CreateContactPage(driver);
		cct.createContactWithCampaign(organisation, title, contactname, mobile,"selectCampaign","create-contact", Campaign);
		
		
		Thread.sleep(4000);
	String ConfirmationMsg = ccp1.getConMsg().getText();
	if(ConfirmationMsg.contains(contactname))
	{
		Reporter.log("Contact added successfully ",true);
	}
	else
	{
		Reporter.log("Contact not added",true);
	}
	Thread.sleep(5000);
		
	}
}

 