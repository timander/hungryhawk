package net.timandersen.model.form;

import net.timandersen.model.domain.Event;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EventForm {

  private List<Event> events = new ArrayList<Event>();
  private String name;
  private Date date;

  public EventForm(Event event) {
    this.name = event.getName();
    this.date = event.getDate();
  }

  public EventForm() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public void setEvents(List<Event> events) {
    this.events = events;
  }

  public List<Event> getEvents() {
    return events;
  }

}
