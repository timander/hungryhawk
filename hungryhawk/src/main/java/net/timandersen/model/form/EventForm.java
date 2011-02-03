package net.timandersen.model.form;

import net.timandersen.model.view.EventView;

import java.util.Date;
import java.util.List;

public class EventForm {

  private List<EventView> events;

  private String name;
  private Date date;

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

  public void setEvents(List<EventView> events) {
    this.events = events;
  }

}
