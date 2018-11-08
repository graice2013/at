/** 
 * Project Name:demo 
 * File Name:TestParameter.java 
 * Package Name:com.vento.at.demo.util.test 
 * Date:2018年11月8日下午2:42:54 
 * Copyright (c) 2018, www.vento.com All Rights Reserved. 
 * 
 */
package com.vento.at.demo.util.test;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: TestParameter <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2018年11月8日 下午2:42:54 <br/>
 * 
 * @author Toly
 * @version
 * @since JDK 1.8
 */
public class TestParameter {

	private Map<String, Object> parameter;

	public TestParameter() {
		super();
		this.parameter = new HashMap<>();
	}

	public void add(String key, Object value) {
		this.parameter.put(key, value);
	}

	public void remove(String key) {
		this.parameter.remove(key);
	}

	public Object get(String key) {
		return this.parameter.get(key);
	}
}
