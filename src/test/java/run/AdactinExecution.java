package run;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pagefactory.AdactinLoginPage;
import pagefactory.PageRepository;
import testcl.BaseClass;

public class AdactinExecution extends BaseClass {
	
	public static PageRepository pr = new PageRepository(driver);
	
//	@Parameters("url")
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("This is my Before Method");
//		driver.get(browers);
	}
	
	
//	@Test
//	public void loginWithValidCredentias() {
//		System.out.println("Test Method");
//		AdactinLoginPage al =new AdactinLoginPage();
//		typeData(al.getUsername(), "rajkamalk");
//		typeData(al.getPassword(), "0987654321");
//		click(al.getLoginBtn());
//	}
	
	@Test
	public void loginWithInValidCredentias() {
		System.out.println("Test Method");
		typeData(pr.getAl().getUsername(), "rajkamalk");
//		typeData(element, data);
		click(pr.getAl().getLoginBtn());
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
