package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utility.WebDriverUtility;

public class CreateContactPage {
	WebDriver driver;
	
	public CreateContactPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(name="organizationName")
	private WebElement orgName;
	@FindBy(name="title")
	private WebElement titleField;
	//@FindBy(name="department")
	//private WebElement department;
	
	//@FindBy(name="off")
	//private WebElement officePhone;
	
	@FindBy(name="contactName")
	private WebElement contName;
	
	@FindBy(name="mobile")
	private WebElement mobFieldl;
	@FindBy(xpath="(//*[name()='svg' and @role='img'])[2]")
	private WebElement selectCampBtn;
	
	@FindBy(id="search-criteria")
	private WebElement searchDD;
	@FindBy(id="search-input")
	private WebElement searchInp;
	@FindBy(xpath="//button[@class='select-btn']")
	private WebElement selectBtn;
	
	@FindBy(xpath="//button[text()='Create Contact']")
	private WebElement createConBtn;

	
	public WebElement getOrgName() {
		return orgName;
	}

	public WebElement getTitleField() {
		return titleField;
	}

	public WebElement getContName() {
		return contName;
	}

	public WebElement getMobFieldl() {
		return mobFieldl;
	}

	public WebElement getSelectCampBtn() {
		return selectCampBtn;
	}

	public WebElement getSearchDD() {
		return searchDD;
	}

	public WebElement getSearchInp() {
		return searchInp;
	}

	public WebElement getSelectBtn() {
		return selectBtn;
	}

	public WebElement getCreateConBtn() {
		return createConBtn;
	}
	public void createContactWithCampaign(String org ,String title, String cont, String mob,String childrl, String parentUrl, String campName)
	{
	orgName.sendKeys(org);
	titleField.sendKeys(title);
	contName.sendKeys(cont);
	mobFieldl.sendKeys(mob);
	selectCampBtn.click();
	WebDriverUtility wUtil=new WebDriverUtility();
	wUtil.switchToWindow(driver, childrl);
	wUtil.select(searchDD, 1);
	searchInp.sendKeys(campName);
	selectBtn.click();
	wUtil.switchToWindow(driver, parentUrl);
	createConBtn.click();
	
	}
}