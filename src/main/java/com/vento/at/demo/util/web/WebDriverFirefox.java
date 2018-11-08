/** 
 * Project Name:demo 
 * File Name:WebDriverFirfox.java 
 * Package Name:com.vento.at.demo.util.web 
 * Date:2018年11月7日下午5:17:06 
 * Copyright (c) 2018, www.vento.com All Rights Reserved. 
 * 
 */
package com.vento.at.demo.util.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * ClassName: WebDriverFirefox <br/>
 * Function: 单例模式创建Firefox Driver. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2018年11月7日 下午5:17:06 <br/>
 * 
 * @author Toly
 * @version
 * @since JDK 1.8
 */
public class WebDriverFirefox extends BaseDriver {

	/**
	 * Creates a new instance of WebDriverFirefox.
	 * 
	 * @param driver
	 */
	private WebDriverFirefox(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// 实例
	private volatile static WebDriverFirefox instance;

	/**
	 * 
	 * getBaseDriverInstance:(单例模式). <br/>
	 * 
	 * @author Toly
	 * @return
	 * @since JDK 1.8
	 */
	public static WebDriverFirefox getBaseDriverInstance() {
		if (instance == null) {
			synchronized (WebDriverFirefox.class) {
				if (instance == null) {
					WebDriver driver = new FirefoxDriver();
					instance = new WebDriverFirefox(driver);
				}
			}
		}
		return instance;
	}
}
