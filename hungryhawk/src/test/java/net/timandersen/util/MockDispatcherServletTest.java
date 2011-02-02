package net.timandersen.util;

import org.junit.Test;
import org.springframework.http.HttpMethod;
import org.springframework.mock.web.MockHttpServletRequest;

public class MockDispatcherServletTest {

  @Test
  public void testDispatcherServletInitialization() {
    MockDispatcherServlet.handleRequest(new MockHttpServletRequest(), HttpMethod.GET);
  }
  
}
