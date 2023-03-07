package campaign;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import javax.swing.border.TitledBorder;

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
import Object_Repo.Create_Campign_page;
import Object_Repo.Create_Product_page;
import Object_Repo.Home_page;
import Object_Repo.Login_page;
import io.github.bonigarcia.wdm.WebDriverManager;

//program to add product and then go to campaign add name camapign, in campaign page add the product that has been recently saved
//switching the windows from parent browser to child browser
//from child browser to parent browser
public class CraeteCampignWithProduct extends BaseClass{
	// public static void main(String[] args) throws Throwable {

//		//sets the path for chrome driver
//		System.setProperty("webdriver.chrome.driver",
//				"D:\\Advanced_Selenium_Workspace\\vTiger\\src\\main\\resources\\chromedriver.exe");
//
//		// launches the browser
//		WebDriver driver = new ChromeDriver();
	@Test
	public void createCampaignWithPro() throws Throwable
	{
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
		Excel_Utility Elib = new Excel_Utility();
		Java_Utility jlib = new Java_Utility();
		Home_page home = new Home_page(driver);
		Create_Campign_page cam = new Create_Campign_page(driver);
		Create_Product_page pro = new Create_Product_page(driver);
		Login_page login = new Login_page(driver);

		// implict wait
		wlib.waitForPageToLoad(driver);

		// maximize the window
		wlib.maximizeScreen(driver);

		// to fetch the data from excel
//
//		String Url = Elib.getExcelData("Organization", 1, 0);
//		String Un = Elib.getExcelData("Organization", 1, 1);
//		String Pw = Elib.getExcelData("Organization", 1, 2);
//
//		driver.get(Url);
//
//		login.loginToApp(Un, Pw);
//
////		driver.findElement(By.name("user_name")).sendKeys(Un);
////		driver.findElement(By.name("user_password")).sendKeys(Pw);
////		// clicks on the login button
////		driver.findElement(By.id("submitButton")).submit();

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

		// adding
		// products/////////////////////////////////////////////////////////////////////////////////////////

		// clicks on the link products
		// driver.findElement(By.partialLinkText("Products")).click();

		home.clickProductLink();

		pro.ProclickOnImage();

		// clicks on the plus icon
		// driver.findElement(By.xpath("//img[@title='Create Product...']")).click();

		// to avoid duplicate we use random class
		// calling method from java utility class

		int ranNum = jlib.getRandomNum();// 1000 differnt values it will generate
		// we sholud concat with the getStringcellvalue

		// fetches the product name from product sheet
		// String Pro =
		// book.getSheet("Product").getRow(1).getCell(0).getStringCellValue() + ranNum;

		String ProData = Elib.getExcelData("Product", 1, 0) + ranNum;

		pro.ProEnterDataOnText(ProData);
		// enters the data to the product name text box
		// driver.findElement(By.name("productname")).sendKeys(Pro);

		// clicks on the save button
		// driver.findElement(By.xpath("(//input[@accesskey='S'])[1]")).click();
		pro.ProClickOnSave();
		// adding create
		// campaing/////////////////////////////////////////////////////////////////////////

		// clicks on the more link
		// driver.findElement(By.xpath("(//a[@href='javascript:;'])[1]")).click();
		home.clickMoreLink();

		// clicks on the campaigns link
		// driver.findElement(By.name("Campaigns")).click();
		home.clickCampaignLink();

		// clicks on the plus sign
		// driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		cam.CampclickOnImage();

		// fetches the data from excel for campaign name and stores in a variable
		// String Camp =
		// book.getSheet("Campaign").getRow(1).getCell(0).getStringCellValue() + ranNum;

		String CampData = Elib.getExcelData("Campaign", 1, 0) + ranNum;

		// enters the data to campaign name text box
		// driver.findElement(By.name("campaignname")).sendKeys(Camp);

		cam.CampEnterDataOnText(CampData);

		// clicks on the pluse sign next to product
		// driver.findElement(By.xpath("//img[@alt='Select']")).click();

		cam.ClickOnProductPlusImage();
		// switching the window////////////////////////////////////
		wlib.switchToWindow(driver, "Products&action");

//		// switching the window////////////////////////////////////
//		// switching to the child window using getwindowshandle
//		Set<String> allID = driver.getWindowHandles();// 1,2,3,4 windows
//
//		// iterator from collection class //it is cursor used to fetch the data one by
//		// one
//		Iterator<String> it = allID.iterator();
//
//		// hasnext is a method of iterator interface
//		while (it.hasNext()) {// 1 org 2pro
//
//			String wid = it.next();// org //pro
//
//			driver.switchTo().window(wid);// control switched to org //control switched to pro
//
//			String title = driver.getTitle();// title is retrive from org page// //title is retrive from pro page(pop up
//												// page)
//
//			if (title.contains("Products&action")) {// org page title is not satisfied (false) ////pro page title is
//													// satisfied (true)
//				break;// comes inside the loop and loop will break
//			}
//		}

		// in search bar the product name is retrived
		// driver.findElement(By.xpath("//input[@type='text']")).sendKeys(Pro);

		cam.ProEnterDataOnText(ProData);

		// clicks on the search bar tool
		// driver.findElement(By.xpath("//input[@name='search']")).click();
		cam.SearchProductButton(driver, ProData);

		Thread.sleep(1000);

		// dynamic xpath since the product is changing everytime

		// driver.findElement(By.xpath("//a[text()='" + Pro + "']")).click();

		// switching back the
		// window//////////////////////////////////////////////////////////////////////
		wlib.switchToWindow(driver, "Campaigns&action");

//		Set<String> allID1 = driver.getWindowHandles();
//
//		Iterator<String> it1 = allID1.iterator();
//
//		while (it1.hasNext()) {
//			String wid1 = it1.next();
//
//			driver.switchTo().window(wid1);
//
//			String title1 = driver.getTitle();
//
//			if (title1.contains("Campaigns&action")) {
//				break;
//			}
//		}

		// clicks on the save button
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		Thread.sleep(1000);

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
