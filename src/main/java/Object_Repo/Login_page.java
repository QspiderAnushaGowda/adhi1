package Object_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_utility.WebDriver_utility;

public class Login_page {

	//intialization
	public Login_page(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);//this--when object of login page is created it has the address of the pom class//and tells driver to  go to the that pom class
	}
	
	//decalration
	
	@FindBy(name="user_name")
	private WebElement usertextfield;
	
	@FindBy(name="user_password")
	private WebElement passwordtextfield;

	@FindBy(id="submitButton")
	private WebElement loginbutton;

	
	//getter methods
	public WebElement getUsertextfield() {
		return usertextfield;
	}

	public WebElement getPasswordtextfield() {
		return passwordtextfield;
	}

	public WebElement getLoginbutton() {
		return loginbutton;
	}
	
	//Business Logics
	
	public void loginToApp(String username,String password)
	{
		usertextfield.sendKeys(username);
		passwordtextfield.sendKeys(password);
		loginbutton.click();
	}

	

	
}
