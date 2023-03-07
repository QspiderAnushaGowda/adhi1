package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic_utility.File_Utility;
import Generic_utility.WebDriver_utility;
import Object_Repo.Create_Organization_page;
import Object_Repo.Home_page;
import Object_Repo.Login_page;

public class Data_Provider_Practice {

	@Test(dataProvider="data_provider_test")
	public void companyDetails(String name, String phone, String email) throws Throwable {
		// sets the path for chrome driver
		System.setProperty("webdriver.chrome.driver",
				"D:\\Advanced_Selenium_Workspace\\vTiger\\src\\main\\resources\\chromedriver.exe");

		// launches the browser
		WebDriver driver = new ChromeDriver();

		driver.get("http://localhost:8888/");
		// fetches the username from property file
		driver.findElement(By.name("user_name")).sendKeys("admin");

		// fetches the password from property file
		driver.findElement(By.name("user_password")).sendKeys("admin");

		// clicks on the login button
		driver.findElement(By.id("submitButton")).submit();

		// clicks on the organization link
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();

		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();

		driver.findElement(By.name("accountname")).sendKeys(name);

		driver.findElement(By.id("phone")).sendKeys(phone);

		driver.findElement(By.id("email1")).sendKeys(email);

		driver.findElement(By.xpath("(//input[@accesskey='S'])[1]")).click();

		driver.quit();

		Thread.sleep(2000);

	}

	@DataProvider

	public Object[][] data_provider_test() throws Throwable

	{
		Object[][] arr = new Object[3][3];
		arr[0][0] = "AAA";
		arr[0][1] = "9123456789";
		arr[0][2] = "AAA@gmail.com";

		Thread.sleep(2000);

		arr[1][0] = "BBB";
		arr[1][1] = "9123456789";
		arr[1][2] = "BBB@gmail.com";

		Thread.sleep(2000);

		arr[2][0] = "CCC";
		arr[2][1] = "9123456789";
		arr[2][2] = "CCC@gmail.com";

		Thread.sleep(2000);
		return arr;
	}

}
