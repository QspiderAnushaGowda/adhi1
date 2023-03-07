package Object_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_utility.WebDriver_utility;
//programs for links org,product, campign,more,signout//home page
public class Home_page {

	public Home_page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//a[text()='Organizations'])[1]")
	private WebElement organizationLinkText;

	@FindBy(partialLinkText = "Products")
	private WebElement productLinkText;

	@FindBy(name = "Campaigns")
	private WebElement campaignLinkText;

	@FindBy(xpath = "(//a[@href='javascript:;'])[1]")
	private WebElement moreLinkText;

	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement signOutLinkText;

	// getter methods
	public WebElement getOrganizationLinkText() {
		return organizationLinkText;
	}

	public WebElement getProductLinkText() {
		return productLinkText;
	}

	public WebElement getCampaignLinkText() {
		return campaignLinkText;
	}

	public WebElement getMoreLinkText() {
		return moreLinkText;
	}

	public WebElement getSignOutLinkText() {
		return signOutLinkText;
	}

	// business logic for organization

	public void clickOrganizationLink() {
		organizationLinkText.click();
	}

	// business logic for product

	public void clickProductLink() {
		productLinkText.click();
	}

	// business logic for campaign

	public void clickCampaignLink() {
		campaignLinkText.click();
	}
	
	public void clickMoreLink() {
		moreLinkText.click();
	}

	// business logic for more link

	public void moreLink(WebDriver driver) {

		WebDriver_utility wlib = new WebDriver_utility();
		
		wlib.mouseOverOnElement(driver, moreLinkText);

	}
	
	//business logic for signout link
	public void ClickOnSignOut() {
		signOutLinkText.click();
	}
}
