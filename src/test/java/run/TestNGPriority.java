package run;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TestNGPriority {
	
	@Ignore
	@Test(priority=-1)
	public void testc() {
		System.out.println("Test C Method");
	}
	
	@Test(priority=1)
	public void testd() {
		System.out.println("Test D Method");
	}
	
	@Test
	public void testa() {
		System.out.println("Test A Method");
	}
	
	@Test(priority=-2,enabled=false)
	public void testb() {
		System.out.println("Test B Method");
	}
	
	@Test(priority=1)
	public void teste() {
		System.out.println("Test E Method");
	}
	
	@Test(priority=0)
	public void testf() {
		System.out.println("Test F Method");
	}
	
	@Test(priority=3)
	public void testg() {
		System.out.println("Test G Method");
	}
	
	
	
	
	

	
//	@Test
//	public void tes() {
//		System.out.println("Test tes Method");
//	}
//	
//	@Test
//	public void teSt() {
//		System.out.println("Test test Method");
//	}
//	
//	@Test
//	public void ted() {
//		System.out.println("Test ted Method");
//	}
//		
	
	
//	@Test
//	public void testc() {
//		System.out.println("Test C Method");
//	}
//	
//	@Test
//	public void testd() {
//		System.out.println("Test D Method");
//	}
//	
//	@Test
//	public void testa() {
//		System.out.println("Test A Method");
//	}
//	
//	@Test
//	public void testb() {
//		System.out.println("Test B Method");
//	}
//	
//	@Test
//	public void teste() {
//		System.out.println("Test E Method");
//	}
//	
//	@Test
//	public void testf() {
//		System.out.println("Test F Method");
//	}

}
