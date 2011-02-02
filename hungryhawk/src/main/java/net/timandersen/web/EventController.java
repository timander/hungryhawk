package net.timandersen.web;

import net.timandersen.model.domain.Event;
import net.timandersen.repository.EventDao;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

public class EventController implements Controller {

  private EventDao eventDao;

  @Override
  public ModelAndView handleRequest(HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {
    System.out.println("EventController.handleRequest");

    if ("save".equals(request.getParameter("action"))) {
      String name = request.getParameter("name");
      Date date = new Date(request.getParameter("date"));
      eventDao.save(new Event(name, date));
    }

    if ("add".equals(request.getParameter("action"))) {
      ModelAndView modelAndView = new ModelAndView("events/add");
      modelAndView.addObject("event", new Event());
      return modelAndView;
    }

    ModelAndView modelAndView = new ModelAndView("events/list");
    modelAndView.addObject("events", eventDao.findAll());
    return modelAndView;
  }

  public void setEventDao(EventDao eventDao) {
    this.eventDao = eventDao;
  }

}
