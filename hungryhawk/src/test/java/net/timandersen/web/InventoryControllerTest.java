package net.timandersen.web;

import junit.framework.TestCase;
import net.timandersen.repository.ProductRepository;
import net.timandersen.service.SimpleProductManager;
import org.mockito.Mockito;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

public class InventoryControllerTest extends TestCase {

  public void testHandleRequestView() throws Exception {
    InventoryController controller = new InventoryController();
    SimpleProductManager spm = new SimpleProductManager();
    spm.setRepository(Mockito.mock(ProductRepository.class));
    controller.setProductManager(spm);
    ModelAndView modelAndView = controller.handleRequest(null, null);
    assertEquals("hello", modelAndView.getViewName());
    assertNotNull(modelAndView.getModel());
    Map modelMap = (Map) modelAndView.getModel().get("model");
    String nowValue = (String) modelMap.get("now");
    assertNotNull(nowValue);
  }

}