package Generic_utility;

import java.io.File;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersClass implements ITestListener{

	public void onTestFailure(ITestResult result) {


		String testName=result.getMethod().getMethodName();
		System.out.println("-------------execute----------");
//		ITestListener.super.onTestFailure(result);
		
		EventFiringWebDriver edriver=new EventFiringWebDriver(BaseClass.sdriver);
		
		File src=edriver.getScreenshotAs(OutputType.FILE);
		
		//LocalDateTime local= LocalDateTime.now();
		
		//String dateTime1=local.toString().replace(" ", "-");
		
		try {
			FileUtils.copyFile(src, new File("./Screenshot/"+testName+".png"));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
	

}
