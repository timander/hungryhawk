package net.timandersen.util;

import org.springframework.http.HttpMethod;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockServletConfig;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletException;

import static net.timandersen.util.SpringContextWrapper.contextConfigLocation;

public class MockDispatcherServlet extends DispatcherServlet {

  private static MockDispatcherServlet dispatcherServlet;

  public static void handleRequest(MockHttpServletRequest request, HttpMethod method) {
    try {
      if (dispatcherServlet == null) {
        lazyInit();
      }
      request.setMethod(method.name());
      System.out.println("URI=" + request.getRequestURI());
      System.out.println("method=" + request.getMethod());
      System.out.println("remoteAddr=" + request.getRemoteAddr());
//      System.out.println("username=" + request.getUserPrincipal().getName());
      dispatcherServlet.processRequest(request, new MockHttpServletResponse());
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  private static void lazyInit() throws ServletException {
    System.out.println("Initializing " + MockDispatcherServlet.class.getSimpleName());
    dispatcherServlet = new MockDispatcherServlet();
    MockServletConfig mockServletConfig = new MockServletConfig("hungryhawk");
    mockServletConfig.addInitParameter("contextConfigLocation", contextConfigLocation);
    dispatcherServlet.init(mockServletConfig);
  }

}
