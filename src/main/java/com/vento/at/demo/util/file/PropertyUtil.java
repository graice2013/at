/** 
 * Project Name:demo 
 * File Name:PropertyUtil.java 
 * Package Name:com.vento.at.demo.util.file 
 * Date:2018年11月7日下午4:52:46 
 * Copyright (c) 2018, www.vento.com All Rights Reserved. 
 * 
 */
package com.vento.at.demo.util.file;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Properties;

/**
 * ClassName: PropertyUtil <br/>
 * Function: 对*.properties文件进行操作. <br/>
 * date: 2018年11月7日 下午4:52:46 <br/>
 * 
 * @author Toly
 * @version
 * @since JDK 1.8
 */
public class PropertyUtil {

	private Properties proptertyTable;
	private String filePath;

	/**
	 * Creates a new instance of PropertyUtil.
	 * 
	 * @param filePath
	 */
	public PropertyUtil(String filePath) {
		this.filePath = filePath;
		this.proptertyTable = this.getProperties();
	}

	private Properties getProperties() {
		Properties properties = new Properties();
		try {
			InputStream inputStream = new FileInputStream(this.filePath);
			BufferedInputStream in = new BufferedInputStream(inputStream);
			properties.load(new InputStreamReader(in, "uft-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}

	/**
	 * 
	 * getPropertyByKey:(通过key获取值). <br/>
	 * 
	 * @author Toly
	 * @param key 关键字
	 * @return 如未找到，返回null
	 * @since JDK 1.8
	 */
	public String getPropertyByKey(String key) {
		if (this.proptertyTable.containsKey(key)) {
			String keyValue = this.proptertyTable.getProperty(key);
			return keyValue;
		} else {
			System.out.println("配置文件【" + this.filePath + "】中不包含关键字【" + key + "】。");
			return null;
		}
	}

	/**
	 * 
	 * addProperty:(在配置文件末尾添加参数). <br/>
	 * 
	 * @author Toly
	 * @param key
	 * @param keyValue
	 * @since JDK 1.8
	 */
	public void addProperty(String key, String keyValue) {
		Properties pro = new Properties();
		try {
			FileOutputStream file = new FileOutputStream(this.filePath, true);
			pro.setProperty(key, keyValue);
			pro.store(new OutputStreamWriter(file, "utf-8"), key);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
