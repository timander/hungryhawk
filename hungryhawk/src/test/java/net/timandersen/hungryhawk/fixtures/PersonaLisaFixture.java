package net.timandersen.hungryhawk.fixtures;

import fitlibrary.DoFixture;
import net.timandersen.model.domain.Event;
import net.timandersen.model.form.EventForm;
import net.timandersen.util.MockDispatcherServlet;
import org.springframework.http.HttpMethod;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PersonaLisaFixture extends DoFixture {

  public boolean plansARestaurant(Map<String, String> fields) throws Exception {
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameters(fields);
    request.setRequestURI("/events/save");
    ModelAndView mav = MockDispatcherServlet.handleRequest(request, HttpMethod.POST);
    String viewName = mav.getViewName();
    return viewName.equals("/events/list");
  }

  public List<Event> reviewsScheduleOfEvents() throws Exception {
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setRequestURI("/events");
    ModelAndView mav = MockDispatcherServlet.handleRequest(request, HttpMethod.GET);

    if (mav == null) {
      return new ArrayList<Event>();
    } else {
      return ((EventForm) mav.getModel().get("command")).getEvents();
    }

  }

}
