/** 
 * Project Name:demo 
 * File Name:TestCase.java 
 * Package Name:com.vento.at.demo.util.test 
 * Date:2018年11月8日下午2:42:22 
 * Copyright (c) 2018, www.vento.com All Rights Reserved. 
 * 
 */    
package com.vento.at.demo.util.test; 
/** 
 * ClassName: TestCase <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason: TODO ADD REASON(可选). <br/> 
 * date: 2018年11月8日 下午2:42:22 <br/> 
 * 
 * @author Toly 
 * @version  
 * @since JDK 1.8 
 */

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestCase {
	protected static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	private ArrayList<TestStep> steps;
	
	public TestCase() {
		super();
		this.steps = new ArrayList<>();
	}
	
	public ArrayList<TestStep> getSteps() {
		return steps;
	}
	
	public void setSteps(ArrayList<TestStep> steps) {
		this.steps = steps;
	}
	
	public void addStep(TestStep step) {
		this.steps.add(step);
	}

	// 自定义测试用例与测试参数分离
	public void perform(TestParameter parameter) {		
		for (TestStep step : steps) {
			// 用例参数，可能为参数名
			Object[] colValue = step.getValue();
			// 用例实际参数取值
			Object[] value = new Object[colValue.length];
			Boolean isParameterName = false;
			if (parameter != null) {
				for (int i=0; i<value.length; i++) {
					String key = value[i].toString();
					// 用例参数，可能为参数名
					colValue[i] = key;
					if (key.startsWith("${") && key.endsWith("}")) {
						isParameterName = true;
						// 提取参数名
						Object v = parameter.get(key.substring(2,key.length()-1));
						// 通过参数名提取参数值
						value[i] = v == null ? value[i] : v;
					}
				}
			}
			if (!step.perform(value)) {
				//执行失败
			}
			if (isParameterName) {
				step.setValue(value);
			}
		}
	}
	
	// 自定义测试用例与测试参数分离
	public void perform(List<TestParameter> parameters) {		
		for (TestParameter parameter : parameters) {
			this.perform(parameter);
		}
	}
}
 