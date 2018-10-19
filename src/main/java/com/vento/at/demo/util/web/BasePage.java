/** 
 * Project Name:demo 
 * File Name:BasePage.java 
 * Package Name:com.vento.at.demo.util.web 
 * Date:2018年10月19日上午10:26:02 
 * Copyright (c) 2018, www.vento.com All Rights Reserved. 
 * 
 */    
package com.vento.at.demo.util.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.vento.at.demo.util.ElementUtil;

/** 
 * ClassName: BasePage <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason: TODO ADD REASON(可选). <br/> 
 * date: 2018年10月19日 上午10:26:02 <br/> 
 * 
 * @author Toly 
 * @version  
 * @since JDK 1.8 
 */
public class BasePage {
	public WebDriver driver;
	public BasePage(WebDriver driver){
		this.driver = driver;
	}

	/** 
	 * Creates a new instance of BasePage. 
	 *  
	 */
	public BasePage() {
		// TODO Auto-generated constructor stub
	}

	public WebElement getElementByKey(String key) {
		//WebElement element = driver.findElement(by);
		By byLocator = ElementUtil.getLocator(this, key);
		System.out.println("Locator:" + byLocator.toString());
		return null;
		
	}
}
 