/** 
 * Project Name:demo 
 * File Name:ElementUtil.java 
 * Package Name:com.vento.at.demo.util 
 * Date:2018年10月19日上午9:56:25 
 * Copyright (c) 2018, www.vento.com All Rights Reserved. 
 * 
 */
package com.vento.at.demo.util.web;

import org.openqa.selenium.By;

import com.vento.at.demo.util.PropertyUtil;

/**
 * ClassName: ElementUtil <br/>
 * Function:获取页面元素. <br/>
 * date: 2018年10月19日 上午9:56:25 <br/>
 * 
 * @author Toly
 * @version
 * @since JDK 1.8
 */
public class ElementLocator {
	// 自定义页面元素定义存放路径
	private static String PROPERTY_FILE_PATH = "res/";
	// 自定义页面元素文件后缀
	private static String PROPERTY_FILE_POSTFIX = ".element.properties";
	// 默认页面操作 BasePage 类的名称
	private static String DEFAULT_PAGE_CLASS_NAME = "com.vento.at.demo.util.web.BasePage";

	/**
	 * getLocator:(通过元素定义提取元素Locator). <br/>
	 * 
	 * @author Toly
	 * @param elementPropertyStr 元素定义
	 * @return 元素定位 By,如定义中不包含>，返回null
	 * @since JDK 1.8
	 */
	private static By getLocator(String elementPropertyStr) {

		if (elementPropertyStr.contains(">")) {
			String locatorType = elementPropertyStr.split(">")[0];
			String locatorValue = elementPropertyStr.split(">")[1];

			if (locatorType.equals("id")) {
				return By.id(locatorValue);
			} else if (locatorType.equals("name")) {
				return By.name(locatorValue);
			} else if (locatorType.equals("tagName")) {
				return By.tagName(locatorValue);
			} else if (locatorType.equals("linkText")) {
				return By.linkText(locatorValue);
			} else if (locatorType.equals("className")) {
				return By.className(locatorValue);
			} else {
				return By.xpath(locatorValue);
			}
		} else {
			return null;
		}
	}

	/**
	 * getLocator:(通过包名在指定配置文件中搜索页面元素定位属性). <br/>
	 * 
	 * @author Toly
	 * @param packageName <page class>文件所在包名，用于组建配置文件名称
	 * @param className   <page class>全路径
	 * @param key
	 * @return 【packageName.element.properties中对应关键字 Page中文.key的值】
	 * @since JDK 1.8
	 * 
	 */
	public static By getLocator(String packageName, String className, String key) {
		// 提取package中倒数第二个包名
		String packageNameProfix = packageName.split("\\.")[packageName.split("\\.").length - 2];
		// 组建配置文件res/[包名].element.properties中读取Properties
		PropertyUtil propertyUtil = new PropertyUtil(PROPERTY_FILE_PATH + packageNameProfix + PROPERTY_FILE_POSTFIX);
		// 提取Class的别名
		String classAliasName = propertyUtil.getPropertyByKey(className);
		// 提取元素别名
		String locatorName = propertyUtil.getPropertyByKey(classAliasName + "." + key);
		By by = getLocator(locatorName);
		return by;
	}
	
	/**
	 * 
	 * getDefaultLocator:从默认web.element.properties中提取元素). <br/> 
	 * 
	 * @author Toly
	 * @param key
	 * @return 
	 * @since JDK 1.8
	 */
	public static By getDefaultLocator(String key) {
		return getLocator(DEFAULT_PAGE_CLASS_NAME,DEFAULT_PAGE_CLASS_NAME,key);
	}

}
