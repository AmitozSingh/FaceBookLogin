package screenshot;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

import Core.openAndCloseBrowser;



public class ScreenshotOnFailure extends TestListenerAdapter {
    private static final String ESCAPE_PROPERTY = "org.uncommons.reportng.escape-output";

      @Override
      public void onTestFailure(ITestResult tr) {
          try {
          String location=  screenshot(tr);
          new DataProvider.ExcelReadWrite().ExcelHandler("Fail");
           
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        
        
      }
      
      @Override
      public void onTestSkipped(ITestResult tr) {
    	  
    	   }
     
      @Override
      public void onTestSuccess(ITestResult tr) {
    	  
    	 try {
			/*new DataProvider.ExcelReadWrite().WriteExcel("LoginDetail", "Sheet1", 2, 3, "PASS");*/
    		 new DataProvider.ExcelReadWrite().ExcelHandler("Pass");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      }
      public String screenshot(ITestResult tr) throws IOException{
          System.setProperty(ESCAPE_PROPERTY, "false");

          String location;
         WebDriver driver=openAndCloseBrowser.getInstance();
          /*WebDriver driver=LoginPageTest.getDriver();*/
                  // Get the dir path
            File directory = new File(System.getProperty("user.dir")+"\\test-output");
            // get current date time with Date() to create unique file name
            DateFormat dateFormat = new SimpleDateFormat(
                    "dd_MMM_yyyy__hh_mm_ssaa");
            // get current date time with Date()
            Date date = new Date();
            location = directory.getCanonicalPath() + "\\ScreenShots\\"+tr.getMethod().getMethodName()+ dateFormat.format(date)
                + ".png";
            
            File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src, new File(location));
            Reporter.log("<h4>Repro steps--</h4><br>"+tr.getMethod().getDescription());
            Reporter.log("<br><a href="+location+">screenshot</a>");
          
          return location;
          
          
      }
}