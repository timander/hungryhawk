package net.timandersen.model;

import junit.framework.TestCase;
import net.timandersen.model.domain.Product;

public class ProductTest extends TestCase {

  private Product product;

  protected void setUp() throws Exception {
    product = new Product();
  }

  public void testSetAndGetDescription() {
    String testDescription = "aDescription";
    assertNull(product.getDescription());
    product.setDescription(testDescription);
    assertEquals(testDescription, product.getDescription());
  }

  public void testSetAndGetPrice() {
    double testPrice = 100.00;
    assertEquals(0, 0, 0);
    product.setPrice(testPrice);
    assertEquals(testPrice, product.getPrice(), 0);
  }
  
}
