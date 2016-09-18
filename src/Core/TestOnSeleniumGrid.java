package Core;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class TestOnSeleniumGrid {
	
	@Test
	public void testonFF() throws Exception
	
	{
		System.setProperty("webDriver.chrome.driver", System.getProperty("user.dir") + "\\lib\\chromedriver.exe");
		DesiredCapabilities ds=DesiredCapabilities.firefox();
	
		ds.setPlatform(Platform.WINDOWS);
		URL url= new URL("http://localhost:4444/wd/hub");
		
		WebDriver driver= new RemoteWebDriver(url, ds);
		
		driver.get("http://facebook.com");
		System.out.println("Title of the facebook"+driver.getTitle());
		driver.quit();
				
	}

}
