package Object_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class ValidationAndVerification_Page {

	// intialization
	public ValidationAndVerification_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement OrgActualData;
//	@FindBy (xpath="//span[text()='"+data+"']")
//	private WebElement OrgActualData;

	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement ProActualData;

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement CampActualData;

	@FindBy(name = "Delete")
	private WebElement DeleteButton;

	// getter method
	public WebElement getOrgActualData() {
		return OrgActualData;
	}

	public WebElement getProActualData() {
		return ProActualData;
	}

	public WebElement getCampActualData() {
		return CampActualData;
	}

	public WebElement getDeleteButton() {
		return DeleteButton;
	}
	// business logics

	// to validate organization
	public void organizationValidation(WebDriver driver, String data) {
		// validation
		String actualData = OrgActualData.getText();
		
//		SoftAssert st=new SoftAssert();
//		st.assertEquals(actualData,data);
//		st.assertAll();
		if (actualData.contains(data)) {
			System.out.println("validation pass");
		} else {
			System.out.println("validation fail");
		}

	}

	// to validate Product
	public void productValidation(WebDriver driver, String data) {
		// validation
		String actualData = ProActualData.getText();

		if (actualData.contains(data)) {
			System.out.println("validation pass");
		} else {
			System.out.println("validation fail");
		}

	}

	// to validate campaign
	public void campignValidation(WebDriver driver, String data) {
		// validation
		String actualData = CampActualData.getText();

		if (actualData.contains(data)) {
			System.out.println("validation pass");
		} else {
			System.out.println("validation fail");
		}

	}

	public void DeleteButton() {
		DeleteButton.click();
	}

}
