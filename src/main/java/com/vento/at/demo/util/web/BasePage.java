/** 
 * Project Name:demo 
 * File Name:BasePage.java 
 * Package Name:com.vento.at.demo.util.web 
 * Date:2018年10月19日上午10:26:02 
 * Copyright (c) 2018, www.vento.com All Rights Reserved. 
 * 
 */
package com.vento.at.demo.util.web;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ClassName: BasePage <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2018年10月19日 上午10:26:02 <br/>
 * 
 * @author Toly
 * @version
 * @since JDK 1.8
 */
public class BasePage extends BaseBrowser {

	protected String pageName;

	public BasePage(WebDriver driver) {
		super(driver);
	}
	
	public BasePage(BaseDriver baseDriver) {
		super(baseDriver.getDriver());
	}

	public WebElement element(By by) {
		WebElement element = driver.findElement(by);
		return element;
	}

	public WebElement element(String elementAliasName) {
		return this.element(this.getLocator(elementAliasName));
	}

	private By getLocator(String elementAliasName) {
		return ElementLocator.getLocator(this.getClass().getPackage().getName(), this.getClass().getName(),
				elementAliasName);
	}

	public List<WebElement> elements(By by) {
		return driver.findElements(by);
	}

	@Action(name = "click")
	public void click(String elementAliasName) {
		WebElement element = element(elementAliasName);
		if (element != null) {
			element.click();
		} else {
			logger.error("元素定位失败{}.{}。click未执行", this.getClass().getSimpleName(), elementAliasName);
		}
	}

	@Action(name = "clear")
	public void clear(String elementAliasName) {
		WebElement element = element(elementAliasName);
		if (element != null) {
			element.clear();
		} else {
			logger.error("元素定位失败{}.{}。clear未执行", this.getClass().getSimpleName(), elementAliasName);
		}
	}

	@Action(name = "sendKeys")
	public void sendKeys(String elementAliasName, String value) {
		WebElement element = element(elementAliasName);
		if (element != null) {
			element.sendKeys(value);
		} else {
			logger.error("元素定位失败{}.{}。sendKeys未执行", this.getClass().getSimpleName(), elementAliasName);
		}
	}

	@Action(name = "isDisplayed")
	public boolean isDisplayed(String elementAliasName) {
		WebElement element = element(elementAliasName);
		if (element != null) {
			return element.isDisplayed();
		} else {
			logger.error("元素定位失败{}.{}。isDisplayed未执行", this.getClass().getSimpleName(), elementAliasName);
		}
		return false;
	}

	@Action(name = "getText")
	public String getText(String elementAliasName) {
		WebElement element = element(elementAliasName);
		if (element != null) {
			return element.getText();
		} else {
			logger.error("元素定位失败{}.{}。getText未执行", this.getClass().getSimpleName(), elementAliasName);
		}
		return null;
	}

	@Action(name = "switchToTopFrame")
	public void switchToTopFrame() {
		this.driver.switchTo().defaultContent();
	}

	@Action(name = "switchToParentFrame")
	public void switchToParentFrame() {
		this.driver.switchTo().parentFrame();
	}

	@Action(name = "switchToFrame")
	public void switchToFrame(String elementAliasName) {
		WebElement element = element(elementAliasName);
		if (element != null) {
			this.driver.switchTo().frame(elementAliasName);
		} else {
			logger.error("元素定位失败{}.{}。sendKeys未执行", this.getClass().getSimpleName(), elementAliasName);
		}
	}

	@Action(name = "select")
	public void select(String elementAliasName, String text) {
		WebElement element = element(elementAliasName);
		if (element != null) {
			new Select(element).selectByVisibleText(text);
		} else {
			logger.error("元素定位失败{}.{}。sendKeys未执行", this.getClass().getSimpleName(), elementAliasName);
		}
	}

	public Method getCustomerMethodByName(String methodName) {
		Method[] methods = this.getClass().getMethods();
		for (Method method : methods) {
			Action action = method.getAnnotation(Action.class);
			if (action != null && action.name().equals(methodName)) {
				return method;
			}
		}
		return null;
	}

	public Object perform(String methodName, Object... args) {
		Method method = this.getCustomerMethodByName(methodName);
		try {
			return method.invoke(this, args);
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
