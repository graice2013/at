/** 
 * Project Name:demo 
 * File Name:TestCaseExecutionListener.java 
 * Package Name:com.vento.at.demo.util.test 
 * Date:2018年11月8日上午10:04:03 
 * Copyright (c) 2018, www.vento.com All Rights Reserved. 
 * 
 */    
package com.vento.at.demo.util.test;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

/** 
 * ClassName: TestCaseExecutionListener <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason: TODO ADD REASON(可选). <br/> 
 * date: 2018年11月8日 上午10:04:03 <br/> 
 * 
 * @author Toly 
 * @version  
 * @since JDK 1.8 
 */
public class TestCaseExecutionListener extends TestListenerAdapter {

	/** 
	 * TODO 简单描述该方法的实现功能（可选）. 
	 * @see org.testng.TestListenerAdapter#onTestStart(org.testng.ITestResult) 
	 */  
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("开始执行用例：【" + result.getInstance() + "】方法【" + result.getName() + "】。");
		super.onTestStart(result);		
	}
	
}
 