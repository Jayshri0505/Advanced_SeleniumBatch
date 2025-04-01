package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaign {
WebDriver driver;
	
	public CreateCampaign(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="campaignName")
	private WebElement campaignName;
	 
	@FindBy(name="targetSize")
	 private WebElement targetSize;
	
	@FindBy(name="expectedCloseDate")
	 private WebElement expectedCloseDate;
	
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement createCampignBtn;
	
	
	public WebElement getCampaignName() {
		return campaignName;
	}


	public WebElement getTargetSize() {
		return targetSize;
	}


	public WebElement getExpectedclosingdate() {
		return expectedCloseDate;
	}


	public WebElement getCreateCampignBtn() {
		return createCampignBtn;
	}


		public void CreateCampaignWithmandatoryFields(String campName,String target)
	{
		campaignName.sendKeys(campName);
		targetSize.clear();
		targetSize.sendKeys(target);
		createCampignBtn.click();
	}
		public void CreateCampaignAllFields(String campName,String target,String Date)
		{
			campaignName.sendKeys(campName);
			targetSize.clear();
			targetSize.sendKeys(target);
			expectedCloseDate.sendKeys(Date);
			createCampignBtn.click();
		}
		
	}

