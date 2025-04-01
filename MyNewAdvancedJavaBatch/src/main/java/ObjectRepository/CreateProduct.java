package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProduct {
		WebDriver driver;
		
		public CreateProduct(WebDriver driver) {
			super();
			this.driver = driver;
			PageFactory.initElements(driver,this);
		}
		@FindBy(name="productId")
		private WebElement productId;
		
		@FindBy(name="productName")
		private WebElement productName;
		
		@FindBy(name="productCategory")
		private WebElement productCategory;
		
		@FindBy(name="quantity")
		private WebElement quantity;
		
		@FindBy(name="price")
		private WebElement pricePerUnit;
		
		@FindBy(name="vendorId")
		private WebElement vendorId;
		
		@FindBy(name="//button[text()='Add']")
		private WebElement createProductlink;
		
		
		


}
