package pagefactory;

import org.openqa.selenium.WebDriver;

import testcl.BaseClass;

public class PageRepository extends BaseClass {
	
	private AdactinLoginPage al;


	public AdactinLoginPage getAl() {
		if (al==null) {
			al = new AdactinLoginPage(driver);
		}
		return al;
	}
	
	public PageRepository(WebDriver fdriver) {
		this.driver=fdriver;
	}
}
