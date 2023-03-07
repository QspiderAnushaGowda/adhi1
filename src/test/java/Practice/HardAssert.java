package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssert {

	@Test
	public void creat()
	{
		System.out.println("step1");
		System.out.println("step2");
		//hard asert-- using for major validation
		Assert.assertEquals(false, true);
		//					actual result, expected result-- it fails--so below stat dont execute
		System.out.println("step3");
		System.out.println("step4");
	}
	
	@Test
	public void modifycreat()
	{
		System.out.println("step5");
		System.out.println("step6");
}
	
	@Test
	public void createContact()
	{
		String actual="Anusha";
		String expected="Anusha";
		Assert.assertEquals(actual, expected);
	}
}
