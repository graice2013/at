package com.vento.at.demo.util;

import org.testng.annotations.Test;

public class ElementUtilTest {

	@Test
	public void getLocatorStringStringString() {
//		String locator = "asdfasdf.asdfas.asdfa.asdf.asdf"; 
//		System.out.println( locator.split("\\.").length);
		System.out.println(ElementUtil.getLocator(this, "标题").toString());
		System.out.println( this.getClass().getName());
		System.out.println( this.getClass().getPackage());
	}

	@Test
	public void getLocatorStringString() {
	//	System.out.println(ElementUtil.getLocator("asdfadf.web", "BasePage", "标题").toString());
	}
}
