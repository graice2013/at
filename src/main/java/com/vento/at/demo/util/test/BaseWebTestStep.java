/** 
 * Project Name:demo 
 * File Name:BaseWebTestStep.java 
 * Package Name:com.vento.at.demo.util.test 
 * Date:2018年11月8日下午2:58:39 
 * Copyright (c) 2018, www.vento.com All Rights Reserved. 
 * 
 */
package com.vento.at.demo.util.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.WebDriver;

import com.vento.at.demo.util.web.BaseDriverImpl;
import com.vento.at.demo.util.web.BasePage;

/**
 * ClassName: BaseWebTestStep <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2018年11月8日 下午2:58:39 <br/>
 * 
 * @author Toly
 * @version
 * @since JDK 1.8
 */
public class BaseWebTestStep extends TestStep {

	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * 
	 * @see com.vento.at.demo.util.test.TestStep#perform(java.lang.Object[])
	 */
	@Override
	public boolean perform(Object... value) {

		Class<? extends BasePage> clazz = this.getClazz();
		Constructor<? extends BasePage> constructor = null;

		try {
			constructor = clazz.getConstructor(WebDriver.class);
			BasePage obj;

			obj = constructor.newInstance(BaseDriverImpl.getBaseDriver());
			if (obj.perform(this.getMethodName(), value) != null) {
				return true;
			}
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		return false;
	}

}
