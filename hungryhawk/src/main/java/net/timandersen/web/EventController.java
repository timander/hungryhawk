package net.timandersen.web;

import net.timandersen.model.domain.Event;
import net.timandersen.repository.EventDao;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

public class EventController implements Controller {

  private EventDao dao;

  @Override
  public ModelAndView handleRequest(HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {
    System.out.println("EventController.handleRequest");

    if ("save".equals(request.getParameter("action"))) {
      String name = request.getParameter("name");
      Date date = new Date(request.getParameter("date"));
      dao.save(new Event(name, date));
    }

    ModelAndView modelAndView = new ModelAndView("events");
    modelAndView.addObject("events", dao.findAll());
    return modelAndView;
  }

  public void setDao(EventDao dao) {
    this.dao = dao;
  }

}
