package run;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependsON {
	
	@Test
	public void testa() {
		System.out.println("Test A Method");
	}
	
	@Test(dependsOnMethods="testc",description="This is test works on DependsON Methods")
	public void testb() {
		System.out.println("Test B Method");
	}
	
//	@Test(dependsOnMethods="testa")
//	public void testc() {
//		System.out.println("Test C Method");
//		Assert.assertTrue(false);
//	}
	
	@Test(dependsOnMethods="testa")
	public void testc() {
		System.out.println("Test C Method");
		Assert.assertTrue(true);
	}
	
	

}
