package com.vento.at.demo.util.web;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class BasePageTest {

  @Test
  public void getElementByKey() {

		//	
		PropertyConfigurator.configure("config/log4j.properties");
		WebDriver driver = null ;
    BasePage page = new BasePage(driver);
    page.getElementByKey("标题");
  }
}
