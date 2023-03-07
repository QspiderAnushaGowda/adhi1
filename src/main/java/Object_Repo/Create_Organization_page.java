package Object_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Create_Organization_page {

	//intialization
	public Create_Organization_page (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//img[@alt='Create Organization...']")
	private WebElement OrganizationCreateImage;
	
	@FindBy(xpath="//input[@name='accountname']")
	private WebElement OrganizationTextField;
	
	@FindBy(xpath="(//input[@accesskey='S'])[1]")
	private WebElement SaveButton;
	
	
	//getter methods
	public WebElement getOrganizationCreateImage() {
		return OrganizationCreateImage;
	}

	public WebElement getOrganizationTextField() {
		return OrganizationTextField;
	}

	public WebElement getSaveButton() {
		return SaveButton;
	}

	
	
	//method to click on plus sign
	public void clickOnImage()
	{
		OrganizationCreateImage.click();
	}
	
	//method to enter the data
	public void EnterDataOnText(String orgname)
	{
		OrganizationTextField.sendKeys(orgname);
	}
	
	//method to save 
	public void ClickOnSave()
	{
		SaveButton.click();
	}
	
	
	
	
}
