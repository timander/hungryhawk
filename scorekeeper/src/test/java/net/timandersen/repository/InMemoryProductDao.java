package net.timandersen.repository;

import net.timandersen.domain.Product;

import java.util.List;


public class InMemoryProductDao implements ProductDao {

  private List<Product> productList;

  public InMemoryProductDao(List<Product> productList) {
    this.productList = productList;
  }

  public List<Product> getProductList() {
    return productList;
  }

  public void saveProduct(Product prod) {
  }

}