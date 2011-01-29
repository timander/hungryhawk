package net.timandersen.web;

import net.timandersen.model.domain.Event;
import net.timandersen.repository.EventRepository;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

public class EventController implements Controller {

  private EventRepository repository;

  @Override
  public ModelAndView handleRequest(HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {
    System.out.println("EventController.handleRequest");

    if ("save".equals(request.getParameter("action"))) {
      String name = request.getParameter("name");
      Date date = new Date(request.getParameter("date"));
      repository.save(new Event(name, date));
    }

    ModelAndView modelAndView = new ModelAndView("events");
    modelAndView.addObject("events", repository.findAll());
    return modelAndView;
  }

  public void setRepository(EventRepository repository) {
    this.repository = repository;
  }

}
