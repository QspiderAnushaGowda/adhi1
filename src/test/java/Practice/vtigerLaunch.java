package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class vtigerLaunch {
	public static void main(String[] args) throws Throwable {

		System.setProperty("webdriver.chrome.driver",
				"D:\\Advanced_Selenium_Workspace\\vTiger\\src\\main\\resources\\chromedriver.exe");

		// launches the browser
		WebDriver driver = new ChromeDriver();

		// to read the data from property file first the FIS object should be craeted
		FileInputStream fis = new FileInputStream("./src/test/resources/commondata.properties.txt");

		// properties object should be created to read the data from the external
		// resources
		Properties pro = new Properties();
		
		// call the load method from proerty file and give the input of FIS object
		pro.load(fis);

		// fetch the url from property file and store it in a variable URL
		String URL = pro.getProperty("url");

		// fetch the username from property file and store it in a variable URL
		String UN = pro.getProperty("username");

		// fetch the password from property file and store it in a variable PW
		String PW = pro.getProperty("password");

		driver.get(URL);

		driver.findElement(By.name("user_name")).sendKeys(UN);

		driver.findElement(By.name("user_password")).sendKeys(PW);

		driver.findElement(By.id("submitButton")).submit();

	}
}