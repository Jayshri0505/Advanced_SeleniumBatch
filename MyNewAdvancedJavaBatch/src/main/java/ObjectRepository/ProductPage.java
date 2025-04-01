package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {WebDriver driver;

public ProductPage(WebDriver driver) {
	super();
	this.driver = driver;
	PageFactory.initElements(driver,this);
}
	@FindBy(xpath="//select[@style='margin-top: 5px;']")
	private WebElement searchByProductId;
	
	@FindBy(xpath="//input[@type='text']")
	private WebElement searchById;
	
	@FindBy(xpath="//span[text()='Create Product']")
	private WebElement createProductBtn;
	
	@FindBy(xpath="//div[@role='alert")
	private WebElement conMsg;




	

}
