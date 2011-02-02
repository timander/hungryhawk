package net.timandersen.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringContextWrapper {

  private static ApplicationContext springContext;


  public static <T> T getBean(String beanName, Class<T> beanClass) {
    return getSpringContext().getBean(beanName, beanClass);
  }


  public static <T> T getBean(Class<T> beanClass) {
    return getSpringContext().getBean(beanClass);
  }


  private SpringContextWrapper() {
  }

  public static synchronized ApplicationContext getSpringContext() {
    if (springContext == null) {
      springContext = new ClassPathXmlApplicationContext("contexts/application-context.xml");
    }
    return springContext;
  }

}