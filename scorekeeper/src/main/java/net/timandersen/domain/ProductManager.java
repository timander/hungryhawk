package net.timandersen.domain;

import java.util.List;

public interface ProductManager {

  public void increasePrice(int percentage);

  public List<Product> getProducts();

}
