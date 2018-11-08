/** 
 * Project Name:demo 
 * File Name:BaseDriverImpl.java 
 * Package Name:com.vento.at.demo.util.web 
 * Date:2018年11月7日下午5:10:21 
 * Copyright (c) 2018, www.vento.com All Rights Reserved. 
 * 
 */
package com.vento.at.demo.util.web;

/**
 * ClassName: BaseDriverImpl <br/>
 * Function: 工厂模式创建BaseDriver. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2018年11月7日 下午5:10:21 <br/>
 * 
 * @author Toly
 * @version
 * @since JDK 1.8
 */
public class BaseDriverImpl {

	/**
	 * 
	 * getBaseDriver:(工厂模式创建BaseDriver). <br/>
	 * 
	 * @author Toly
	 * @param driverName 驱动名称
	 * @return 返回BaseDriver对象， 默认为Firefox
	 * @since JDK 1.8
	 */
	private static BaseDriver getBaseDriver(String driverName) {
		if (driverName.equalsIgnoreCase("Firefox")) {
			return WebDriverFirefox.getBaseDriverInstance();
		} else if (driverName.equalsIgnoreCase("Chrome")) {
			return WebDriverChrome.getBaseDriverInstance();
		} else if (driverName.equals("IE")) {
			return WebDriverIE.getBaseDriverInstance();
		} else {
			return WebDriverFirefox.getBaseDriverInstance();
		}
	}

	public static BaseDriver getBaseDriver() {
		return getBaseDriver("Chrome");
	}
}
