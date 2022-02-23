package com.hotal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Hotallog extends Hotalreg {
	@FindBy(id="username")
	private WebElement username;
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="re_password")
	private WebElement repassword;
	
	@FindBy(id="full_name")
	private WebElement fullname;
	
	@FindBy(id="email_add")
	private WebElement emailadd;
	
	@ FindBy(xpath="//*[@id=\'login_form\']/table/tbody/tr[7]/td/a")
	 private WebElement click;

	public WebElement getClick() {
		return click;
	}
	public WebElement getUsername() {
		return username;
	}
   public WebElement getPassword() {
		return password;
	}
   public WebElement getRepassword() {
		return repassword;
	}
  public WebElement getFullname() {
		return fullname;
	}
  public WebElement getEmailadd() {
		return emailadd;
	}
  public Hotallog(WebDriver cdriver) {
		this.driver = cdriver;
		PageFactory.initElements(driver, this);
	}
	


}
