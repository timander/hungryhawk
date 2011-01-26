package net.timandersen.web;

import net.timandersen.model.form.EventEntryForm;
import net.timandersen.model.view.EventView;
import net.timandersen.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class EventController {

  @Autowired
  private EventRepository repository;

  public EventController() {
    System.out.println("EventController.EventController");
  }

  // url = /hungryhawk/events
  @RequestMapping(value = "/events", method = RequestMethod.GET)
  public String showAllEvents(ModelMap model) {
    System.out.println("EventController.showAllEvents");
    List<EventView> events = EventView.createListFrom(repository.findAll());
    EventEntryForm form = new EventEntryForm();
    form.setEvents(events);
    model.addAttribute("eventEntryForm", form);
    return "listevents";
  }

  // url = /hungryhawk/events/add
  @RequestMapping(value = "/events/add", method = RequestMethod.GET)
  public String showAddUser(ModelMap model) {
    System.out.println("EventController.showAddUser");
    EventView form = new EventView();
    model.addAttribute("eventView", form);
    return "addevent";
  }

  public void setRepository(EventRepository repository) {
    this.repository = repository;
  }

}
