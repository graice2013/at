/** 
 * Project Name:demo 
 * File Name:BaseWebTestCase.java 
 * Package Name:com.vento.at.demo.util.test 
 * Date:2018年11月8日上午9:48:08 
 * Copyright (c) 2018, www.vento.com All Rights Reserved. 
 * 
 */    
package com.vento.at.demo.util.test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;

import com.vento.at.demo.util.web.BaseBrowser;
import com.vento.at.demo.util.web.BaseDriver;
import com.vento.at.demo.util.web.BaseDriverImpl;

/** 
 * ClassName: BaseWebTestCase <br/> 
 * Function: 自定义web test case基础类. <br/> 
 * Reason: TODO ADD REASON(可选). <br/> 
 * date: 2018年11月8日 上午9:48:08 <br/> 
 * 
 * @author Toly 
 * @version  
 * @since JDK 1.8 
 */
public class BaseWebTestCase extends TestCase {

	private BaseDriver baseDriver;
	private BaseBrowser baseBrowser;
	
	/** 
	 * baseDriver. 
	 * 
	 * @return  the baseDriver 
	 * @since   JDK 1.8
	 */
	public BaseDriver getBaseDriver() {
		return baseDriver;
	}
	/** 
	 * baseBrowser. 
	 * 
	 * @return  the baseBrowser 
	 * @since   JDK 1.8
	 */
	public BaseBrowser getBaseBrowser() {
		return baseBrowser;
	}
	/** 
	 * Creates a new instance of BaseWebTestCase. 
	 *  
	 */
	public BaseWebTestCase() {
		this.baseDriver = BaseDriverImpl.getBaseDriver();
		this.baseBrowser = new BaseBrowser(this.baseDriver.getDriver());
	}
	
	@AfterSuite
	public void tearDown() {
		this.baseDriver.quit();
	}
	/** 
	 * takeSnapShot:(这里用一句话描述这个方法的作用). <br/> 
	 * TODO(这里描述这个方法适用条件 – 可选).<br/> 
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/> 
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/> 
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/> 
	 * 
	 * @author Toly
	 * @param name 
	 * @since JDK 1.8 
	 */  
	public void takeSnapShot(String name) {
		// TODO Auto-generated method stub
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		String dateStr = formatter.format(date);
		String screenName = this.getClass().getSimpleName() + "." + name + "." + dateStr + ".png";
		
		File file = new File("test-output/snapshot");
		String filePath = file.getAbsolutePath();
		String screanPath = filePath + "/" + screenName;
		
		if(!(new File(filePath).isDirectory())) {
			new File(filePath).mkdir();
		}
		
		File screen = ((TakesScreenshot) baseDriver.getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screen, new File(screanPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//System.setProperty("org.uncommons.reportng.escape-output", "false");
		Reporter.log("<a href=../snapshot/" + screenName + " target=_blank>" + this.getClass().getSimpleName() + "." + name + "截图</a>", true);
		Reporter.log("<img src=../snapshot/" + screenName + "/>", true);
	}
	
}
 