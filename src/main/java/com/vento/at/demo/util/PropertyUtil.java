/** 
 * Project Name:demo 
 * File Name:PropertyUtil.java 
 * Package Name:com.vento.at.demo.util
 * Date:2018年10月18日下午4:30:43 
 * Copyright (c) 2018, www.vento.com All Rights Reserved. 
 * 
 */

package com.vento.at.demo.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Properties;

/**
 * ClassName: PropertyUtil <br/>
 * Function: 从*.properties文件中获取配置信息，支持中文. <br/>
 * date: 2018年10月18日 下午4:30:43 <br/>
 * 
 * @author Toly
 * @version
 * @since JDK 1.8
 */

public class PropertyUtil {

	private Properties propertiesObj;
	private String filePathStr;

	/** 
	 * Creates a new instance of PropertyUtil. 
	 * .通过文件路径，初始化PropertyUtil
	 * 
	 * @param filePathStr 文件路径
	 */
	public PropertyUtil(String filePathStr) {
		super();
		File file = new File(filePathStr);
		if (!file.exists()) {
			this.filePathStr = null;
		} else {
			this.filePathStr = filePathStr;
			this.propertiesObj = getProperties();
		}
	}

	/**
	 * getProperties:(读取properties文件). <br/>
	 * 
	 * @author Toly
	 * @return
	 * @since JDK 1.8
	 */
	private Properties getProperties() {
		// TODO Auto-generated method stub
		Properties propertiesObj = new Properties();
		InputStream inputStreamObj;
		try {
			inputStreamObj = new FileInputStream(this.filePathStr);
			BufferedInputStream inputBuffer = new BufferedInputStream(inputStreamObj);
			// 支付读取中文格式
			propertiesObj.load(new InputStreamReader(inputBuffer, "utf-8"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return propertiesObj;
	}

	/**
	 * getPropertyByKey:(通过关键字获取配置文件中文本内容). <br/>
	 * 
	 * @author Toly
	 * @param key 关键字
	 * @return 返回配置文件中关键字对应值，如未找到，返回null
	 * @since JDK 1.8
	 */
	public String getPropertyByKey(String key) {
		if (this.propertiesObj != null) {
			if (this.propertiesObj.containsKey(key)) {
				String propertyValue = this.propertiesObj.getProperty(key);
				return propertyValue;
			} else {
				System.out.println("配置文件【" + this.filePathStr + "】不包含关键字【" + key + "】。");
			}
		} else {
			System.out.println("配置文件【" + this.filePathStr + "】不存在。");
		}
		return null;
	}

	/**
	 * addProperty:(添加内容到配置文件末尾). <br/>
	 * 
	 * @author Toly
	 * @param key
	 * @param value
	 * @since JDK 1.8
	 */
	public void addProperty(String key, String value) {
		Properties propertiesObj = new Properties();
		FileOutputStream fileOutputStream;
		try {
			// 追加打开文件
			fileOutputStream = new FileOutputStream(this.filePathStr, true);
			propertiesObj.setProperty(key, value);
			// 支持中文输入
			propertiesObj.store(new OutputStreamWriter(fileOutputStream, "utf-8"), key);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * saveProperty:(将关键字及内容保存到配置文件中). <br/>
	 * 
	 * @author Toly
	 * @param key
	 * @param value
	 * @since JDK 1.8
	 * 
	 * @deprecated 会把配置文件内容替换掉
	 */
	public void restoreProperty(String key, String value) {
		Properties propertiesObj = new Properties();
		FileOutputStream fileOutputStream;
		try {
			fileOutputStream = new FileOutputStream(this.filePathStr);
			propertiesObj.setProperty(key, value);
			propertiesObj.store(fileOutputStream, key);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
