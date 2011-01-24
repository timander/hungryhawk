package net.timandersen.hungryhawk.fixtures;

import fitlibrary.DoFixture;
import net.timandersen.domain.Event;
import net.timandersen.repository.EventRepository;
import net.timandersen.util.SpringContextWrapper;

import java.util.Date;

public class PersonaLisaFixture extends DoFixture {

  public boolean plansARestaurant(RestaurantFields fields) {
    Event event = new Event(fields.getName(), new Date(fields.getDate()));
    SpringContextWrapper.getBean(EventRepository.class).save(event);
    Event found = SpringContextWrapper.getBean(EventRepository.class).findByName(fields.getName());
    return found.getId() != null;
  }

}
