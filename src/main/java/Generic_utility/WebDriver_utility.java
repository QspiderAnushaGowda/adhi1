package Generic_utility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
//program for maximize window,imlicitply wait(waitForPageToLoad)
public class WebDriver_utility {

	public void maximizeScreen(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * wait for page to load before identifying any synchronized element in DOM
	 * 
	 * @author adhi1
	 */
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	/**
	 * after every action it will wait for next action to perform
	 */

	public void scriptTimeOut(WebDriver driver) {
		driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);

	}

	/**
	 * used to wait for element to be clickable in GUI and check for specific
	 * element for every 500ms
	 */
	public void waitForElementWithCustomTimeout(WebDriver driver, WebElement Element, int pollingTime) {
		FluentWait wait = new FluentWait(driver);
		wait.pollingEvery(Duration.ofSeconds(pollingTime));
		wait.until(ExpectedConditions.elementToBeClickable(Element));

	}

	/**
	 * used to switch to any window based on window title
	 */
	public void switchToWindow(WebDriver driver, String partialWindowTitle) {
		Set<String> allID = driver.getWindowHandles();// 1,2,3,4 windows

		// iterator from collection class //it is cursor used to fetch the data one by
		// one
		Iterator<String> it = allID.iterator();

		// hasnext is a method of iterator interface
		while (it.hasNext()) {// 1 org 2pro

			String wid = it.next();// org //pro

			driver.switchTo().window(wid);// control switched to org //control switched to pro

			;// title is retrive from org page// //title is retrive from pro page(pop up
				// page)

			if (driver.getTitle().contains(partialWindowTitle)) {// org page title is not satisfied (false) ////pro page
																	// title is
				// satisfied (true)
				break;// comes inside the loop and loop will break
			}
		}
	}

	/**
	 * used to switch to AlertWindow and Accept(click on button)
	 * 
	 * @author adhi1
	 */
	public void switchToAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	/**
	 * 
	 */
	public void switchToAlertAndDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * used to switch to frame window based on Index
	 * 
	 * @author adhi1
	 */
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * used to switch to frame window based on id or name attribute
	 * 
	 * @author adhi1
	 * 
	 */
	public void switchToFrame(WebDriver driver, String id_name_Attribute) {
		driver.switchTo().frame(id_name_Attribute);
	}

	/**
	 * used to select the value from the dropdown based on the index
	 * 
	 * @author adhi1
	 * @param element
	 * @param text
	 */
	public void select(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);

	}

	/**
	 * used to select the value from the dropdown based on the text
	 * 
	 * @author adhi1
	 * @param element
	 * @param text
	 */
	public void select(WebElement element, String text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	/**
	 * used to place mouse cursor on specific element
	 */
	public void mouseOverOnElement(WebDriver driver, WebElement element)
	{
		
				Actions act = new Actions(driver);
				
				act.moveToElement(element).perform();
	}
	/**
	 * used to right click on specific element
	 * @author adhi1
	 */
	  public void rightClickOnElement(WebDriver driver, WebElement element)
	{
		
				Actions act = new Actions(driver);
				act.contextClick(element).perform();
	}
	  
	public void moveByOffset(WebDriver driver, int x, int y)
	{
		
				Actions act = new Actions(driver);
				act.moveByOffset(x, y).click().perform();
	}
	 

}
