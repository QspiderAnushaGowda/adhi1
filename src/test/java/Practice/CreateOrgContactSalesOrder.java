package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Generic_utility.Excel_Utility;
import Generic_utility.File_Utility;
import Generic_utility.Java_Utility;
import Generic_utility.WebDriver_utility;

public class CreateOrgContactSalesOrder {

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
		String URL = flib.getKeyAndVAlue("url");

		String UN = flib.getKeyAndVAlue("username");

		String PW = flib.getKeyAndVAlue("password");

		// fetches the URL from property file
		driver.get(URL);

		// fetches the username from property file
		driver.findElement(By.name("user_name")).sendKeys(UN);

		// fetches the password from property file
		driver.findElement(By.name("user_password")).sendKeys(PW);

		// clicks on the login button
		driver.findElement(By.id("submitButton")).submit();

		// clicks on the organization link
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();

		// clicks on the plus sign
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();

		int ranNum = jlib.getRandomNum();
		
		String orgname=Elib.getExcelData("Organization", 1, 3)+ranNum;
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgname);

		// clicks on the save button
		driver.findElement(By.xpath("(//input[@accesskey='S'])[1]")).click();

		Thread.sleep(3000);

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
				
				// in search bar the orgname name is retrived
				driver.findElement(By.xpath("//input[@type='text']")).sendKeys(orgname);

				//// clicks on the search bar tool
				driver.findElement(By.xpath("//input[@name='search']")).click();

				Thread.sleep(1000);

				// dynamic xpath since the product is changing everytime
				driver.findElement(By.xpath("//a[text()='" + orgname + "']")).click();

				// switching back the window
				
				wlib.switchToWindow(driver, "Contacts&action");
				
				// clicks on the save button
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

				Thread.sleep(1000);

	}
}
