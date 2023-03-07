package TestNG;

import org.testng.annotations.Test;
//to execute same method multiple times with same set of data we use invocationCount
public class test_7 {

	@Test(invocationCount=3)
	public void create() {
		System.out.println("test");
	}

	@Test
	public void modify() {
		System.out.println("test");
	}
	
	@Test
	public void delete() {
		System.out.println("test");
	}
}
//to execute same method multiple times with different set of data we use dataprovider
