package Generic_utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import Object_Repo.Home_page;
import Object_Repo.Login_page;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.OperaDriverManager;

public class BaseClass {
public static WebDriver sdriver;
public WebDriver driver;


@BeforeSuite
public void BS()
{
	System.out.println("database Connection");
}

@BeforeTest
public void BT()
{
	
	System.out.println("Parallel Execution");
}

//@Parameters("Browser")
@BeforeClass
public void BC() throws Throwable
//public void BC(String Browser) throws Throwable
{
File_Utility flib=new File_Utility();
	String Browser=flib.getKeyAndVAlue("browser");
	
	//String Browser=System.getProperty("browser");--for maven_command project
	
	if(Browser.equalsIgnoreCase("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	
	else if(Browser.equalsIgnoreCase("edge"))
	{
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
	}
	
	else if(Browser.equalsIgnoreCase("firefox"))
	{
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
	}
	
	
	else
	{
		driver=new ChromeDriver();
	}
	System.out.println("Launching the browser");
	
	sdriver=driver;
	
}

@BeforeMethod
public void BM() throws Throwable
{
	File_Utility flib=new File_Utility();
	
	String URL = flib.getKeyAndVAlue("url");

	String UN = flib.getKeyAndVAlue("username");

	String PW = flib.getKeyAndVAlue("password");
	
	driver.get(URL);

	Login_page login=new Login_page(driver);
	
	login.loginToApp(UN, PW);
	System.out.println("Login to Application");
}

@AfterMethod(groups= {"smoke","regression"})
public void AM()
{
	Home_page home=new Home_page(driver);
	
	WebDriver_utility wlib = new WebDriver_utility();
	
	WebElement icon = driver.findElement(By.xpath("(//td[@style='padding-bottom: 1em;'])[1]"));

	wlib.mouseOverOnElement(driver, icon);
	
	home.ClickOnSignOut();
	System.out.println("Logout from Application");
	//driver.quit();
}

@AfterClass
public void AC()
{
	System.out.println("Close Browser");
}


@AfterTest
public void AT()
{
	
	System.out.println("Execution done");
}

@AfterSuite
public void AS()
{
	System.out.println("database disConnection");
}
}
