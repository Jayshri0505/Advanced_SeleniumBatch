package Generic_Utility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	public void waitForElementToBeClicked(WebDriver driver,WebElement element,long sec)
	{
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void waitForElementToBeClickable(WebDriver driver, WebElement element, long sec)
		{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.elementToBeClickable(element));

		}
	public void switchToWindow(WebDriver driver, String partialUrl)
	{
		Set<String> allwindoIds = driver.getWindowHandles();
		{
			for(String Window:allwindoIds)
			{
				driver.switchTo().window(Window);
				String actUrl = driver.getCurrentUrl();
				if(actUrl.contains(partialUrl))
				{
					break;
				}
			}
		}
	}
		public void switchToframe(WebDriver driver, String index)
		{
			driver.switchTo().frame(index);
		}
		public void switchToFrame(WebDriver driver, String nameId)
		{
			driver.switchTo().frame(nameId);
		}
		public void switchToFrame(WebDriver driver,WebElement element)
		{
			driver.switchTo().frame(element);
		}
		public void select(WebElement element,String value)
		{
			Select sel=new Select(element);
			sel.selectByValue(value);
		}
		public void select(WebElement element,int Index)
		{
			Select sel=new Select(element);
			sel.selectByIndex(Index);
		}
		
		public void select(String visibleText,WebElement element)
		{
			Select sel=new Select(element);
			sel.selectByVisibleText(visibleText);
		}
		public void actionMoveToElement(WebDriver driver,WebElement element)
		{
			Actions action =new Actions(driver);
			action.moveToElement(element).perform();
		}
		public void actionDoubleClick(WebDriver driver,WebElement element)
		{
			Actions action =new Actions(driver);
			action.doubleClick(element).perform();
		}
		public void actionRight(WebDriver driver,WebElement element)
		{
			Actions action =new Actions(driver);
			action.contextClick(element).perform();
		}
		public void takingScreenshot( WebDriver driver,String fileName) throws IOException
		{
			TakesScreenshot ts=( TakesScreenshot)driver;
			File temp = ts.getScreenshotAs(OutputType.FILE);
			File dest=new File("./screenshots/"+fileName+".png");
			FileHandler.copy(temp, dest);
				}
		
		
}
	

