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
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Cookie;
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
		this.initailBrowserSettings();
	}
	
	

	/** 
	 * initailBrowserSettings:(浏览器其它配置项). <br/> 
	 * 
	 * @author Toly 
	 * @since JDK 1.8 
	 */  
	private void initailBrowserSettings() {
		// TODO Auto-generated method stub
		this.setImplicitlyWaitTime(10);
	}



	/** 
	 * setImplicitlyWaitTime:(设置页面元素等待时间). <br/> 
	 * 
	 * @author Toly
	 * @param i 时间s
	 * @since JDK 1.8 
	 */  
	private void setImplicitlyWaitTime(int i) {
		// TODO Auto-generated method stub
		this.driver.manage().timeouts().implicitlyWait(i, TimeUnit.SECONDS);
	}



	/** 
	 * getDriver:(这里用一句话描述这个方法的作用). <br/> 
	 * 
	 * @author Toly
	 * @return 
	 * @since JDK 1.8 
	 */  
	public WebDriver getDriver() {
		// TODO Auto-generated method stub
		return this.driver;
	}

	/** 
	 * quit:(退出浏览器). <br/>  
	 * 
	 * @author Toly 
	 * @since JDK 1.8 
	 */  
	public void quit() {
		// TODO Auto-generated method stub
		this.driver.quit();
	}
	
	/**
	 * 
	 * close:(关闭当前页面). <br/> 
	 * 
	 * @author Toly 
	 * @since JDK 1.8
	 */
	public void close() {
		this.driver.close();
	}
	
	public Set<Cookie> getCookie() {
		Set<Cookie> cookies = this.driver.manage().getCookies();
		return cookies;
	}
	
	public void deleteAllCookies() {
		this.driver.manage().deleteAllCookies();
	}
	
	public void setCookie(Cookie cookie) {
		this.driver.manage().addCookie(cookie);
	}
}
 