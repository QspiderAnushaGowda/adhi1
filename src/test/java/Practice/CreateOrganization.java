package Practice;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
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
import org.testng.asserts.SoftAssert;

import Generic_utility.BaseClass;
import Generic_utility.Excel_Utility;
import Generic_utility.File_Utility;
import Generic_utility.Java_Utility;
import Generic_utility.WebDriver_utility;
import Object_Repo.Create_Organization_page;
import Object_Repo.Home_page;
import Object_Repo.Login_page;
import Object_Repo.ValidationAndVerification_Page;
import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(Generic_utility.ListenersClass.class)
public class CreateOrganization extends BaseClass {

	// program to add organization name ... (fetching data from property file for
	// login
	// fetching data from excel for organization name and save it
	// doing mouseover operation on icon and clicking on signout button

	//public static void main(String[] args) throws Throwable {
	
	//@Test(retryAnalyzer=Generic_utility.RetryImpClass.class)
	//@Test(groups="smoke")
	@Test
	public void createOrganization() throws Throwable
	{
		
		
		
		
		//launching the browser
//		String Browser = flib.getKeyAndVAlue("browser");
//		
//		WebDriver driver;
//		
//		if(Browser.equalsIgnoreCase("chrome"))
//		{
//			WebDriverManager.chromedriver().setup();
//			driver=new ChromeDriver();
//		}
//		
//		else if(Browser.equalsIgnoreCase("edge"))
//		{
//			WebDriverManager.edgedriver().setup();
//			driver=new EdgeDriver();
//		}
//		
//		else if(Browser.equalsIgnoreCase("firefox"))
//		{
//			WebDriverManager.firefoxdriver().setup();
//			driver=new FirefoxDriver();
//		}
//		
//		else
//		{
//			driver=new ChromeDriver();
//		}
//		// sets the path for chrome driver
//		System.setProperty("webdriver.chrome.driver",
//				"D:\\Advanced_Selenium_Workspace\\vTiger\\src\\main\\resources\\chromedriver.exe");

		// launches the browser
		//WebDriver driver = new ChromeDriver();

		WebDriver_utility wlib = new WebDriver_utility();
		//File_Utility flib = new File_Utility();
		Java_Utility jlib = new Java_Utility();
		Excel_Utility Elib = new Excel_Utility();
		//Login_page login = new Login_page(driver);
		Create_Organization_page org = new Create_Organization_page(driver);
		Home_page home=new Home_page(driver);
		//ValidationAndVerification_Page valid=new ValidationAndVerification_Page(driver);
		
		wlib.maximizeScreen(driver);

		wlib.waitForPageToLoad(driver); 
//		// to read the data from property file first the FIS object should be craeted
//		FileInputStream fis = new FileInputStream("./src/test/resources/commondata.properties.txt");
//
//		// properties object should be created to read the data from the external
//		// resources
//		Properties pro = new Properties();
//
//		// call the load method from proerty file and give the input of FIS object
//		pro.load(fis);
//
//		// fetch the url from property file and store it in a variable URL
//		String URL = pro.getProperty("url");

		// fetch the username from property file and store it in a variable URL
//		String UN = pro.getProperty("username");
//
//		// fetch the password from property file and store it in a variable PW
//		String PW = pro.getProperty("password");
//
//		// String OrName = pro.getProperty("organizationName");
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

//		// clicks on the organization link
		//driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		home.clickOrganizationLink();
		
		org.clickOnImage();
//
//		// clicks on the plus sign
//		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();

//		// to avoid duplicate we use random class
//		Random ran = new Random();
//		int ranNum = ran.nextInt(1000);// 1000 differnt values it will generate
//		// we sholud concat with the getStringcellvalue

		// calling method from java utility class

		int ranNum = jlib.getRandomNum();

		// fetching the data from excel

//		FileInputStream fis1 = new FileInputStream("./src/test/resources/OrganizationName.xlsx");
//
//		Workbook book = WorkbookFactory.create(fis1);
//
//		Sheet sh = book.getSheet("Organization");
//
//		Row row = sh.getRow(1);
//
//		Cell cel = row.getCell(3);

		String orgname = Elib.getExcelData("Organization", 1, 3) + ranNum;

		// fetches the org name from excel and it is concat with ranNum
		// String orgname = cel.getStringCellValue() + ranNum;

		// enters the data into Organization name text box
		// driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgname);
		org.EnterDataOnText(orgname);
		
		//Assert.assertEquals("A","B");
		
		// clicks on the save button
		// driver.findElement(By.xpath("(//input[@accesskey='S'])[1]")).click();
		org.ClickOnSave();
	
		Thread.sleep(3000);
		
		//valid.organizationValidation(driver, orgname);
		
		//validation
		 //String actualData = driver.findElement(By.xpath("//span[text()='"+orgname+"']")).getText();
		
		 Thread.sleep(3000); 
		 
		 //validation using softassert
//		 SoftAssert st=new SoftAssert();
//			st.assertEquals(actualData,orgname);
//			st.assertAll();
//		 
		 
		 
		 //validation using hard assert
		 //Assert.assertEquals(actualData, orgname);
//		if(actualData.contains(orgname))
//		{
//			System.out.println("validation pass");
//		}
//		else
//		{
//			System.out.println("validation fail");
//		}
//		
		
		
		//Thread.sleep(3000);

		// storing the web element for the mouseover operation
		//WebElement icon = driver.findElement(By.xpath("(//td[@valign='bottom'])[2]"));

		//wlib.mouseOverOnElement(driver, icon);
//		// actions object is created for mouseover operation
//		Actions a = new Actions(driver);
//
//	a.moveToElement(icon).perform();

		// clicking on the signout link
		//driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		 //home.ClickOnSignOut();
	
		 //driver.close();
	}
	
//	@Test
//	public void m1()
//	{
//		System.out.println("m1 is running");
//	}

}
