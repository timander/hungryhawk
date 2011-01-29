package net.timandersen.hungryhawk.fixtures;

import fitlibrary.DoFixture;
import net.timandersen.repository.EventRepository;
import net.timandersen.util.SpringContextWrapper;
import net.timandersen.web.EventController;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import java.util.Map;

public class PersonaLisaFixture extends DoFixture {

  public boolean plansARestaurant(Map<String, String> fields) throws Exception {
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameters(fields);
    request.addParameter("action", "save");
    SpringContextWrapper.getBean(EventController.class).handleRequest(request, new MockHttpServletResponse());
    return repository().findByName(fields.get("name")) != null;
  }

  private EventRepository repository() {
    return SpringContextWrapper.getBean(EventRepository.class);
  }

}
