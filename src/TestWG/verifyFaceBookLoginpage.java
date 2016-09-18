package TestWG;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Core.userActions;

public class verifyFaceBookLoginpage extends userActions {
	
	@Test
	public void verifyFacebookLoginPageDisplay() throws Exception
	{
		 String TitleOfFaceBookPage=driver.getTitle();
		 SoftAssert As=new SoftAssert();
		 As.assertEquals(TitleOfFaceBookPage, "Facebook - Log In or Sign Up");
		 As.assertAll();
		 new DataProvider.ExcelReadWrite().WriteExcel("LoginDetail", "Sheet1", 2, 3, "PASS");
	}

}
