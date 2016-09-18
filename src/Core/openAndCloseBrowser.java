package Core;


import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class openAndCloseBrowser {

	public static WebDriver driver;

	public static  String GridUserName="amitozsingh1";
	public static  String GridPassword="SSqa5ZDf69Pt6cBBszXk";

	public  String URL = "https://" + GridUserName + ":" + GridPassword + "@hub-cloud.browserstack.com/wd/hub";

	@Parameters({"browser","testURL","Grid","browser_version"})
	@BeforeTest
	public void OpenBrowser(String browser,String testURL,String Grid,String version) throws Exception
	{
		
		
		
		
		if(Grid.equalsIgnoreCase("true"))

		{
			DesiredCapabilities caps=new DesiredCapabilities();
			caps.setCapability("browser", browser);
			caps.setCapability("browser_version", version);
			caps.setCapability("os", "WINDOWS");
			caps.setCapability("os_version", "XP");
			caps.setCapability("browserstack.debug", "true");
			caps.setCapability("browserstack.video", "true");

			driver=new RemoteWebDriver(new URL(URL), caps);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get(testURL);
		}
		if(Grid.equalsIgnoreCase("false"))
		{


		if(browser.equalsIgnoreCase("Firefox")){
			driver=new FirefoxDriver();

		}
		if(browser.equalsIgnoreCase("chrome")){

			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\lib\\chromedriver.exe");
			driver=new ChromeDriver();

		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(testURL);
		}
	

	}
	@AfterTest
	public void teardown(){
		driver.quit();

	}
	public static WebDriver getInstance() {
		// TODO Auto-generated method stub
		return driver;
	}





}
