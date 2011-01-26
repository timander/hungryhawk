package net.timandersen.model;

import junit.framework.TestCase;
import net.timandersen.model.domain.Product;
import net.timandersen.repository.ProductRepository;
import net.timandersen.service.SimpleProductManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SimpleProductManagerTest extends TestCase {

  private SimpleProductManager productManager;

  private List<Product> products;

  private static int PRODUCT_COUNT = 2;

  private static Double CHAIR_PRICE = new Double(20.50);
  private static String CHAIR_DESCRIPTION = "Chair";

  private static String TABLE_DESCRIPTION = "Table";
  private static Double TABLE_PRICE = new Double(150.10);

  private static int POSITIVE_PRICE_INCREASE = 10;
  private ProductRepository productRepository;

  protected void setUp() throws Exception {
    products = Arrays.asList(
      createProduct("Chair", CHAIR_PRICE),
      createProduct("Table", TABLE_PRICE));
    productRepository = mock(ProductRepository.class);
    productManager = new SimpleProductManager();
    productManager.setRepository(productRepository);
  }

  public void testGetProductsWithNoProducts() {
    when(productRepository.findAll()).thenReturn(null);
    assertNull(productManager.getProducts());
  }

  public void testGetProducts() {
    when(productRepository.findAll()).thenReturn(products);

    List<Product> products = productManager.getProducts();
    assertNotNull(products);
    assertEquals(PRODUCT_COUNT, productManager.getProducts().size());

    Product product = products.get(0);
    assertEquals(CHAIR_DESCRIPTION, product.getDescription());
    assertEquals(CHAIR_PRICE, product.getPrice());

    product = products.get(1);
    assertEquals(TABLE_DESCRIPTION, product.getDescription());
    assertEquals(TABLE_PRICE, product.getPrice());
  }

  public void testIncreasePriceWithNullListOfProducts() {
    when(productRepository.findAll()).thenReturn(products);
    try {
      productManager.increasePrice(POSITIVE_PRICE_INCREASE);
    } catch (NullPointerException ex) {
      fail("Products list is null.");
    }
  }

  public void testIncreasePriceWithEmptyListOfProducts() {
    when(productRepository.findAll()).thenReturn(new ArrayList<Product>());
    try {
      productManager.increasePrice(POSITIVE_PRICE_INCREASE);
    } catch (Exception ex) {
      fail("Products list is empty.");
    }
  }

  public void testIncreasePriceWithPositivePercentage() {
    when(productRepository.findAll()).thenReturn(products);
    productManager.increasePrice(POSITIVE_PRICE_INCREASE);
    double expectedChairPriceWithIncrease = 22.55;
    double expectedTablePriceWithIncrease = 165.11;

    List<Product> products = productManager.getProducts();
    Product product = products.get(0);
    assertEquals(expectedChairPriceWithIncrease, product.getPrice());

    product = products.get(1);
    assertEquals(expectedTablePriceWithIncrease, product.getPrice());
  }

  private Product createProduct(String description, Double price) {
    Product product = new Product();
    product.setDescription(description);
    product.setPrice(price);
    return product;
  }

}
