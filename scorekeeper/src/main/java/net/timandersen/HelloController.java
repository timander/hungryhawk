package net.timandersen;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class HelloController implements Controller {

  protected final Log logger = LogFactory.getLog(getClass());

  public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

    String now = (new Date()).toString();
    logger.info("Returning hello view with " + now);

    return new ModelAndView("hello", "now", now);
  }

}