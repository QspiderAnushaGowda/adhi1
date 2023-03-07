package TestNG;

import org.testng.annotations.Test;

public class test_1 {
	public class testNG {
		//only 1 test script will run since only m1 has test annotation
		@Test
		public void m1()
		{
			System.out.println("test");
		}

	
		public void m2()
		{
			System.out.println("test");
		}
	}

}
