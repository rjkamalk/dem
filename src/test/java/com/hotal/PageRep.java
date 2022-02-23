package com.hotal;

import org.openqa.selenium.WebDriver;

public class PageRep  extends Hotalreg{
	private Hotallog rg;

	public Hotallog getRg() {
		if(rg== null) {
			rg = new Hotallog(driver);
		}
		return rg;
	}

	public PageRep(WebDriver cdriver) {
		this .driver=cdriver;
	}
}
