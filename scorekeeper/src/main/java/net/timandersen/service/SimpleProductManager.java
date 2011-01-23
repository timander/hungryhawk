package net.timandersen.service;

import net.timandersen.domain.Product;
import net.timandersen.domain.ProductManager;
import net.timandersen.repository.ProductDao;

import java.util.List;

public class SimpleProductManager implements ProductManager {

  private ProductDao productDao;

  public List<Product> getProducts() {
    return productDao.getProductList();
  }

  public void increasePrice(int percentage) {
    List<Product> products = productDao.getProductList();
    if (products != null) {
      for (Product product : products) {
        double newPrice = product.getPrice().doubleValue() *
          (100 + percentage) / 100;
        product.setPrice(newPrice);
        productDao.saveProduct(product);
      }
    }
  }

  public void setProductDao(ProductDao productDao) {
    this.productDao = productDao;
  }

}