package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import Generic_utility.Excel_Utility;
import Generic_utility.File_Utility;
import Generic_utility.Java_Utility;
import Generic_utility.WebDriver_utility;

//program to add organization and then go to contacts add name last name, in contact page add the organization name that has been recently saved
//switching the windows from parent browser to child browser
//from child browser to parent browser
public class createContactwithOrg {
	public static void main(String[] args) throws Throwable {
		// sets the path for chrome driver
		System.setProperty("webdriver.chrome.driver",
				"D:\\Advanced_Selenium_Workspace\\vTiger\\src\\main\\resources\\chromedriver.exe");

		// launches the browser
		WebDriver driver = new ChromeDriver();

		WebDriver_utility wlib = new WebDriver_utility();
		File_Utility flib = new File_Utility();
		Java_Utility jlib = new Java_Utility();
		Excel_Utility Elib = new Excel_Utility();

//		// to fetch the data from excel
//		FileInputStream fis = new FileInputStream("./src/test/resources/OrganizationName.xlsx");
//		Workbook book = WorkbookFactory.create(fis);

		// fetches the url from excel

		String Url = Elib.getExcelData("Organization", 1, 0);

		String Un = Elib.getExcelData("Organization", 1, 1);

		String Pw = Elib.getExcelData("Organization", 1, 2);

		driver.get(Url);

		driver.findElement(By.name("user_name")).sendKeys(Un);

		driver.findElement(By.name("user_password")).sendKeys(Pw);

		// clicks on the login button
		driver.findElement(By.id("submitButton")).submit();

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

	

		// adding organization
		// name///////////////////////////////////////////////////////////////////////////////////////

		// clicks on the organization link
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();

		// clicks on the plus sign
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();

		// to avoid duplicate we use random class
		// calling method from java utility class
		
		int ranNum = jlib.getRandomNum();// 1000 differnt values it will generate
		// we sholud concat with the getStringcellvalue

		String orgname = Elib.getExcelData("Organization", 1, 3) + ranNum;

		// String orgname =book.getSheet("Organization").getRow(1).getCell(3).getStringCellValue() +
		// ranNum;
		// enters the data into Organization name text box
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgname);

		// clicks on the save button
		driver.findElement(By.xpath("(//input[@accesskey='S'])[1]")).click();

		Thread.sleep(1000);

		// adding the
		// contact/////////////////////////////////////////////////////////////////////////////////////

		// clciks on the contacts link
		driver.findElement(By.partialLinkText("Contacts")).click();

		// clicks on the plus sign
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();

		// fetches the data from contact sheet in excel

		String ln = Elib.getExcelData("Contact", 1, 0);

		// String ln =
		// book.getSheet("Contact").getRow(1).getCell(0).getStringCellValue();
		driver.findElement(By.name("lastname")).sendKeys(ln);

		// clicks on the plus sign
		driver.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();

		// swtiching the control to child window//////////////////////////////
		
		wlib.switchToWindow(driver, "Accounts&action");

//		/// switching to the child window using getwindowshandle
//		Set<String> allID = driver.getWindowHandles();// 1,2,3,4 windows
//
//		// iterator from collection class //it is cursor used to fetch the data one by
//		// one
//		Iterator<String> it = allID.iterator();
//
//		// hasnext is a method of iterator interface
//		while (it.hasNext()) {// 1 org
//
//			String wid = it.next();// org
//
//			driver.switchTo().window(wid);// control switched to org
//
//			String title = driver.getTitle();// title is retrive from org page(pop up page)
//
//			if (title.contains("Accounts&action")) {// org page title is
//													// satisfied (true)
//				break;// comes inside the loop and loop will break
//			}
//		}
		// in search bar the orgname name is retrived
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(orgname);

		//// clicks on the search bar tool
		driver.findElement(By.xpath("//input[@name='search']")).click();

		Thread.sleep(1000);

		// dynamic xpath since the product is changing everytime
		driver.findElement(By.xpath("//a[text()='" + orgname + "']")).click();

		// switching back the window
		
		wlib.switchToWindow(driver, "Contacts&action");

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
//			if (title1.contains("Contacts&action")) {
//				break;
//			}
//		}

		// clicks on the save button
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		Thread.sleep(1000);

		// storing the web element for the mouseover operation
		WebElement icon = driver.findElement(By.xpath("(//td[@style='padding-bottom: 1em;'])[1]"));

		wlib.mouseOverOnElement(driver, icon);
//		// actions object is created for mouseover operation
//		Actions a = new Actions(driver);
//
//		a.moveToElement(icon).perform();

		// clicking on the signout link
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}
}
