package net.timandersen.model.domain;

import java.io.Serializable;
import java.util.Date;

public class Event implements Serializable {

  private Long id;
  private String name;
  private Date date;

  public Event() {
  }

  public Event(String name, Date date) {
    this.name = name;
    this.date = date;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Date getDate() {
    return date;
  }
}