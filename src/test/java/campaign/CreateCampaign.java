package campaign;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_utility.BaseClass;
import Generic_utility.Excel_Utility;
import Generic_utility.File_Utility;
import Generic_utility.Java_Utility;
import Generic_utility.WebDriver_utility;
import Object_Repo.Create_Campign_page;
import Object_Repo.Create_Organization_page;
import Object_Repo.Home_page;
import Object_Repo.Login_page;
import Object_Repo.ValidationAndVerification_Page;
import io.github.bonigarcia.wdm.WebDriverManager;
//@Listeners(Generic_utility.ListenersClass.class)
public class CreateCampaign extends BaseClass {

	// program to add campaign name ...
	// doing mouseover operation on icon and clicking on signout button
	//public static void main(String[] args) throws Throwable, Throwable {

	@Test(retryAnalyzer=Generic_utility.RetryFeb.class)
	public void createCampaign() throws Throwable
	{
//		// sets the path for chrome driver
//		System.setProperty("webdriver.chrome.driver",
//				"D:\\Advanced_Selenium_Workspace\\vTiger\\src\\main\\resources\\chromedriver.exe");
//
//		// launches the browser
//		WebDriver driver = new ChromeDriver();
		
		File_Utility flib = new File_Utility();

		// launching the browser
//		String Browser = flib.getKeyAndVAlue("browser");
//
//		WebDriver driver;
//
//		if (Browser.equalsIgnoreCase("chrome")) {
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
//		}
//
//		else if (Browser.equalsIgnoreCase("edge")) {
//			WebDriverManager.edgedriver().setup();
//			driver = new EdgeDriver();
//		}
//
//		else if (Browser.equalsIgnoreCase("firefox")) {
//			WebDriverManager.firefoxdriver().setup();
//			driver = new FirefoxDriver();
//		}
//
//		else {
//			driver = new ChromeDriver();
//		}

		WebDriver_utility wlib = new WebDriver_utility();
		
		Java_Utility jlib = new Java_Utility();
		Excel_Utility Elib = new Excel_Utility();
		Login_page login = new Login_page(driver);
		Create_Campign_page cam = new Create_Campign_page(driver);
		Home_page home = new Home_page(driver);
		ValidationAndVerification_Page valid = new ValidationAndVerification_Page(driver);

//		// to fetch the data from excel
//		FileInputStream fis = new FileInputStream("./src/test/resources/OrganizationName.xlsx");
//		Workbook book = WorkbookFactory.create(fis);
//
//		// fetches the url from excel
//		String Url = book.getSheet("Organization").getRow(1).getCell(0).getStringCellValue();
//		driver.get(Url);
//
//		// fetches the username from excel
//		String Un = book.getSheet("Organization").getRow(1).getCell(1).getStringCellValue();
//		driver.findElement(By.name("user_name")).sendKeys(Un);
//
//		// fetches the password from excel
//		String Pw = book.getSheet("Organization").getRow(1).getCell(2).getStringCellValue();
//		driver.findElement(By.name("user_password")).sendKeys(Pw);

		wlib.maximizeScreen(driver);

		wlib.waitForPageToLoad(driver);

//		String URL = flib.getKeyAndVAlue("url");
//
//		String UN = flib.getKeyAndVAlue("username");
//
//		String PW = flib.getKeyAndVAlue("password");
//
//		// fetches the URL from property file
//		driver.get(URL);
//
//		login.loginToApp(UN, PW);

		home.clickMoreLink();

		home.clickCampaignLink();

		cam.CampclickOnImage();

//		// fetches the username from property file
//		driver.findElement(By.name("user_name")).sendKeys(UN);
//
//		// fetches the password from property file
//		driver.findElement(By.name("user_password")).sendKeys(PW);
//
//		// clicks on the login button
//		driver.findElement(By.id("submitButton")).submit();
//
//		// clicks on the more link
//		driver.findElement(By.xpath("(//a[@href='javascript:;'])[1]")).click();
//
//		// clicks on the campaigns link
//		driver.findElement(By.name("Campaigns")).click();
//
//		// clicks on the plus sign
//		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();

		// calling method from java utility class

		int ranNum = jlib.getRandomNum();

		// fetching the data from excel
		// fetches the data from excel for campaign name and stores in a variable
		// String Camp
		// =book.getSheet("Campaign").getRow(1).getCell(0).getStringCellValue();

		String Camp = Elib.getExcelData("Campaign", 1, 0) + ranNum;

		cam.CampEnterDataOnText(Camp);
		
		Assert.assertEquals("A", "B");

		cam.CampClickOnSave();

//		// enters the data to campaign name text box
//		driver.findElement(By.name("campaignname")).sendKeys(Camp);
//
//		// clicks on the save button
//		driver.findElement(By.xpath("(//input[@accesskey='S'])[1]")).click();

		Thread.sleep(2000);

		valid.campignValidation(driver, Camp);

		// storing the web element for the mouseover operation
	//	WebElement icon = driver.findElement(By.xpath("(//td[@style='padding-bottom: 1em;'])[1]"));

	//	wlib.mouseOverOnElement(driver, icon);
		// actions object is created for mouseover operation
//		Actions a = new Actions(driver);
//
//		a.moveToElement(icon).perform();

		// clicking on the signout link
		// driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

	//	home.ClickOnSignOut();
	}
}
