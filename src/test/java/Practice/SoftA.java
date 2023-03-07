package Practice;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftA {

	
	@Test
	public void createContact()
	{
		System.out.println("Step1");
		System.out.println("Step2");
		SoftAssert st=new SoftAssert();
		st.assertEquals(true, true);
		System.out.println("Step3");
		System.out.println("Step4");
		st.assertAll();
	}
	
	@Test
	public void modifyContact()
	{
		System.out.println("Step5");
		System.out.println("Step6");
	
	
}
}
