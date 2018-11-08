/** 
 * Project Name:demo 
 * File Name:WebDriverChrome.java 
 * Package Name:com.vento.at.demo.util.web 
 * Date:2018年11月7日下午5:11:18 
 * Copyright (c) 2018, www.vento.com All Rights Reserved. 
 * 
 */
package com.vento.at.demo.util.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * ClassName: WebDriverChrome <br/>
 * Function: 单例模式创建Chrome Driver. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2018年11月7日 下午5:11:18 <br/>
 * 
 * @author Toly
 * @version
 * @since JDK 1.8
 */
public class WebDriverChrome extends BaseDriver {

	/**
	 * Creates a new instance of WebDriverChrome.
	 * 
	 * @param driver
	 */
	private WebDriverChrome(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// 实例
	private volatile static WebDriverChrome instance;

	/**
	 * 
	 * getBaseDriverInstance:(单例模式). <br/>
	 * 
	 * @author Toly
	 * @return
	 * @since JDK 1.8
	 */
	public static WebDriverChrome getBaseDriverInstance() {
		if (instance == null) {
			synchronized (WebDriverChrome.class) {
				if (instance == null) {
					WebDriver driver = new ChromeDriver();
					instance = new WebDriverChrome(driver);
				}
			}
		}
		return instance;
	}

}
