package net.timandersen.web;

import net.timandersen.repository.ReservationDao;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReservationController implements Controller {

  private ReservationDao dao;

  @Override
  public ModelAndView handleRequest(HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {
    System.out.println("ReservationController.handleRequest");

    ModelAndView modelAndView = new ModelAndView("reservations");
    modelAndView.addObject("reservations", dao.findAll());
    return modelAndView;
  }

  public void setDao(ReservationDao dao) {
    this.dao = dao;
  }

}
