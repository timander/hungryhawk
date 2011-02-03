package net.timandersen.hungryhawk.fixtures;

import fitlibrary.DoFixture;
import net.timandersen.model.domain.Event;
import net.timandersen.util.MockDispatcherServlet;
import org.springframework.http.HttpMethod;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

public class PersonaLisaFixture extends DoFixture {

  public boolean plansARestaurant(Map<String, String> fields) throws Exception {
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameters(fields);
    request.addParameter("action", "save");
    request.setRequestURI("/events/add");
    //old way
    //controller().handleRequest(request, new MockHttpServletResponse());
    //return dao().findByName(fields.get("name")) != null;

    //spring dispatcher way!
    ModelAndView mav = MockDispatcherServlet.handleRequest(request, HttpMethod.POST);
    return mav.getViewName().equals("events/list");
  }

  public List<Event> reviewsScheduleOfEvents() throws Exception {
    //old way:
    //controller().handleRequest(new MockHttpServletRequest(), response);
    //return dao().findAll();

    //spring dispatcher way!
    ModelAndView mav = MockDispatcherServlet.handleRequest(new MockHttpServletRequest(), HttpMethod.GET);
    return (List<Event>) mav.getModel().get("events");
  }

//  private EventDao dao() {
//    return SpringContextWrapper.getBean(EventDao.class);
//  }
//
//  private EventController controller() {
//    return SpringContextWrapper.getBean(EventController.class);
//  }

}
