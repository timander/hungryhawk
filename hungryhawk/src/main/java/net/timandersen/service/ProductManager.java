package net.timandersen.service;

import net.timandersen.model.domain.Product;

import java.util.List;

public interface ProductManager {

  public void increasePrice(int percentage);

  public List<Product> getProducts();

}
