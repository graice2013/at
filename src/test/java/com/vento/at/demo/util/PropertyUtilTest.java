package com.vento.at.demo.util;

import org.testng.annotations.Test;

public class PropertyUtilTest {

  @Test
  public void PropertyUtil() {
    PropertyUtil pro = new PropertyUtil("res/web.element.properties");
  }

  @Test
  public void getPropertyByKey() {
    PropertyUtil pro = new PropertyUtil("res/web.element.properties");
    String username = pro.getPropertyByKey("中文测试.中文");
    System.out.println(username);
  }
  
  @Test
  public void addProperty() {
    PropertyUtil pro = new PropertyUtil("res/web.element.properties");
    pro.addProperty("中文测试.中文", "也是中文");
    pro.addProperty("中文测试.中文测试", "asfasdfaf");
  }

  //@Test
  public void saveProperty() {
    PropertyUtil pro = new PropertyUtil("res/web.element.properties");
    pro.restoreProperty("中文测试.中文", "也是中文");
    pro.restoreProperty("中文测试.中文", "asfasdfaf");
  }
}
