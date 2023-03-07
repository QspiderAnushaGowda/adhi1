package Product;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
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

//program to add product name, save and delete it ...
//doing mouseover operation on icon and clicking on signout button
public class DeleteProduct extends BaseClass{
//	public static void main(String[] args) throws Throwable, Throwable {

	
	@Test
	public void deleteProduct() throws Throwable {
		// sets the path for chrome driver
		// launching the browser
		File_Utility flib = new File_Utility();
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

//		String key = "webdriver.chrome.driver";
//		String value = "D:\\Advanced_Selenium_Workspace\\vTiger\\src\\main\\resources\\chromedriver.exe";
//		System.setProperty(key, value);

		// launches the browser
		// WebDriver driver = new ChromeDriver();

		WebDriver_utility wlib = new WebDriver_utility();

		Java_Utility jlib = new Java_Utility();
		Excel_Utility Elib = new Excel_Utility();
		Login_page login = new Login_page(driver);
		Create_Product_page pro = new Create_Product_page(driver);
		Home_page home = new Home_page(driver);
		ValidationAndVerification_Page valid = new ValidationAndVerification_Page(driver);

		wlib.maximizeScreen(driver);

		wlib.waitForPageToLoad(driver); 
//		// fetches the data from excel by FIS and creating work space
//		FileInputStream fis = new FileInputStream("./src/test/resources/OrganizationName.xlsx");
//		Workbook book = WorkbookFactory.create(fis);
//
//		// from organization sheet get the url
//		String Url = book.getSheet("Organization").getRow(1).getCell(0).getStringCellValue();
//		driver.get(Url);
//
//		// from organization sheet get the username
//		String Un = book.getSheet("Organization").getRow(1).getCell(1).getStringCellValue();
//		driver.findElement(By.name("user_name")).sendKeys(Un);
//
//		// from organization sheet get the password
//		String Pw = book.getSheet("Organization").getRow(1).getCell(2).getStringCellValue();
//		driver.findElement(By.name("user_password")).sendKeys(Pw);
//
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

//		// fetches the username from property file
//		driver.findElement(By.name("user_name")).sendKeys(UN);
//
//		// fetches the password from property file
//		driver.findElement(By.name("user_password")).sendKeys(PW);
//
//		// clicks on the login button
//		driver.findElement(By.id("submitButton")).submit();

		// clicks on the link products
		// driver.findElement(By.partialLinkText("Products")).click();
		home.clickProductLink();

		// clicks on the plus icon
		// driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		pro.ProclickOnImage();

		// to avoid duplicate we use random class
		// calling method from java utility class

		int ranNum = jlib.getRandomNum();// 1000 differnt values it will generate
		// we sholud concat with the getStringcellvalue

		// fetching the data from excel

		String ProData = Elib.getExcelData("Product", 1, 0) + ranNum;

		// fetches the product name from product sheet
		// String ProData
		// =book.getSheet("Product").getRow(1).getCell(0).getStringCellValue() + ranNum;

		// enters the data to the product name text box
		// driver.findElement(By.name("productname")).sendKeys(Pro);

		// clicks on the save button
		// driver.findElement(By.xpath("(//input[@accesskey='S'])[1]")).click();

		pro.ProEnterDataOnText(ProData);

		pro.ProClickOnSave();
		
		valid.productValidation(driver, ProData);

		valid.DeleteButton();
		// clicks on the delete button
		// driver.findElement(By.name("Delete")).click();

//		// handling alert pop up
//		Alert alt = driver.switchTo().alert();
//
//		alt.accept();
		wlib.switchToAlertAndAccept(driver);

		// storing the web element for the mouseover operation
	//	WebElement icon = driver.findElement(By.xpath("(//td[@style='padding-bottom: 1em;'])[1]"));

		//wlib.mouseOverOnElement(driver, icon);
//		// actions object is created for mouseover operation
//		Actions a = new Actions(driver);
//
//		a.moveToElement(icon).perform();

		// clicking on the signout link
		// driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		//home.ClickOnSignOut();
	}
}
