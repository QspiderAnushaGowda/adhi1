package TestNG;

import org.testng.annotations.Test;
//program to demostrate depends on
//if the create method if failed the other 2 method will be skipped
public class test_6 {

	@Test()
	public void create() {
		int[] arr= {1,2,3};
		System.out.println(arr[0]);
	}

	@Test(dependsOnMethods = "create")
	public void modify() {
		System.out.println("modified");
	}

	@Test(dependsOnMethods = "modify")
	public void delete() {
		System.out.println("deleted");
	}
}
