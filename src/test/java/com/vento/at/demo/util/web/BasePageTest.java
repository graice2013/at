package com.vento.at.demo.util.web;

import org.testng.annotations.Test;

public class BasePageTest {

  @Test
  public void getElementByKey() {
    BasePage page = new BasePage();
    page.getElementByKey("标题");
  }
}
