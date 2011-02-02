package net.timandersen.web;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.Locale;

public class HungryHawkViewResolver extends InternalResourceViewResolver {

  @Override
  protected View loadView(String viewName, Locale locale) throws Exception {
    System.out.println("viewName = " + viewName);
    View view = super.loadView(viewName, locale);
    System.out.println("view = " + view);
    return view;
  }

  @Override
  protected String[] getViewNames() {
    String[] viewNames = super.getViewNames();
    System.out.println("viewNames = " + viewNames);
    return viewNames;
  }
}
