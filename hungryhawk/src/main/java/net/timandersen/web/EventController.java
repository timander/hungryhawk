package net.timandersen.web;

import net.timandersen.domain.Event;
import net.timandersen.repository.EventRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/events")
public class EventController {

  private EventRepository repository;

  @RequestMapping(method = RequestMethod.GET)
  public List<Event> getAll() {
    return repository.findAll();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  @ResponseBody
  public Event getEvent(@PathVariable("id") Long eventId) {
    return repository.findById(eventId);
  }

  @RequestMapping(method = RequestMethod.POST)
  public View saveEvent(@RequestBody Event event) {
    repository.save(event);
    return new RedirectView("/events/" + event.getId());
  }

  public void setRepository(EventRepository repository) {
    this.repository = repository;
  }

}
