package net.timandersen.web;

import junit.framework.TestCase;
import net.timandersen.domain.Product;
import net.timandersen.repository.InMemoryProductDao;
import net.timandersen.service.SimpleProductManager;
import net.timandersen.web.InventoryController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Map;

public class InventoryControllerTest extends TestCase {

  public void testHandleRequestView() throws Exception {
    InventoryController controller = new InventoryController();
    SimpleProductManager spm = new SimpleProductManager();
    spm.setProductDao(new InMemoryProductDao(new ArrayList<Product>()));
    controller.setProductManager(spm);
    //controller.setProductManager(new SimpleProductManager());
    ModelAndView modelAndView = controller.handleRequest(null, null);
    assertEquals("hello", modelAndView.getViewName());
    assertNotNull(modelAndView.getModel());
    Map modelMap = (Map) modelAndView.getModel().get("model");
    String nowValue = (String) modelMap.get("now");
    assertNotNull(nowValue);
  }
  
}