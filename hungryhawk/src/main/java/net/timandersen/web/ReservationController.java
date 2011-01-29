package net.timandersen.web;

import net.timandersen.repository.ReservationRepository;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReservationController implements Controller {

  private ReservationRepository repository;

  @Override
  public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
    System.out.println("ReservationController.handleRequest");
    ModelAndView modelAndView = new ModelAndView("reservations");
    modelAndView.addObject("reservations", repository.findAll());
    return modelAndView;
  }

  public void setRepository(ReservationRepository repository) {
    this.repository = repository;
  }

}
