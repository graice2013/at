/** 
 * Project Name:demo 
 * File Name:BaiDuTest.java 
 * Package Name:com.vento.at.demo.baidu 
 * Date:2018年11月8日下午4:04:44 
 * Copyright (c) 2018, www.vento.com All Rights Reserved. 
 * 
 */    
package com.vento.at.demo.baidu;


import org.apache.commons.logging.Log;
import org.apache.log.Logger;
import org.testng.annotations.Test;

import com.vento.at.demo.baidu.page.SearchPage;
import com.vento.at.demo.util.test.BaseWebTestCase;

/** 
 * ClassName: BaiDuTest <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason: TODO ADD REASON(可选). <br/> 
 * date: 2018年11月8日 下午4:04:44 <br/> 
 * 
 * @author Toly 
 * @version  
 * @since JDK 1.8 
 */
public class BaiDuTest extends BaseWebTestCase {

	public SearchPage searchPage;

	/** 
	 * Creates a new instance of BaiDuTest. 
	 *  
	 */
	public BaiDuTest() {
		super();
		// TODO Auto-generated constructor stub
		searchPage = new SearchPage(this.getBaseDriver().getDriver());
	}
	
	@Test
	public void testSearch() {
		searchPage.accessURL("http://www.baidu.com");
		logger.info(searchPage.search("TESTNG"));		
	}
	
}
 