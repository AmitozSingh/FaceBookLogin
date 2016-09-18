package TestWG;


import org.testng.annotations.Test;

import Core.userActions;

public class verifyForotPassword extends userActions {
	

	@Test
	public void LoginForgotPassword() throws Exception
	
	{
		 String Username=new DataProvider.ExcelReadWrite().ReadExcel("LoginDetail", "Sheet1", 3, 1);
		click(new elements.homePage().link_ForgttenYourPassword);
		sendkeys(new elements.ForgttenYourPasswordPage().input_EmailAddress, Username);
		click(new elements.ForgttenYourPasswordPage().button_search);
		assert false;
		
	}

}
