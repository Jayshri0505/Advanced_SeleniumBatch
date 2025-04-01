package Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Headlesstest {
	private static final String BROWSER = null;

	public static void main(String[] args) {
		WebDriver driver=null;
		ChromeOptions Coption=new ChromeOptions();
		FirefoxOptions Foption=new FirefoxOptions(); 
		EdgeOptions Eoption=new EdgeOptions();
		Coption.addArguments("--headless"); 
		Foption.addArguments("--headless");
		Eoption.addArguments("--headless"); 
		if(BROWSER.equalsIgnoreCase("chrome")) 
		{ driver=new ChromeDriver(Coption);
		} else
			if(BROWSER.equalsIgnoreCase("firefox"))
			{ driver=new FirefoxDriver(Foption); }
			
			else if(BROWSER.equalsIgnoreCase("edge"))
			{ driver=new EdgeDriver(Eoption); } 
			else { driver=new ChromeDriver(Coption); } 

	}

}
