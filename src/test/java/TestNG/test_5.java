package TestNG;
//Priority: when ever we execute testng class by default all the test method  will be executed based on the alphabetical order
//In order to change the order of execution we go for priority

import org.testng.annotations.Test;

public class test_5 {
	@Test(priority = 1)
	public void create() {
		System.out.println("created");
	}

	@Test(enabled=false)
	public void modify() {
		System.out.println("modified");
	}
	

//	@Test(priority = 2)
//	public void modify() {
//		System.out.println("modified");
//	}

	@Test(priority = 3)
	public void delete() {
		System.out.println("deleted");
	}
}

//Output
//created
//modified
//deleted