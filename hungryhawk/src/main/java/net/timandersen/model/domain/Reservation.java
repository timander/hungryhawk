package net.timandersen.model.domain;

public class Reservation {

  private Long id;
  private String name;
  private Integer guests;
  private Event event;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getGuests() {
    return guests;
  }

  public void setGuests(Integer guests) {
    this.guests = guests;
  }

  public Event getEvent() {
    return event;
  }

  public void setEvent(Event event) {
    this.event = event;
  }
}
