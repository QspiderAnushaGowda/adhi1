package Object_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Create_Campign_page {

	//intialization
			public Create_Campign_page(WebDriver driver)
			{
				PageFactory.initElements(driver, this);
			}
			//plus sign on camp
			@FindBy (xpath="//img[@alt='Create Campaign...']")
			private WebElement CampignCreateImage;
			
			//Enters data on camp
			@FindBy(name="campaignname")
			private WebElement CampaignTextField;
			
			// product plus sign
			@FindBy(xpath="//img[@alt='Select']")
			private WebElement ProductSelectionImage;
			
			//enters data on product field in camp page
			@FindBy(xpath="//input[@type='text']")
			private WebElement ProductTextField;
			
			//clicks on search button in child window
			@FindBy(xpath="//input[@name='search']")
			private WebElement SearchProductButton;
			
			//save button
			@FindBy(xpath="(//input[@accesskey='S'])[1]")
			private WebElement SaveButton;
			
			
			
			
/////////			//getter method///////////////////////////////
			
			public WebElement getProductSelectionImage() {
				return ProductSelectionImage;
			}

			
			public WebElement getProductTextField() {
				return ProductTextField;
			}

		
			public WebElement getSearchProductButton() {
				return SearchProductButton;
			}

			
			public WebElement getCampignCreateImage() {
				return CampignCreateImage;
			}

			public WebElement getCampaignTextField() {
				return CampaignTextField;
			}

			public WebElement getSaveButton() {
				return SaveButton;
			}
			

			//business logics
			
			//clicks on plus sign for new camp
			public void CampclickOnImage()
			{
				CampignCreateImage.click();
			}
			
			
			//enters the data on CAMP
			public void CampEnterDataOnText(String CampName)
			{
				CampaignTextField.sendKeys(CampName);
			}
			
			//clicks on save 
			public void CampClickOnSave()
			{
				SaveButton.click();
			}
			
			//clicks on product plus sign in camp page
			public void ClickOnProductPlusImage()
			{
				ProductSelectionImage.click();	
			}
			
			//Enter the data on product page(child window)
			public void ProEnterDataOnText(String ProductName)
			{
				ProductTextField.sendKeys(ProductName);
			}
			
			//clicks on the search button of child window
			public void SearchProductButton(WebDriver driver, String ProductName)
			{
				SearchProductButton.click();
				driver.findElement(By.xpath("//a[text()='" + ProductName + "']")).click();
				
			}
			
}
