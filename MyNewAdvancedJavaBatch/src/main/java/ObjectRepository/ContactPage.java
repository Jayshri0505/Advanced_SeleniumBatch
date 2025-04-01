package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
		WebDriver driver;
			
			public ContactPage(WebDriver driver) {
				super();
				this.driver = driver;
				PageFactory.initElements(driver,this);
			}
			@FindBy(xpath="//select[@style='margin-top: 5px;']")
			private WebElement searchById;
			@FindBy(xpath="//input[@type='text']")
			private WebElement searchById1;
			@FindBy(xpath="//span[text()='Create Contact']")
			private WebElement createContactBtn;
			
			@FindBy(xpath="//div[@role='alert']")
			private WebElement conMsg;

			public WebDriver getDriver() {
				return driver;
			}

			public WebElement getSearchById() {
				return searchById;
			}

			public WebElement getSearchById1() {
				return searchById1;
			}

			public WebElement getCreateContactBtn() {
				return createContactBtn;
			}

			public WebElement getConMsg() {
				return conMsg;
			}


}
