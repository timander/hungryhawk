package net.timandersen.hungryhawk.fixtures;

import fitlibrary.DoFixture;
import net.timandersen.model.domain.Reservation;
import net.timandersen.repository.ReservationDao;
import net.timandersen.util.SpringContextWrapper;

import java.util.Date;
import java.util.List;

public class PersonaHannaFixture extends DoFixture {

  public List<Reservation> reviewsReservationsFor(Date date) {
    return SpringContextWrapper.getBean(ReservationDao.class).findAll();
  }

  public boolean sendsConfirmations() {
    return true;
  }

}
