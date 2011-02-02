package net.timandersen.hungryhawk.fixtures;

import fitlibrary.DoFixture;
import net.timandersen.model.domain.Reservation;
import net.timandersen.repository.EventDao;
import net.timandersen.repository.ReservationDao;
import net.timandersen.util.SpringContextWrapper;

import java.util.Date;

public class PersonaVickiFixture extends DoFixture {

  public boolean makesAReservationForWithGuests(Date date, int guests) {
    Reservation reservation = new Reservation();
    reservation.setName("Vicki");
    reservation.setGuests(guests);
    reservation.setEvent(eventDao().findByDate(date));
    reservationDao().save(reservation);
    return true;
  }

  private EventDao eventDao() {
    return SpringContextWrapper.getBean(EventDao.class);
  }

  private ReservationDao reservationDao() {
    return SpringContextWrapper.getBean(ReservationDao.class);
  }

  public boolean receivesConfirmation() {
    return true;
  }

}
