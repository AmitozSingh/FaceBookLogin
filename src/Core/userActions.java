package Core;

import org.openqa.selenium.By;

public class userActions extends openAndCloseBrowser {

	
	public void click(By loc)
	{
		driver.findElement(loc).click();
	}
	
	public void sendkeys(By loc,String value)
	{
		driver.findElement(loc).sendKeys(value);
	}
	
	public void backbutton()
	{
		driver.navigate().back();
		
	}
	
	
}
