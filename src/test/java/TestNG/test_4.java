package TestNG;

import org.testng.annotations.Test;
//test script will execute in alphabetical order
public class test_4 {

	@Test
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

//O/P
//PASSED: create
//PASSED: modify
//PASSED: delete
//
//===============================================
//    Default test
//    Tests run: 3, Failures: 0, Skips: 0
//===============================================
//
//
//===============================================
//Default suite
//Total tests run: 3, Passes: 3, Failures: 0, Skips: 0
//===============================================

