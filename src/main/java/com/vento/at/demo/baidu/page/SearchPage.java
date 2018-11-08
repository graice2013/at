/** 
 * Project Name:demo 
 * File Name:SearchPage.java 
 * Package Name:com.vento.at.demo.baidu 
 * Date:2018年11月8日下午3:47:19 
 * Copyright (c) 2018, www.vento.com All Rights Reserved. 
 * 
 */
package com.vento.at.demo.baidu.page;

import org.openqa.selenium.WebDriver;

import com.vento.at.demo.util.web.Action;
import com.vento.at.demo.util.web.BasePage;

/**
 * ClassName: SearchPage <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2018年11月8日 下午3:47:19 <br/>
 * 
 * @author Toly
 * @version
 * @since JDK 1.8
 */
public class SearchPage extends BasePage {

	/**
	 * Creates a new instance of SearchPage.
	 * 
	 * @param driver
	 */
	public SearchPage(WebDriver driver) {
		super(driver);
		pageName = "百度首页";
		// TODO Auto-generated constructor stub
	}

	@Action(name = "search")
	public String search(String searchText) {
		this.sendKeys("查询输入", searchText);
		this.click("百度一下");
		this.isDisplayed("结果链接1");
		return this.getText("结果链接1");
	}
}