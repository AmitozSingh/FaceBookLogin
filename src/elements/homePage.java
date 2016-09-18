package elements;

import org.openqa.selenium.By;

public class homePage {
	
	public By inputBox_UserId=By.cssSelector("#email");
	public By inputBox_Password=By.cssSelector("#pass");
	public By button_LogIn=By.cssSelector("#u_0_l");
	public By link_ForgttenYourPassword=By.xpath("//a[contains(.,'Forgotten account')]");
	

}
