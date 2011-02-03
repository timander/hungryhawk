package net.timandersen.util;

import org.springframework.http.HttpMethod;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockServletConfig;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static net.timandersen.util.SpringContextWrapper.contextConfigLocation;

public class MockDispatcherServlet extends DispatcherServlet {

  private static MockDispatcherServlet dispatcherServlet;
  private static ModelAndView lastModelAndView;

  public static ModelAndView handleRequest(MockHttpServletRequest request, HttpMethod method) {
    try {
      if (dispatcherServlet == null) {
        lazyInit();
      }
      request.setMethod(method.name());
//      System.out.println("URI=" + request.getRequestURI());
//      System.out.println("method=" + request.getMethod());
//      System.out.println("remoteAddr=" + request.getRemoteAddr());
//      System.out.println("username=" + request.getUserPrincipal().getName());
      MockHttpServletResponse response = new MockHttpServletResponse();
      dispatcherServlet.processRequest(request, response);
      return lastModelAndView;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  protected void render(ModelAndView mv, HttpServletRequest request, HttpServletResponse response) throws Exception {
    lastModelAndView = mv;
//    System.out.println("intercepted ModelAndView");
    super.render(mv, request, response);
  }

  private static void lazyInit() throws ServletException {
//    System.out.println("Initializing " + MockDispatcherServlet.class.getSimpleName());
    dispatcherServlet = new MockDispatcherServlet();
    MockServletConfig mockServletConfig = new MockServletConfig("hungryhawk");
    mockServletConfig.addInitParameter("contextConfigLocation", contextConfigLocation);
    dispatcherServlet.init(mockServletConfig);
  }

}
