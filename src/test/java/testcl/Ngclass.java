package testcl;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class Ngclass {
	@BeforeSuite
	public void befreSuite() {
		System.out.println("run");
	}

	@BeforeClass
	public static void beforeClass() {
		System.out.println("Before Classs");
	}
	
	
	
	@Test
	public void test() {
		System.out.println("Test");
	}
	
	@AfterSuite
	public void after() {
		System.out.println("After");
	}
	@Ignore
	@AfterClass
	public static void afterClass() {
		System.out.println("After Classs");
	}
}




