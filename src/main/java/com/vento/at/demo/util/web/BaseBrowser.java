/** 
 * Project Name:demo 
 * File Name:BaseBrowser.java 
 * Package Name:com.vento.at.demo.util.web 
 * Date:2018年10月25日下午3:07:50 
 * Copyright (c) 2018, www.vento.com All Rights Reserved. 
 * 
 */    
package com.vento.at.demo.util.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;

/** 
 * ClassName: BaseBrowser <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason: TODO ADD REASON(可选). <br/> 
 * date: 2018年10月25日 下午3:07:50 <br/> 
 * 
 * @author Toly 
 * @version  
 * @since JDK 1.8 
 */
public class BaseBrowser extends BaseDriver {

	/** 
	 * Creates a new instance of BaseBrowser. 
	 * 
	 * @param driver 
	 */
	public BaseBrowser(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void accessURL(String url) {
		driver.get(url);
	}
	
	public void accessURLWithNewWindow(String url) {
		((JavascriptExecutor) driver).executeScript("window.open('" + url + "')");
	}
	
	public String getPageURL() {
		return driver.getCurrentUrl();
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public String getCurrentWindow() {
		return driver.getWindowHandle();
	}
	
	protected List<String> getWindows() {
		Set<String> winHandles = driver.getWindowHandles();
		List<String> handles = new ArrayList<String>(winHandles);
		return handles;
	}
	
	public void switchWindow(String windowName) {
		driver.switchTo().window(windowName);
	}
	
	public boolean switchWindowByTitle(String titleName) {
		boolean flag = false;
		String currentHandle = this.getCurrentWindow();
		try {
			List<String> handles = this.getWindows();
			for (String handle : handles) {
				this.switchWindow(handle);
				if (this.getPageTitle().equals(titleName)) {
					flag = true;
					logger.debug("切换window[{}]成功。", titleName);
					break;
				} else {
					continue;
				}
			}
		} catch(NoSuchWindowException e) {
			logger.info("Window:[{}]没有找到", titleName, e.fillInStackTrace());
			flag = false;
		}
		
		if (!flag) {
			this.switchWindow(currentHandle);
		}
		return flag;
	}
}
 