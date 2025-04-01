package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage {
WebDriver driver;
	
	public CampaignPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//span[text()='Create Campaign']")
	private WebElement createCampaignBtn;
	
	@FindBy(xpath="//select[@style='margin-top: 5px;']")
	private WebElement searchByDD;
	
	@FindBy(xpath="//input[@type='text']")
	private WebElement SearchByField;
	
	@FindBy(xpath="//div[@role='alert")
	private WebElement conMsg;

	
	public WebElement getCreateCampaignBtn() {
		return createCampaignBtn;
	}

	public WebElement getSearchByDD() {
		return searchByDD;
	}

	public WebElement getSearchByField() {
		return SearchByField;
	}

	public WebElement getConMsg() {
		return conMsg;
	}
	

	
		
	
	
}
