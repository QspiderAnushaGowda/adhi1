package Product;

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
import org.testng.annotations.Test;

import Generic_utility.BaseClass;
import Generic_utility.Excel_Utility;
import Generic_utility.File_Utility;
import Generic_utility.Java_Utility;
import Generic_utility.WebDriver_utility;
import Object_Repo.Create_Product_page;
import Object_Repo.Home_page;
import Object_Repo.Login_page;
import Object_Repo.ValidationAndVerification_Page;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProduct extends BaseClass {
	// program to add product name ...
	// doing mouseover operation on icon and clicking on signout button
	//public static void main(String[] args) throws EncryptedDocumentException, IOException, Throwable {

		// sets the path for chrome driver
//		String key = "webdriver.chrome.driver";
//		String value = "D:\\Advanced_Selenium_Workspace\\vTiger\\src\\main\\resources\\chromedriver.exe";
//		System.setProperty(key, value);
@Test
public void createProduct() throws Throwable
{
		File_Utility flib = new File_Utility();

//		// launching the browser
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

		Home_page home = new Home_page(driver);
		WebDriver_utility wlib = new WebDriver_utility();
		
		Java_Utility jlib = new Java_Utility();
		Excel_Utility Elib = new Excel_Utility();
		Create_Product_page pro = new Create_Product_page(driver);
		Login_page login = new Login_page(driver);
		ValidationAndVerification_Page valid = new ValidationAndVerification_Page(driver);

//		//fetches the data from excel by FIS and creating work space
//		FileInputStream fis = new FileInputStream("./src/test/resources/OrganizationName.xlsx");
//		Workbook book = WorkbookFactory.create(fis);
//		
//		//from organization sheet get the url
//		String Url = book.getSheet("Organization").getRow(1).getCell(0).getStringCellValue();
//		driver.get(Url);
//		
//		//from organization sheet get the username
//		String Un = book.getSheet("Organization").getRow(1).getCell(1).getStringCellValue();
//		driver.findElement(By.name("user_name")).sendKeys(Un);
//
//		//from organization sheet get the password
//		String Pw = book.getSheet("Organization").getRow(1).getCell(2).getStringCellValue();
//		driver.findElement(By.name("user_password")).sendKeys(Pw);
//		

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

		home.clickProductLink();

		pro.ProclickOnImage();

//		// fetches the username from property file
//		driver.findElement(By.name("user_name")).sendKeys(UN);
//
//		// fetches the password from property file
//		driver.findElement(By.name("user_password")).sendKeys(PW);
//
//		// clicks on the login button
//		driver.findElement(By.id("submitButton")).submit();
//
//		// clicks on the link products
//		driver.findElement(By.partialLinkText("Products")).click();
//
//		// clicks on the plus icon
//		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
//
//		// calling method from java utility class

		int ranNum = jlib.getRandomNum();

		// fetching the data from excel
//
//		FileInputStream fis1 = new FileInputStream("./src/test/resources/OrganizationName.xlsx");
//
//		Workbook book = WorkbookFactory.create(fis1);

		// fetches the product name from product sheet
		// String Pro =
		// book.getSheet("Product").getRow(1).getCell(0).getStringCellValue() + ranNum;

		String ProData = Elib.getExcelData("Product", 1, 0) + ranNum;

		pro.ProEnterDataOnText(ProData);

		pro.ProClickOnSave();

		// enters the data to the product name text box
		// driver.findElement(By.name("productname")).sendKeys(ProData);

		// clicks on the save button
		// driver.findElement(By.xpath("(//input[@accesskey='S'])[1]")).click();

		Thread.sleep(3000);

		// validation
		valid.productValidation(driver, ProData);

		// storing the web element for the mouseover operation
//		WebElement icon = driver.findElement(By.xpath("(//td[@style='padding-bottom: 1em;'])[1]"));

	//	wlib.mouseOverOnElement(driver, icon);

//		// actions object is created for mouseover operation
//		Actions a = new Actions(driver);
//
//		a.moveToElement(icon).perform();

		// clicking on the signout link
		// driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
//		home.ClickOnSignOut();
	}
}
