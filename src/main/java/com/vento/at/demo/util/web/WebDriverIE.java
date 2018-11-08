/** 
 * Project Name:demo 
 * File Name:WebDriverIE.java 
 * Package Name:com.vento.at.demo.util.web 
 * Date:2018年11月7日下午5:19:22 
 * Copyright (c) 2018, www.vento.com All Rights Reserved. 
 * 
 */
package com.vento.at.demo.util.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * ClassName: WebDriverIE <br/>
 * Function: 单例模式创建InternetExplorer Driver. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2018年11月7日 下午5:19:22 <br/>
 * 
 * @author Toly
 * @version
 * @since JDK 1.8
 */
public class WebDriverIE extends BaseDriver {

	/**
	 * Creates a new instance of WebDriverIE.
	 * 
	 * @param driver
	 */
	private WebDriverIE(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// 实例
	private volatile static WebDriverIE instance;

	/**
	 * 
	 * getBaseDriverInstance:(单例模式). <br/>
	 * 
	 * @author Toly
	 * @return
	 * @since JDK 1.8
	 */
	public static WebDriverIE getBaseDriverInstance() {
		if (instance == null) {
			synchronized (WebDriverIE.class) {
				if (instance == null) {
					WebDriver driver = new InternetExplorerDriver();
					instance = new WebDriverIE(driver);
				}
			}
		}
		return instance;
	}

}
