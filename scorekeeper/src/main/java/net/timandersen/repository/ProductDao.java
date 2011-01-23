package net.timandersen.repository;

import net.timandersen.domain.Product;

import java.util.List;


public interface ProductDao {

    public List<Product> getProductList();

    public void saveProduct(Product prod);

}