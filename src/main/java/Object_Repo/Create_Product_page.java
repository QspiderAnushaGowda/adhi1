package Object_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Create_Product_page {
	
	//intialization
		public Create_Product_page  (WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}

		@FindBy (xpath="//img[@title='Create Product...']")
		private WebElement ProductCreateImage;
		
		@FindBy(xpath="//input[@name='productname']")
		private WebElement ProductTextField;
		
		@FindBy(xpath="(//input[@accesskey='S'])[1]")
		private WebElement SaveButton;

		//getter methods
		public WebElement getProductCreateImage() {
			return ProductCreateImage;
		}

		public WebElement getProductTextField() {
			return ProductTextField;
		}

		public WebElement getSaveButton() {
			return SaveButton;
		}
		
		//business logics
		//method to click on plus sign
		public void ProclickOnImage()
		{
			ProductCreateImage.click();
		}
		
		//method to enter the data
		public void ProEnterDataOnText(String ProductName)
		{
			ProductTextField.sendKeys(ProductName);
		}
		
		//method to save 
		public void ProClickOnSave()
		{
			SaveButton.click();
		}
}
