/** 
 * Project Name:demo 
 * File Name:TestStep.java 
 * Package Name:com.vento.at.demo.util.test 
 * Date:2018年11月8日下午2:42:41 
 * Copyright (c) 2018, www.vento.com All Rights Reserved. 
 * 
 */    
package com.vento.at.demo.util.test;

import com.vento.at.demo.util.web.BasePage;

/** 
 * ClassName: TestStep <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason: TODO ADD REASON(可选). <br/> 
 * date: 2018年11月8日 下午2:42:41 <br/> 
 * 
 * @author Toly 
 * @version  
 * @since JDK 1.8 
 */
abstract class TestStep {
	private Class<? extends BasePage> clazz;
	private String methodName;
	private Object[] value;
	
	public TestStep() {
		super();
	}
	
	public TestStep(Class<? extends BasePage> clazz, String methodName, Object... value) {
		super();
		this.clazz = clazz == null ? BasePage.class :clazz;
		this.methodName = methodName;
		this.value = value;
	}

	/** 
	 * clazz. 
	 * 
	 * @return  the clazz 
	 * @since   JDK 1.8
	 */
	public Class<? extends BasePage> getClazz() {
		return clazz;
	}

	/** 
	 * clazz. 
	 * 
	 * @param   clazz    the clazz to set 
	 * @since   JDK 1.8
	 */
	public void setClazz(Class<? extends BasePage> clazz) {
		this.clazz = clazz;
	}

	/** 
	 * methodKey. 
	 * 
	 * @return  the methodKey 
	 * @since   JDK 1.8
	 */
	public String getMethodName() {
		return methodName;
	}

	/** 
	 * methodKey. 
	 * 
	 * @param   methodKey    the methodKey to set 
	 * @since   JDK 1.8
	 */
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	/** 
	 * value. 
	 * 
	 * @return  the value 
	 * @since   JDK 1.8
	 */
	public Object[] getValue() {
		return value;
	}

	/** 
	 * value. 
	 * 
	 * @param   value    the value to set 
	 * @since   JDK 1.8
	 */
	public void setValue(Object[] value) {
		this.value = value;
	}
	
	public abstract boolean perform(Object... value);	
	
}
 