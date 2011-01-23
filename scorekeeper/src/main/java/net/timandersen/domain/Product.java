package net.timandersen.domain;

import java.io.Serializable;

public class Product implements Serializable {

  private Long id;
  private String description;
  private Double price;

  public void setId(Long i) {
    id = i;
  }

  public Long getId() {
    return id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public String toString() {
    StringBuffer buffer = new StringBuffer();
    buffer.append("Description: " + description + ";");
    buffer.append("Price: " + price);
    return buffer.toString();
  }

}