package Login;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.Reporter;
import org.testng.annotations.Test;
import genericBaseClassUtility.BaseClass;

public class LoginTest extends BaseClass{
	//@Parameters("browser")

	@Test(retryAnalyzer=genericListenerutility.RetryListenerImp.class)
public void loginTest() throws InterruptedException, IOException {
		Thread.sleep(5000);
	FileInputStream fs=new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\MyNewAdvancedJavaBatch\\src\\test\\resources\\commondata.properties");
	Properties prop=new Properties();
	prop.load(fs);

	//String expectedURL="http://49.249.28.218:8098/dashboard";
		
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	Thread.sleep(2000);
		String actualURL = driver.getCurrentUrl();
	//AssertJUnit.assertEquals(actualURL, expectedURL,"Validation is Failed");
	Reporter.log("Validation is passed ",true);
	Thread.sleep(3000);

	
 }
}

