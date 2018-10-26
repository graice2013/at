/** 
 * Project Name:demo 
 * File Name:BaseDriver.java 
 * Package Name:com.vento.at.demo.util.web 
 * Date:2018年10月25日下午3:06:12 
 * Copyright (c) 2018, www.vento.com All Rights Reserved. 
 * 
 */    
package com.vento.at.demo.util.web;

import java.lang.invoke.MethodHandles;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 
 * ClassName: BaseDriver <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason: TODO ADD REASON(可选). <br/> 
 * date: 2018年10月25日 下午3:06:12 <br/> 
 * 
 * @author Toly 
 * @version  
 * @since JDK 1.8 
 */
public class BaseDriver {
	protected static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	protected WebDriver driver;

	/** 
	 * Creates a new instance of BaseDriver. 
	 * 
	 * @param driver 
	 */
	public BaseDriver(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
}
 