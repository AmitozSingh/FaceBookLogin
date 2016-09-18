package TestWG;

import org.testng.annotations.Test;

import Core.userActions;


public class verifyLoginFunctionality extends userActions {
	
	
	@Test
	public void LoginIntoThePage() throws Exception
	
	{
		 String Username=new DataProvider.ExcelReadWrite().ReadExcel("LoginDetail", "Sheet1", 2, 1);
		 String Password=new DataProvider.ExcelReadWrite().ReadExcel("LoginDetail", "Sheet1", 2, 2);
		sendkeys( new elements.homePage().inputBox_UserId, Username);
		sendkeys( new elements.homePage().inputBox_Password, Password);
		click(new elements.homePage().button_LogIn);
		driver.navigate().back();
	}


}
