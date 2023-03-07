package organization;

import org.testng.annotations.Test;

import Generic_utility.BaseClass;
import Generic_utility.File_Utility;
import Object_Repo.Login_page;

public class Test_Create_Organization extends  BaseClass{

	@Test
	public void createOrganization() throws Throwable
	{
	File_Utility flib = new File_Utility();
	Login_page login=new Login_page(driver);
	
	driver.manage().window().maximize();
	
	String URL = flib.getKeyAndVAlue("url");

	String UN = flib.getKeyAndVAlue("username");

	String PW = flib.getKeyAndVAlue("password");
	
	driver.get(URL);

	login.loginToApp(UN, PW);

}
}
