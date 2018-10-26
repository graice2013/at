/** 
 * Project Name:demo 
 * File Name:ElementUtil.java 
 * Package Name:com.vento.at.demo.util 
 * Date:2018年10月19日上午9:56:25 
 * Copyright (c) 2018, www.vento.com All Rights Reserved. 
 * 
 */
package com.vento.at.demo.util;

import org.openqa.selenium.By;

/**
 * ClassName: ElementUtil <br/>
 * Function:获取页面元素. <br/>
 * date: 2018年10月19日 上午9:56:25 <br/>
 * 
 * @author Toly
 * @version
 * @since JDK 1.8
 */
public class ElementUtil {
	// 自定义页面元素定义存放路径
	private static String PROPERTY_FILE_PATH = "res/";
	// 自定义页面元素文件后缀
	private static String PROPERTY_POSTFIX = ".element.properties";
	// 自定义BasePage子类与页面名称对应配置文件
	private static String DEFAULT_BASEPAGE_CLASS_MAPPING_FILE = "class.element.properties";
	// 默认页面操作 BasePage 类的包名
	private static String DEFAULT_PACKAGE_NAME = "web";
	// 默认页面操作 BasePage 类的名称
	private static String DEFAULT_PAGE_CLASS_NAME = "com.vento.at.demo.util.web.BasePage";

	/**
	 * getLocator:(通过包名在指定配置文件中搜索页面元素定位属性). <br/>
	 * 
	 * @author Toly
	 * @param packageName class文件所在包名，用于组建配置文件名称
	 * @param className   pageClassName 从配置文件class.element.properties中提取Page的中文描述
	 * @param key
	 * @return 【packageName.element.properties中对应关键字 Page中文.key的值】
	 * @since JDK 1.8
	 * 
	 * @deprecated 由函数 getLocator(String packageName, String pageClassName, String key)取代
	 * 传送对象代价过大
	 */
	public static By getLocator(String packageName, Object object, String key) {
		
		return getLocator(packageName, getKeyValueByClassName(object.getClass().getName(), key));

	}

	/**
	 * getLocator:(通过BasePage对象在指定配置文件中搜索页面元素定位属性). <br/>
	 * 
	 * @author Toly
	 * @param object BasePage Class对象
	 * @param key    页面元素关键字
	 * @return 返回By定位对象
	 * @since JDK 1.8
	 * 
	 * @deprecated 由函数 getLocator(String packageName, String pageClassName, String key)取代
	 * 传送对象代价过大
	 */
	public static By getLocator(Object object, String key) {

		// 通过classPath及元素名称组建关键字
		String keyStr = getKeyValueByClassName(object.getClass().getName(), key);
		return getLocator(object.getClass().getPackage().getName(), keyStr);

	}

	/**
	 * getLocator:(通过包名在指定配置文件中搜索页面元素定位属性). <br/>
	 * 
	 * @author Toly
	 * @param packageName class文件所在包名，用于组建配置文件名称
	 * @param pageClassName   pageClassName 从配置文件class.element.properties中提取Page的中文描述,为pageClass全路径
	 * @param key
	 * @return 【packageName.element.properties中对应关键字 Page中文.key的值】
	 * @since JDK 1.8
	 *  
	 */
	public static By getLocator(String packageName, String pageClassName, String key) {

		String className = getKeyValueFromPackage(packageName, pageClassName);		
		return getLocator(packageName, className + "." + key);

	}

	/**
	 * getLocator:(通过包名在指定配置文件中搜索页面元素定位属性). <br/>
	 * 
	 * @author Toly
	 * @param packageName class文件所在包名，用于组建配置文件名称
	 * @param key         关键字搜索
	 * @return 元素定位 By
	 * @since JDK 1.8
	 */
	private static By getLocator(String packageName, String key) {

		String locator = getKeyValueFromPackage(packageName, key);
		String locatorType = locator.split(">")[0];
		String locatorValue = locator.split(">")[1];

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
	}

	/** 
	 * getKeyValueFromPackage:(通过package从指定package.element.properties中提取关键字). <br/> 
	 * 
	 * @author Toly
	 * @param packageName 包名，组成packagename.element.properties文件名
	 * @param key 查找的关键字
	 * @return 查找到的关键字对应值
	 * @since JDK 1.8 
	 */  
	private static String getKeyValueFromPackage(String packageName, String key) {
		// 若packageName为空，设定默认值
		if (packageName == null) {
			packageName = DEFAULT_PACKAGE_NAME;
		}

		// 将com.vento.at.demo.util.web 处理为 web
		String packageNameProfix = packageName.split("\\.")[packageName.split("\\.").length - 1];
		// 组建配置文件名 "res/web.element.properties"
		String propertyFilePathStr = PROPERTY_FILE_PATH + packageNameProfix + PROPERTY_POSTFIX;
		PropertyUtil propertyUtil = new PropertyUtil(propertyFilePathStr);

		String keyValue = propertyUtil.getPropertyByKey(key);
		
		return keyValue;
	}
	
	/**
	 * getKeyValue:(通过classPath及元素名称组建关键字). <br/>
	 * 
	 * @author Toly
	 * @param pageClassName 从配置文件class.element.properties中提取Page的中文描述;
	 *                      .若为NULL，返回BasePage
	 * @param key
	 * @return 转义后的 【page中文描述.key】; 若未找到pageClass对应值，返回【BasePage中文描述.key】
	 * @since JDK 1.8
	 * 
	 * @deprecated 设计变更，将Class的中文配置保存在对的Package.element.properties中，不再通过单独的
	 * class.element.properties设置
	 */
	private static String getKeyValueByClassName(String pageClassName, String key) {
		// 默认页面类与页面名称配置 res/class.element.properties
		String propertyFilePathStr = PROPERTY_FILE_PATH + DEFAULT_BASEPAGE_CLASS_MAPPING_FILE;

		PropertyUtil propertyUtil = new PropertyUtil(propertyFilePathStr);
		// 若 pageClassName为空，使用BasePage作为页面类
		if (pageClassName == null) {
			pageClassName = DEFAULT_PAGE_CLASS_NAME;
		}
		String keyPrefix = propertyUtil.getPropertyByKey(pageClassName);
		// 若未定义该pageClassName的页面名称，设置默认值为"BasePage"
		if (keyPrefix == null) {
			keyPrefix = propertyUtil.getPropertyByKey(DEFAULT_PAGE_CLASS_NAME);
		}

		return keyPrefix + "." + key;
	}
}
