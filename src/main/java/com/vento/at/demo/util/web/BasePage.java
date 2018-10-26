/** 
 * Project Name:demo 
 * File Name:BasePage.java 
 * Package Name:com.vento.at.demo.util.web 
 * Date:2018年10月19日上午10:26:02 
 * Copyright (c) 2018, www.vento.com All Rights Reserved. 
 * 
 */    
package com.vento.at.demo.util.web;

import java.lang.invoke.MethodHandles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
public class BasePage extends BaseBrowser {

	//static Logger logger = Logger.getLogger(BasePage.class);

	public BasePage(WebDriver driver){
		super(driver);
	}

	public WebElement getElementByKey(String key) {
		//WebElement element = driver.findElement(by);

		By byLocator = ElementUtil.getLocator(this.getClass().getPackage().getName(), this.getClass().getName(), key);
		logger.info("Locator: {}", byLocator.toString());
		return null;
	}
	
	public WebDriver getDriver() {
		this.getSnapshots();
		return this.driver;
	}
	
}
 