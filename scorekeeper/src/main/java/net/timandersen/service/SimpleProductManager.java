package net.timandersen.service;

import net.timandersen.domain.Product;
import net.timandersen.domain.ProductManager;
import net.timandersen.repository.ProductRepository;

import java.util.List;

public class SimpleProductManager implements ProductManager {

  private ProductRepository repository;

  public List<Product> getProducts() {
    return repository.findAll();
  }

  public void increasePrice(int percentage) {
    List<Product> products = repository.findAll();
    if (products != null) {
      for (Product product : products) {
        double newPrice = product.getPrice().doubleValue() * (100 + percentage) / 100;
        product.setPrice(newPrice);
        repository.save(product);
      }
    }
  }

  public void setRepository(ProductRepository repository) {
    this.repository = repository;
  }

}