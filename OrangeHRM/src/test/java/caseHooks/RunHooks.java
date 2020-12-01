package caseHooks;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RunHooks {
	/*
	 * Hooks are use to run a piece of code over and over w/out having to write it
	 * Different types of hooks
	 * 
	 * @Before method - will run before each test method
	 * 
	 * @Before class - will run before each class
	 * 
	 * @Before group - will run before each test group
	 * 
	 * @Before test - will run before entire test run
	 * 
	 * @Before suite - will run before the test suite also includes an @After
	 */
	@Test
	public void test1() {
		System.out.println("\nthis is the first test");
	}

	@Test
	public void test2() {
		System.out.println("\nthis is the second test");
	}

	@Test
	public void test3() {
		System.out.println("\nthis is the third test");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("this is before the method");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("\nthis after the method");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("\nthis is before the class");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("\nthis is after the class");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("\nthis is before all test");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("\nthis is after all test");
	}
	
	@BeforeGroups
	public void beforeGroup() {
		System.out.println("\nthis is before the groups");
	}
	
	@AfterGroups
	public void aferGroup() {
		System.out.println("\nthis is after the groups");
	}
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("\nthis is before the suites");
	}
	
	@AfterSuite
	public void aferSuite() {
		System.out.println("\nthis is after the suites");
	}
}
