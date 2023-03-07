package TestNG;

import org.testng.annotations.Test;

public class test_2 {
	// both the test script will run since both m1 and m2 has test annotation
	@Test
	public void m1() {
		System.out.println("test");
	}

	@Test
	public void m2() {
		System.out.println("test");
	}
}
