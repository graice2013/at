/** 
 * Project Name:demo 
 * File Name:WebTestCaseSnapShotListener.java 
 * Package Name:com.vento.at.demo.util.test 
 * Date:2018年11月8日上午10:07:38 
 * Copyright (c) 2018, www.vento.com All Rights Reserved. 
 * 
 */    
package com.vento.at.demo.util.test;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

/** 
 * ClassName: WebTestCaseSnapShotListener <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason: TODO ADD REASON(可选). <br/> 
 * date: 2018年11月8日 上午10:07:38 <br/> 
 * 
 * @author Toly 
 * @version  
 * @since JDK 1.8 
 */
public class WebTestCaseSnapShotListener extends TestListenerAdapter {

	/** 
	 * TODO 简单描述该方法的实现功能（可选）. 
	 * @see org.testng.TestListenerAdapter#onTestSuccess(org.testng.ITestResult) 
	 */  
	@Override
	public void onTestSuccess(ITestResult tr) {
		// TODO Auto-generated method stub
		super.onTestSuccess(tr);
		this.takeSnapShot(tr);
	}

	/** 
	 * TODO 简单描述该方法的实现功能（可选）. 
	 * @see org.testng.TestListenerAdapter#onTestFailure(org.testng.ITestResult) 
	 */  
	@Override
	public void onTestFailure(ITestResult tr) {
		// TODO Auto-generated method stub
		super.onTestFailure(tr);
		this.takeSnapShot(tr);
	}

	private void takeSnapShot(ITestResult tr) {
		BaseWebTestCase testCase = (BaseWebTestCase) tr.getInstance();
		testCase.takeSnapShot(tr.getName());
	}
}
 