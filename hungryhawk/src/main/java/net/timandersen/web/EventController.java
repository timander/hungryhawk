package net.timandersen.web;

import net.timandersen.model.domain.Event;
import net.timandersen.model.form.EventForm;
import net.timandersen.repository.EventDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class EventController {

  @Autowired
  private EventDao eventDao;

  @ModelAttribute
  public EventForm newRequest(@RequestParam(required = false) Long id) {
    System.out.println("EventController.newRequest");
    EventForm eventForm = new EventForm();
    if (id != null) {
      Event event = eventDao.findById(id);
      eventForm.setName(event.getName());
      eventForm.setDate(event.getDate());
    } else {
      eventForm.setEvents(eventDao.findAll());
    }
    System.out.println("eventForm.getEvents().size() = " + eventForm.getEvents().size());
    return eventForm;
  }

  // url = /hungryhawk/events
  @RequestMapping(value = "/events", method = RequestMethod.GET)
  public String listEvents(ModelMap model) {
    System.out.println("EventController.listEvents");
    List<Event> events = eventDao.findAll();
    EventForm form = new EventForm();
    form.setEvents(events);
    model.addAttribute("command", form);
    return "/events/list";
  }

  // url = /hungryhawk/events/add
  @RequestMapping(value = "/events/add", method = RequestMethod.GET)
  public String newEvent(ModelMap model) {
    System.out.println("EventController.newEvent");
    EventForm form = new EventForm();
    model.addAttribute("command", form);
    return "/events/add";
  }

  // url = /hungryhawk/events/show/{1}
  @RequestMapping(value = "/events/show/{eventId}", method = RequestMethod.GET)
  public String showEvent(@RequestParam Long eventId, ModelMap model) {
    Event event = eventDao.findById(eventId);
    EventForm form = new EventForm();
    form.setName(event.getName());
    form.setDate(event.getDate());
    model.addAttribute("command", form);
    return "/events/show";
  }

  // url = /hungryhawk/events/save
  @RequestMapping(value = "/events/save", method = RequestMethod.POST)
  public String saveEvent(EventForm incomingForm, BindingResult result, ModelMap model) {
    Event event = new Event(incomingForm.getName(), incomingForm.getDate());
    eventDao.save(event);
    EventForm form = new EventForm();
    form.setEvents(eventDao.findAll());
    model.addAttribute("command", form);
    return "/events/show";
  }

}
